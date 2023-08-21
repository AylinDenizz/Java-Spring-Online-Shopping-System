package com.allianz.example.database.repository;

import com.allianz.example.database.entity.UserEntity;
import com.allianz.example.util.BaseRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserEntityRepository extends BaseRepository<UserEntity> {

    Optional<UserEntity> findByEmail(String email);
}
