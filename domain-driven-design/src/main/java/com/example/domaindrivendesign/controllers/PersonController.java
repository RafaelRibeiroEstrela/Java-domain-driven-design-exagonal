package com.example.domaindrivendesign.controllers;

import com.example.domaindrivendesign.dtos.PersonDTO;
import org.springframework.http.ResponseEntity;

public interface PersonController extends CrudController<PersonDTO> {

    ResponseEntity<PersonDTO> findByName(String name);
}
