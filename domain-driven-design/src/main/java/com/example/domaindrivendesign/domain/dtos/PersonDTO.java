package com.example.domaindrivendesign.domain.dtos;

import com.example.domaindrivendesign.domain.models.Person;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PersonDTO {

    private Long id;

    @NotEmpty(message = "O nome é obrigatório")
    private String name;
    @NotNull(message = "A idade é obrigatório")
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
