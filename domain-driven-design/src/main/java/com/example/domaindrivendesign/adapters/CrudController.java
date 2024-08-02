package com.example.domaindrivendesign.adapters;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CrudController<T> {

    ResponseEntity<Page<T>> findAll(Pageable pageable);
    ResponseEntity<List<T>> findAll();
    ResponseEntity<T> findById(Long id);
    ResponseEntity<T> save(T t);
    ResponseEntity<T> update(T t, Long id);
    ResponseEntity<Void> delete(Long id);

}
