package com.petsCare.index.repositories.user;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.petsCare.index.models.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Integer>{
        Optional<UserEntity> findByUsername(String username);
}
