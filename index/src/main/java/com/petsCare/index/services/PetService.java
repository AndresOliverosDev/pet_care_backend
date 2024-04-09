package com.petsCare.index.services;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.petsCare.index.dto.PetDTO;
import com.petsCare.index.models.Pet;

@Service
public interface PetService {

    ResponseEntity<String> addPet(PetDTO petDTO);

    ResponseEntity<String> deletePet(Long id);

    ResponseEntity<String> updatePet(Long id, Pet pet);

    List<PetDTO> getAllPets();

    Optional<PetDTO> getByIdPet(Long id);

    List<PetDTO> getByNamePets(String name);

    List<PetDTO> getByColorPets(String color);

    List<PetDTO> getByGenderPets(String gender);

    List<PetDTO> getBySpeciePets(String specie);

    List<PetDTO> getByRacePets(String race);

    List<PetDTO> getByOwnerPet(String owner);
}
