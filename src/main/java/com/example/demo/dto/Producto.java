package com.example.demo.dto;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Entity
@Data
@Table(name = "productos")
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;  // ← Cambiado a Integer + AUTO_INCREMENT

    @NotBlank(message = "Nombre no puede estar vacio")
    @Column(nullable = true)
    private String nombre;

    @NotBlank(message = "Precio no puede estar vacio")
    @Column(nullable = true)
    private int precio;

    @NotBlank(message = "url no puede estar vacio")
    @Column(nullable = true)
    private String url;

    @NotBlank(message = "categoria no puede estar vacio")
    @Column(nullable = true)
    private String categoria;

    @NotBlank(message = "Resena no puede estar vacio")
    @Column(nullable = true)
    @Lob
    private String resena;
}
