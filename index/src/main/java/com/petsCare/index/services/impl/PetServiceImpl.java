package com.petsCare.index.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.petsCare.index.dto.PetDTO;
import com.petsCare.index.models.Owner;
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
    
    public ResponseEntity<String> addPet(PetDTO petDTO) {
        try {
            // Buscar al propietario por su ID
            Owner owner = ownerRepository.findById(petDTO.getOwner()).orElse(null);
            if (owner == null) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Propietario no encontrado");
            }
            Race race = raceRepository.getByNamerace(petDTO.getRace()).orElse(null);
            if (race == null) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Raza no encontrada");
            }

            
            // Crear una nueva instancia de Pet y asignar los valores del DTO
            Pet pet = new Pet();
            pet.setName(petDTO.getName());
            pet.setAge(petDTO.getAge());
            pet.setColor(petDTO.getColor());
            pet.setGender(petDTO.getGender());
            pet.setSpecie(petDTO.getSpecie());
            pet.setOwner(owner); // Asignar el propietario

            // Guardar la mascota en la base de datos
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
