package com.allianz.example.database.repository;

import com.allianz.example.database.entity.AddressEntity;
import com.allianz.example.database.entity.CommentEntity;
import com.allianz.example.database.entity.OrderItemEntity;
import com.allianz.example.util.dbutil.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface OrderItemEntityRepository extends JpaRepository<OrderItemEntity, Long> {
    Optional<OrderItemEntity> findByUuid(UUID uuid);
}