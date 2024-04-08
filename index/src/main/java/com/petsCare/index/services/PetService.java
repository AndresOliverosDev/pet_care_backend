package com.petsCare.index.services;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.petsCare.index.models.Pet;

@Service
public interface PetService {

    ResponseEntity<String> addPet(Pet pet);
    
    ResponseEntity<String> deletePet(Long id);

    ResponseEntity<String> updatePet(Long id, Pet pet);

    List<Pet> getAllPets();

    Optional<Pet> getByIdPet(Long id);

    List<Pet> getByNamePets(String name);

    List<Pet> getByColorPets(String color);

    List<Pet> getByGenderPets(String gender);

    List<Pet> getBySpeciePets(String specie);

    List<Pet> getByRacePets(Integer race);
}
