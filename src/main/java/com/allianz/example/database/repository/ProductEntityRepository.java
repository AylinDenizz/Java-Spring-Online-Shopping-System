package com.allianz.example.database.repository;

import com.allianz.example.database.entity.PersonEntity;
import com.allianz.example.database.entity.ProductEntity;
import com.allianz.example.model.enums.ColorEnum;
import com.allianz.example.util.dbutil.BaseEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

@Repository
public interface ProductEntityRepository extends JpaRepository<ProductEntity, Long> {
    Optional<ProductEntity> findByUuid(UUID uuid);
}