package com.example.demo.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;


@Entity
@Data
@Table(name = "clientes")
@Schema(description = "Cliente registrado en la pastelería")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "ID único del cliente", example = "1")
    private Long id;

    @NotBlank(message = "Nombre no puede estar vacio")
    @Size(min = 2, max = 50, message = "El nombre debe tener entre 2 y 50 caracteres")
    @Column(name = "name", nullable = false, length = 50)
    @Schema(description = "Nombre del cliente", example = "María Laura", requiredMode = Schema.RequiredMode.REQUIRED)
    private String nombre;

    @NotBlank(message = "El apellido no puede estar vacio")
    @Size(min = 2, max = 50, message = "El apellido debe tener entre 2 y 50 caracteres")
    @Column(name = "lastname", nullable = false, length = 50)
    @Schema(description = "Apellido del cliente", example = "González", requiredMode = Schema.RequiredMode.REQUIRED)
    private String Apellido;

    @NotBlank(message = "La dirección no puede estar vacia")
    @Column(name = "address", nullable = false)
    @Schema(description = "Dirección de entrega", example = "Av. Corrientes 1234, CABA", requiredMode = Schema.RequiredMode.REQUIRED)
    private String direccion;

    @NotBlank(message = "El correo no puede estar vacio")
    @Size(max = 100, message = "El correo debe tener como maximo 100 caracteres")
    @Email(message = "el correo no es valido")
    @Column(name = "email", nullable = false, unique = true)
    @Schema(description = "Correo electrónico (único)", example = "maria.gonzalez@gmail.com", format = "email", requiredMode = Schema.RequiredMode.REQUIRED)
    private String email;

    @NotBlank(message = "Contraseña no puede estar vacia")
    @Size(min = 8, message = "Contraseña debe tener como minimo 8 caracteres")
    @Column(name = "password", nullable = false)
    @Schema(description = "Contraseña del usuario", example = "miPassword123", minLength = 8, format = "password", requiredMode = Schema.RequiredMode.REQUIRED)
    private String contrasenia;

    @NotBlank(message = "Rol no puede estar vacio")
    @Column(name = "role", nullable = false)
    @Schema(description = "Rol del usuario", example = "CLIENTE",
            allowableValues = {"ADMIN", "CLIENTE", "REPARTIDOR"}, requiredMode = Schema.RequiredMode.REQUIRED)
    private String rol;

    @Column(name = "reference")
    @Schema(description = "Referencia de la dirección (piso, depto, entre calles, etc.)", example = "Depto 5B, entre escaleras")
    private String referencia;
}
