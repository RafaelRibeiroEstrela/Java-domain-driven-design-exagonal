package com.example.domaindrivendesign.domain.services.impl;

import com.example.domaindrivendesign.domain.dtos.PersonDTO;
import com.example.domaindrivendesign.domain.models.Person;
import com.example.domaindrivendesign.domain.repositories.PersonRepository;
import com.example.domaindrivendesign.domain.services.PersonService;
import com.example.domaindrivendesign.domain.services.exceptions.ResourceNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

@AllArgsConstructor
public class PersonServiceImpl implements PersonService {

    private final PersonRepository personRepository;

    @Override
    public Page<PersonDTO> findAll(Pageable pageable) {
        Page<Person> page = personRepository.findAll(pageable);
        if (page.isEmpty()) {
            throw new ResourceNotFoundException("Nenhuma pessoa encontrada");
        }
        return page.map(PersonDTO::new);
    }

    @Override
    public List<PersonDTO> findAll() {
        List<Person> list = personRepository.findAll();
        if (list.isEmpty()) {
            throw new ResourceNotFoundException("Nenhuma pessoa encontrada");
        }
        return list.stream().map(PersonDTO::new).toList();
    }

    @Override
    public PersonDTO findById(long id) {
        Person person = personRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Nenhuma pessoa encontrada"));
        return new PersonDTO(person);
    }

    @Override
    public PersonDTO save(PersonDTO personDTO) {
        Person person = new Person();
        personDTO.copyToPerson(person);
        person = personRepository.save(person);
        return new PersonDTO(person);
    }

    @Override
    public PersonDTO update(PersonDTO personDTO, long id) {
        Person person = findById(id).toPerson();
        personDTO.copyToPerson(person);
        person = personRepository.update(person);
        return new PersonDTO(person);
    }

    @Override
    public void delete(long id) {
        try {
            personRepository.delete(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException("Nenhuma pessoa encontrada");
        }
    }
}
