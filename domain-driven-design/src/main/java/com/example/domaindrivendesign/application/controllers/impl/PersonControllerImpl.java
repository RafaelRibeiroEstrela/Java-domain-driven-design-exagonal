package com.example.domaindrivendesign.application.controllers.impl;

import com.example.domaindrivendesign.application.controllers.PersonController;
import com.example.domaindrivendesign.domain.dtos.PersonDTO;
import com.example.domaindrivendesign.domain.services.PersonService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/persons")
@AllArgsConstructor
public class PersonControllerImpl implements PersonController {

    private final PersonService personService;


    @Override
    @GetMapping("/paginado")
    public ResponseEntity<Page<PersonDTO>> findAll(Pageable pageable) {
        return ResponseEntity.status(HttpStatus.OK).body(personService.findAll(pageable));
    }

    @Override
    @GetMapping
    public ResponseEntity<List<PersonDTO>> findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(personService.findAll());
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<PersonDTO> findById(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(personService.findById(id));
    }

    @Override
    @PostMapping
    public ResponseEntity<PersonDTO> save(@RequestBody @Valid PersonDTO personDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(personService.save(personDTO));
    }

    @Override
    @PutMapping("/{id}")
    public ResponseEntity<PersonDTO> update(@RequestBody @Valid PersonDTO personDTO, @PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(personService.update(personDTO, id));
    }

    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        personService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
