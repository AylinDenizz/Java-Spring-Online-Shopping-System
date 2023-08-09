package com.allianz.example.database.repository;

import com.allianz.example.database.entity.PersonEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;
@Repository
public interface PersonEntityRepository extends JpaRepository<PersonEntity, Long> {
    Optional<PersonEntity> findByUuid(UUID uuid);
}