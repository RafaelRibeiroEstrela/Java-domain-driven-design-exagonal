package com.example.domaindrivendesign.domains.dtos;

import com.example.domaindrivendesign.domains.models.Person;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PersonDTO {

    private Long id;
    private String name;
    private Integer age;

    public PersonDTO(Person person) {
        this.id = person.getId();
        this.name = person.getName();
        this.age = person.getAge();
    }

    public void copyToPerson(Person person) {
        person.setName(this.name);
        person.setAge(this.age);
    }

    public Person toPerson() {
        Person person = new Person();
        person.setId(this.id);
        copyToPerson(person);
        return person;
    }
}
