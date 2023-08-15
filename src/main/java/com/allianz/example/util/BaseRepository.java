package com.allianz.example.util;

import com.allianz.example.util.dbutil.BaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.Optional;
import java.util.UUID;
@NoRepositoryBean
public interface BaseRepository<Entity extends BaseEntity> extends JpaRepository<Entity, Long>, JpaSpecificationExecutor<Entity> {
    Optional<Entity> findByUuid(UUID uuid) ;


}
