package com.example.domaindrivendesign.services;

import com.example.domaindrivendesign.dtos.PersonDTO;

public interface PersonService extends CrudService<PersonDTO> {

    PersonDTO findByName(String name);

}
