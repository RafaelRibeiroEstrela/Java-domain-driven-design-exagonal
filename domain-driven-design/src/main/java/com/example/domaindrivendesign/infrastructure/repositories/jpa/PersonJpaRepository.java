package com.example.domaindrivendesign.infrastructure.repositories.jpa;

import com.example.domaindrivendesign.infrastructure.entities.PersonEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonJpaRepository extends JpaRepository<PersonEntity, Long> {
}
