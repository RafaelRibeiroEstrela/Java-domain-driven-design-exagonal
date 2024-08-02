package com.example.domaindrivendesign.domains.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface CrudRepository <T> {

    Page<T> findAll(Pageable pageable);
    List<T> findAll();
    Optional<T> findById(long id);
    T save(T t);
    void delete(long id);
}
