package com.petsCare.index.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.petsCare.index.dto.PetAddDTO;
import com.petsCare.index.dto.PetDTO;
import com.petsCare.index.models.Pet;
import com.petsCare.index.services.PetService;

@RestController
@RequestMapping("/pet")
@PreAuthorize("denyAll()")
public class PetController {

    @Autowired
    PetService petService;

    @PreAuthorize("hasAuthority('CREATE')")
    @PostMapping("/add")
    ResponseEntity<String> addPed(@RequestBody PetAddDTO petAddDTO) {
        return petService.addPet(petAddDTO);
    }

    @PreAuthorize("hasAuthority('READ')")
    @GetMapping("/getAll")
    List<PetDTO> getAllPets() {
        return petService.getAllPets();
    }

    @DeleteMapping("/deletePet/{id}")
    ResponseEntity<String> deletePet(@PathVariable Long id) {
        return petService.deletePet(id);
    }

    @PutMapping("/updatePet/{id}")
    ResponseEntity<String> updatePet(@PathVariable Long id, @RequestBody Pet pet) {
        return petService.updatePet(id, pet);
    }

    @GetMapping("/getByIdPet/{id}")
    Optional<PetDTO> getByIdPet(@PathVariable Long id) {
        return petService.getByIdPet(id);
    }

    @GetMapping("/getByNamePets/{name}")
    List<PetDTO> getByNamePet(@PathVariable String name) {
        return petService.getByNamePets(name);
    }

    @GetMapping("/getByColorPets/{color}")
    List<PetDTO> getByColorPets(@PathVariable String color) {
        return petService.getByColorPets(color);
    }

    @GetMapping("/getByGenderPets/{gender}")
    List<PetDTO> getByGenderPets(@PathVariable String gender) {
        return petService.getByGenderPets(gender);
    }

    @GetMapping("/getBySpeciePets/{specie}")
    List<PetDTO> getBySpeciePets(@PathVariable String specie) {
        return petService.getBySpeciePets(specie);
    }

    @GetMapping("/getByRacePets/{race}")
    List<PetDTO> getByRacePets(@PathVariable String race) {
        return petService.getByRacePets(race);
    }

    @GetMapping("/getByOwnerPets/{owner}")
    List<PetDTO> getByOwnerPets(@PathVariable String owner) {
        return petService.getByOwnerPet(owner);
    }
}
