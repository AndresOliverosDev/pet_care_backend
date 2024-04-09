package com.petsCare.index.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.petsCare.index.dto.PetDTO;
import com.petsCare.index.models.Pet;

@Repository
public interface PetRepository extends JpaRepository<Pet, Long>{
    
    @Query("SELECT new com.petsCare.index.dto.PetDTO(p.id, p.name, p.age, p.color, p.gender, p.specie, p.owner.names, p.race.name) FROM Pet p")
    List<PetDTO> getAllPets();
    
    @Query("SELECT new com.petsCare.index.dto.PetDTO(p.id, p.name, p.age, p.color, p.gender, p.specie, p.owner.names, p.race.name) FROM Pet p WHERE p.id = :id")
    Optional<PetDTO> getByIdPet(Long id);

    @Query("SELECT new com.petsCare.index.dto.PetDTO(p.id, p.name, p.age, p.color, p.gender, p.specie, p.owner.names, p.race.name) FROM Pet p WHERE p.name = :name")
    List<PetDTO> getByNamePets(String name);

    @Query("SELECT new com.petsCare.index.dto.PetDTO(p.id, p.name, p.age, p.color, p.gender, p.specie, p.owner.names, p.race.name) FROM Pet p WHERE p.color = :color")
    List<PetDTO> getByColorPets(String color);

    @Query("SELECT new com.petsCare.index.dto.PetDTO(p.id, p.name, p.age, p.color, p.gender, p.specie, p.owner.names, p.race.name) FROM Pet p WHERE p.gender = :gender")
    List<PetDTO> getByGenderPets(String gender);

    @Query("SELECT new com.petsCare.index.dto.PetDTO(p.id, p.name, p.age, p.color, p.gender, p.specie, p.owner.names, p.race.name) FROM Pet p WHERE p.specie = :specie")
    List<PetDTO> getBySpeciePets(String specie);

    @Query("SELECT new com.petsCare.index.dto.PetDTO(p.id, p.name, p.age, p.color, p.gender, p.specie, p.owner.names, p.race.name) FROM Pet p WHERE p.race.name = :race")
    List<PetDTO> getByRacePets(String race);

    @Query("SELECT new com.petsCare.index.dto.PetDTO(p.id, p.name, p.age, p.color, p.gender, p.specie, p.owner.names, p.race.name) FROM Pet p WHERE p.owner.names = :owner")
    List<PetDTO> getByOwnerPets(String owner);

}
