package com.example.domaindrivendesign.infrastructures.repositories;

import com.example.domaindrivendesign.infrastructures.entities.PersonEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonJpaRepository extends JpaRepository<PersonEntity, Long> {
}
