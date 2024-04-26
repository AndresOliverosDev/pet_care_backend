package com.petsCare.index.repositories.rol;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.petsCare.index.models.rol.RolEntity;

@Repository
public interface RolRepository extends JpaRepository<RolEntity, Byte>{
    RolEntity findByName(String name);
}
