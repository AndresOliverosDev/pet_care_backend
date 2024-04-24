package com.petsCare.index.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class PetAddDTO {
    private Long id ;
    private String name;
    private Short age;
    private String color;
    private String gender;
    private String specie;
    private String owner;
    private Integer race;
}