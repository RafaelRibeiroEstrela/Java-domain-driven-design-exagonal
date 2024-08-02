package com.example.domaindrivendesign.repositories.impl;

import com.example.domaindrivendesign.models.Person;
import com.example.domaindrivendesign.repositories.PersonRepository;
import com.example.domaindrivendesign.entities.PersonEntity;
import com.example.domaindrivendesign.repositories.framework.PersonJpaRepository;
import com.example.domaindrivendesign.repositories.excetpions.DatabaseException;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class PersonRepositoryImpl implements PersonRepository {

    private final PersonJpaRepository personJpaRepository;

    public PersonRepositoryImpl(PersonJpaRepository personJpaRepository) {
        this.personJpaRepository = personJpaRepository;
    }

    @Override
    public Page<Person> findAll(Pageable pageable) {
        return personJpaRepository.findAll(pageable).map(PersonEntity::toPerson);
    }

    @Override
    public List<Person> findAll() {
        return personJpaRepository.findAll().stream().map(PersonEntity::toPerson).toList();
    }

    @Override
    public Optional<Person> findById(long id) {
        return personJpaRepository.findById(id).map(PersonEntity::toPerson);
    }

    @Override
    public Optional<Person> findByName(String name) {
        return personJpaRepository.findByName(name).map(PersonEntity::toPerson);
    }

    @Override
    public Person save(Person person) {
        PersonEntity personEntity = new PersonEntity(person);
        personEntity = personJpaRepository.save(personEntity);
        return personEntity.toPerson();
    }

    @Override
    public void delete(long id) {
        try {
            personJpaRepository.deleteById(id);
        } catch (ConstraintViolationException e) {
            throw new DatabaseException("Erro de constraint: " + e.getMessage());
        }
    }

}
