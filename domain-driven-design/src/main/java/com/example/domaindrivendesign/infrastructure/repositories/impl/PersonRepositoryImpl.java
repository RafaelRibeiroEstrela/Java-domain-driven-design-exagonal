package com.example.domaindrivendesign.infrastructure.repositories.impl;

import com.example.domaindrivendesign.domain.models.Person;
import com.example.domaindrivendesign.domain.repositories.PersonRepository;
import com.example.domaindrivendesign.infrastructure.entities.PersonEntity;
import com.example.domaindrivendesign.infrastructure.repositories.PersonJpaRepository;
import com.example.domaindrivendesign.infrastructure.repositories.excetpions.DatabaseException;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
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
    @Cacheable(cacheNames = "persons", key = "#id")
    public Optional<Person> findById(long id) {
        return personJpaRepository.findById(id).map(PersonEntity::toPerson);
    }

    @Override
    public Person save(Person person) {
        PersonEntity personEntity = new PersonEntity(person);
        personEntity = personJpaRepository.save(personEntity);
        return personEntity.toPerson();
    }

    @Override
    @CachePut(cacheNames = "persons", key = "#person.id")
    public Person update(Person person) {
        return save(person);
    }

    @Override
    @CacheEvict(cacheNames = "persons", key = "#id")
    public void delete(long id) {
        try {
            personJpaRepository.deleteById(id);
        } catch (ConstraintViolationException e) {
            throw new DatabaseException("Erro de constraint: " + e.getMessage());
        }
    }
}
