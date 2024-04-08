package com.petsCare.index.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.petsCare.index.models.Pet;
import com.petsCare.index.services.PetService;

@RestController
public class PetController {

    @Autowired
    PetService petService;

    @PostMapping("/addPet")
    ResponseEntity<String> addPed(@RequestBody Pet pet){
        return petService.addPet(pet);
    }

    @DeleteMapping("/deletePet/{id}")
    ResponseEntity<String> deletePet(@PathVariable Long id) {
        return petService.deletePet(id);
    }

    @PutMapping("/updatePet/{id}")
    ResponseEntity<String> updatePet(@PathVariable Long id, @RequestBody Pet pet) {
        return petService.updatePet(id, pet);
    }

    @GetMapping("/getAllPets")
    List<Pet> getAllPets() {
        return petService.getAllPets();
    }

    @GetMapping("/getByIdPet")
    Optional<Pet> getByIdPet(@RequestBody Long id){
        return petService.getByIdPet(id);
    }

    @GetMapping("/getByNamePets")
    List<Pet> getByNamePets(@RequestBody String name) {
        return petService.getByNamePets(name);
    }
}
