package com.example.domaindrivendesign.repositories;

import com.example.domaindrivendesign.models.Person;

import java.util.Optional;

public interface PersonRepository extends CrudRepository<Person> {

    Optional<Person> findByName(String name);

}
