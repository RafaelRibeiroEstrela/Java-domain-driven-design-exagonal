package com.example.domaindrivendesign.domains.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CrudService <T> {

    Page<T> findAll(Pageable pageable);
    List<T> findAll();
    T findById(long id);
    T save(T t);
    T update(T t, long id);
    void delete(long id);
}
