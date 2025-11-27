package com.example.demo.controller;

import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.demo.dto.Cliente;
import com.example.demo.service.ClienteService;
import lombok.RequiredArgsConstructor;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;


// Manejo de endpoints.

@RestController
@RequestMapping("/clientes")
@RequiredArgsConstructor
@CrossOrigin("*") // Autoriza comunicaciones no seguras.
@Tag(name = "Clientes", description = "Gestión de clientes, administradores y repartidores de la pastelería")
public class ClienteController {
    
    private final ClienteService clienteService;

    @Operation(summary = "Listar todos los clientes")
    @GetMapping
    public List<Cliente> buscarTodos(){
        return clienteService.buscarTodos();
    }

    @Operation(summary = "Buscar cliente por ID")
    @Parameter(name = "id", description = "ID del cliente", required = true, example = "5")
    @GetMapping("/{id}")
    public Cliente buscarPorId(@PathVariable int id){
        return clienteService.buscarPorId(id);
    }

    @Operation(summary = "Registrar nuevo cliente/admin/repartidor")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Cliente creado exitosamente",
                     content = @Content(schema = @Schema(implementation = Cliente.class))),
        @ApiResponse(responseCode = "400", description = "Datos inválidos o email duplicado"),
        @ApiResponse(responseCode = "500", description = "Error interno del servidor")
    })
    @PostMapping
    public ResponseEntity<Cliente> guardar(
        @RequestBody
        @io.swagger.v3.oas.annotations.parameters.RequestBody(
            description = "Datos del nuevo cliente",
            required = true,
            content = @Content(schema = @Schema(implementation = Cliente.class))
        ) Cliente c){
        return ResponseEntity.ok(clienteService.crear(c));
    }

    @Operation(summary = "Actualizar datos de un cliente existente")
    @PutMapping("/{id}")
    public ResponseEntity<Cliente> editar(@PathVariable int id, @RequestBody Cliente c){
        return ResponseEntity.ok(clienteService.actualizar(id, c));
    }

    @Operation(summary = "Eliminar un cliente")
    @ApiResponse(responseCode = "204", description = "Cliente eliminado correctamente")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> borrar(@PathVariable int id){
        clienteService.borrar(id);
        return ResponseEntity.noContent().build();
    }
}
