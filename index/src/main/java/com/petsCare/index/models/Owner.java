package com.petsCare.index.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "dueños")
@Getter
@Setter
public class Owner {

    @Id
    @Column(name = "cc")
    private String id;

    @Column(name = "nombres", nullable = false)
    private String names;

    @Column(name = "apellidos", nullable = false)
    private String surnames;

    @Column(name = "direccion", nullable = false)
    private String address;

    @Column(name = "telefono", nullable = false)
    private String phone;
}
