package com.example.domaindrivendesign.domain.services;

import com.example.domaindrivendesign.application.dtos.PersonDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface PersonService {

    Page<PersonDTO> findAll(Pageable pageable);
    List<PersonDTO> findAll();
    PersonDTO findById(long id);
    PersonDTO save(PersonDTO personDTO);
    PersonDTO update(PersonDTO personDTO, long id);
    void delete(long id);

}
