package com.petsCare.index.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.petsCare.index.models.Race;

@Repository
public interface RaceRepository extends JpaRepository<Race, Integer>{
    
}
