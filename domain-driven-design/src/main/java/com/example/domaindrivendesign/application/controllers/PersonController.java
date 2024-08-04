package com.example.domaindrivendesign.application.controllers;

import com.example.domaindrivendesign.domain.dtos.PersonDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface PersonController {

    ResponseEntity<Page<PersonDTO>> findAll(Pageable pageable);
    ResponseEntity<List<PersonDTO>> findAll();
    ResponseEntity<PersonDTO> findById(Long id);
    ResponseEntity<PersonDTO> save(PersonDTO personDTO);
    ResponseEntity<PersonDTO> update(PersonDTO personDTO, Long id);
    ResponseEntity<Void> delete(Long id);
}
