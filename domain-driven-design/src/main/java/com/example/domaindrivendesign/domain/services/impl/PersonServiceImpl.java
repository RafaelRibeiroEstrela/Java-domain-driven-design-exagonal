package com.example.domaindrivendesign.domain.services.impl;

import com.example.domaindrivendesign.application.dtos.PersonDTO;
import com.example.domaindrivendesign.domain.models.Person;
import com.example.domaindrivendesign.domain.services.PersonService;
import com.example.domaindrivendesign.domain.services.exceptions.ResourceNotFoundException;
import com.example.domaindrivendesign.infrastructure.repositories.PersonRepository;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public class PersonServiceImpl implements PersonService {

    private final PersonRepository personRepositoryPort;

    public PersonServiceImpl(PersonRepository personRepositoryPort) {
        this.personRepositoryPort = personRepositoryPort;
    }

    @Override
    public Page<PersonDTO> findAll(Pageable pageable) {
        Page<Person> page = personRepositoryPort.findAll(pageable);
        if (page.isEmpty()) {
            throw new ResourceNotFoundException("Nenhuma pessoa encontrada");
        }
        return page.map(PersonDTO::new);
    }

    @Override
    public List<PersonDTO> findAll() {
        List<Person> list = personRepositoryPort.findAll();
        if (list.isEmpty()) {
            throw new ResourceNotFoundException("Nenhuma pessoa encontrada");
        }
        return list.stream().map(PersonDTO::new).toList();
    }

    @Override
    public PersonDTO findById(long id) {
        Person person = personRepositoryPort.findById(id).orElseThrow(() -> new ResourceNotFoundException("Nenhuma pessoa encontrada"));
        return new PersonDTO(person);
    }

    @Override
    public PersonDTO save(PersonDTO personDTO) {
        Person person = new Person();
        personDTO.copyToPerson(person);
        person = personRepositoryPort.save(person);
        return new PersonDTO(person);
    }

    @Override
    public PersonDTO update(PersonDTO personDTO, long id) {
        Person person = findById(id).toPerson();
        personDTO.copyToPerson(person);
        person = personRepositoryPort.update(person);
        return new PersonDTO(person);
    }

    @Override
    public void delete(long id) {
        try {
            personRepositoryPort.delete(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException("Nenhuma pessoa encontrada");
        }
    }
}
