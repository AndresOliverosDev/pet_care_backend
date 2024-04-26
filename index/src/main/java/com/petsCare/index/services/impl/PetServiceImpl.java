package com.petsCare.index.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.petsCare.index.dto.PetAddDTO;
import com.petsCare.index.dto.PetDTO;
import com.petsCare.index.models.UserEntity;
import com.petsCare.index.models.Pet;
import com.petsCare.index.models.Race;
import com.petsCare.index.repositories.OwnerRepository;
import com.petsCare.index.repositories.PetRepository;
import com.petsCare.index.repositories.RaceRepository;
import com.petsCare.index.services.PetService;

@Service
public class PetServiceImpl implements PetService{

    @Autowired
    PetRepository petRepository;

    @Autowired
    OwnerRepository ownerRepository;

    @Autowired
    RaceRepository raceRepository;
    
    public ResponseEntity<String> addPet(PetAddDTO petAddDTO) {
        try {
            UserEntity owner = ownerRepository.findById(petAddDTO.getOwner()).orElse(null);
            if (owner == null) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Propietario no encontrado");
            }
            Race race = raceRepository.findById(petAddDTO.getRace()).orElse(null);
            if (race == null) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Raza no encontrada");
            }

            Pet pet = new Pet();
            pet.setName(petAddDTO.getName());
            pet.setAge(petAddDTO.getAge());
            pet.setColor(petAddDTO.getColor());
            pet.setGender(petAddDTO.getGender());
            pet.setSpecie(petAddDTO.getSpecie());
            pet.setOwner(owner);
            pet.setRace(race);


            petRepository.save(pet);

            return ResponseEntity.ok("La mascota se creó correctamente");
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
    public List<PetDTO> getAllPets() {
        return petRepository.getAllPets();
    }

    @Override
    public Optional<PetDTO> getByIdPet(Long id) {
        return petRepository.getByIdPet(id);
    }

    @Override
    public List<PetDTO> getByNamePets(String name) {
        return petRepository.getByNamePets(name);
    }

    @Override
    public List<PetDTO> getByColorPets(String color) {
        return petRepository.getByColorPets(color);
    }

    @Override
    public List<PetDTO> getByGenderPets(String gender) {
        return petRepository.getByGenderPets(gender);
    }

    @Override
    public List<PetDTO> getBySpeciePets(String specie) {
        return petRepository.getBySpeciePets(specie);
    }

    @Override
    public List<PetDTO> getByRacePets(String race) {
        return petRepository.getByRacePets(race);
    }

    @Override
    public List<PetDTO> getByOwnerPet(String owner) {
        return petRepository.getByOwnerPets(owner);
    }

}
