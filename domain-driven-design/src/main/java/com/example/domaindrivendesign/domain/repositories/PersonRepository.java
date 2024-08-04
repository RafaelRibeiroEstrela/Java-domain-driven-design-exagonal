package com.example.domaindrivendesign.domain.repositories;

import com.example.domaindrivendesign.domain.models.Person;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface PersonRepository {

    Page<Person> findAll(Pageable pageable);
    List<Person> findAll();
    Optional<Person> findById(long id);
    Person save(Person person);
    Person update(Person person);
    void delete(long id);

}
