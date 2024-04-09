package com.petsCare.index.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.petsCare.index.models.Owner;

@Repository
public interface OwnerRepository extends JpaRepository<Owner, String> {
}
