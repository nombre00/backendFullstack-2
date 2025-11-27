package com.example.demo.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Entity
@Data
@Table(name = "productos")
@Schema(example = """ 
{
  "id": 1,
  "nombre": "Torta Rogel",
  "precio": 6800,
  "url": "https://tupasteleria.com/img/rogel.jpg",
  "categoria": "Tortas",
  "resena": "Capas finas de masa crocante, abundante dulce de leche repostero y merengue italiano flameado."
}
""")
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
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
    @Column(columnDefinition = "TEXT")
    @Lob
    private String resena;
}
