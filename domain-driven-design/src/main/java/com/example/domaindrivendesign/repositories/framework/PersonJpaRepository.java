package com.example.domaindrivendesign.repositories.framework;

import com.example.domaindrivendesign.entities.PersonEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PersonJpaRepository extends JpaRepository<PersonEntity, Long> {

    Optional<PersonEntity> findByName(String name);
}
