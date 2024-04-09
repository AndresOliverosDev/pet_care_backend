package com.petsCare.index.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class PetDTO {
    private Long id ;
    private String name;
    private Short age;
    private String color;
    private String gender;
    private String specie;
    private String owner;
    private String race;
}
