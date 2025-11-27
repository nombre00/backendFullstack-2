package com.example.demo.controller;

import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.demo.dto.Producto;
import com.example.demo.service.ProductoService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;


// Manejo de endpoints.

@RestController
@RequestMapping("catalogo")
@RequiredArgsConstructor
@CrossOrigin("*") // Autoriza comunicaciones no seguras.
@Tag(name = "Catálogo de Productos", description = "Gestión completa del catálogo de la pastelería")
public class ProductoController {
    
    private final ProductoService productoService;

    // Funcion para buscar todos los productos.
    @Operation(summary = "Listar todos los productos", description = "Devuelve todos los productos disponibles")
    @GetMapping
    public List<Producto> buscarTodos(){
        return productoService.buscarTodos();
    }

    // Funcion para buscar por id.
    @Operation(summary = "Buscar producto por ID")
    @Parameter(name = "id", description = "ID del producto", example = "3", required = true)
    @GetMapping("/{id}")
    public Producto buscarPorId(@PathVariable int id){
        return productoService.buscarPorId(id);
    }

    // Funcion para crear un producto.
    @Operation(summary = "Crear un nuevo producto", description = "Solo administradores")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Producto creado correctamente"),
        @ApiResponse(responseCode = "400", description = "Datos inválidos")
    })
    @PostMapping
    public ResponseEntity<Producto> guardar(
        @RequestBody 
        @io.swagger.v3.oas.annotations.parameters.RequestBody(
            description = "Datos del nuevo producto",
            required = true,
            content = @Content(schema = @Schema(implementation = Producto.class))
        ) 
        Producto p){
        return ResponseEntity.ok(productoService.crear(p));
    }

    // Funcion para actualizar un producto.
    @Operation(summary = "Actualizar un producto existente")
    @PutMapping("/{id}")
    public ResponseEntity<Producto> editar(@PathVariable int id, @RequestBody Producto p){
        return ResponseEntity.ok(productoService.actualizar(id, p));
    }

    // Funcion para borrar por id.
    @Operation(summary = "Eliminar un producto")
    @ApiResponse(responseCode = "204", description = "Producto eliminado correctamente")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> borrar(@PathVariable int id){
        productoService.borrar(id);
        return ResponseEntity.noContent().build();
    }
}
