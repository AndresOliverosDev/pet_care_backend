package com.petsCare.index.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "mascotas")
@Getter
@Setter
public class Pet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id ;

    @Column(name = "nombre", nullable = false)
    private String name;

    @Column(name = "edad", nullable = false)
    private Short age;

    @Column(name = "color", nullable = false)
    private String color;

    @Column(name = "genero", nullable = false)
    private String gender;

    @Column(name = "especie", nullable = false)
    private String specie;

    @ManyToOne
    @JoinColumn(name = "dueñoscc")
    private Owner owner;

    @ManyToOne
    @JoinColumn(name = "razasid")
    private Race race;
}
