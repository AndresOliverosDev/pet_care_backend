package com.petsCare.index.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.petsCare.index.models.Pet;
import com.petsCare.index.repositories.PetRepository;
import com.petsCare.index.services.PetService;

@Service
public class PetServiceImpl implements PetService{

    @Autowired
    PetRepository petRepository;

    @Override
    public ResponseEntity<String> addPet(Pet pet) {
        try {
            petRepository.save(pet);
            return ResponseEntity.ok("La mascota se creo correctamente");
        } catch(Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al crear la mascota");
        }
    }

    @Override
    public ResponseEntity<String> deletePet(Long id) {
        try {
            petRepository.deleteById(id);
            return ResponseEntity.ok("Eliminado correctamente");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al intentar eliminar el registro");
        }
    }

    @Override
    public ResponseEntity<String> updatePet(Long id, Pet pet) {
        Pet petBBDD = petRepository.findById(id).orElse(null);
        try {
            if (petBBDD != null) {
                petBBDD.setName(pet.getName());
                petBBDD.setAge(pet.getAge());
                petBBDD.setColor(pet.getColor());
                petBBDD.setGender(pet.getGender());
                petBBDD.setSpecie(pet.getSpecie());
    
                petRepository.save(petBBDD);
                return ResponseEntity.ok("Se actualizó correctamente");
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch(Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error durante la actualización");
        }
    }
    
    @Override
    public List<Pet> getAllPets() {
        return petRepository.findAll();
    }

    @Override
    public Optional<Pet> getByIdPet(Long id) {
        return petRepository.findById(id);
    }

    @Override
    public List<Pet> getByNamePets(String name) {
        return petRepository.findAllByName(name);
    }

    @Override
    public List<Pet> getByColorPets(String color) {
        return petRepository.findAllByColor(color);
    }

    @Override
    public List<Pet> getByGenderPets(String gender) {
        return petRepository.findAllByGender(gender);
    }

    @Override
    public List<Pet> getBySpeciePets(String specie) {
        return petRepository.findAllBySpecie(specie);
    }

    @Override
    public List<Pet> getByRacePets(Integer race) {
        return petRepository.findAllByRace(race);
    }
}
