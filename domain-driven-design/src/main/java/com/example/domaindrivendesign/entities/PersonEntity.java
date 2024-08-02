package com.example.domaindrivendesign.entities;

import com.example.domaindrivendesign.models.Person;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "persons")
@Getter
@Setter
@NoArgsConstructor
public class PersonEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Integer age;

    public PersonEntity(Person person) {
        this.id = person.getId();
        this.name = person.getName();
        this.age = person.getAge();
    }

    public Person toPerson() {
        Person person = new Person();
        person.setId(id);
        person.setName(name);
        person.setAge(age);
        return person;
    }
}
