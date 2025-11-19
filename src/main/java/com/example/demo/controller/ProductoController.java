package com.example.demo.controller;

import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.demo.dto.Producto;
import com.example.demo.service.ProductoService;
import lombok.RequiredArgsConstructor;


// Manejo de endpoints.

@RestController
@RequestMapping("catalogo")
@RequiredArgsConstructor
@CrossOrigin("*") // Autoriza comunicaciones no seguras.
public class ProductoController {
    
    private final ProductoService productoService;

    // Funcion para buscar todos los productos.
    @GetMapping
    public List<Producto> buscarTodos(){
        return productoService.buscarTodos();
    }

    // Funcion para buscar por id.
    @GetMapping("/{id}")
    public Producto buscarPorId(@PathVariable int id){
        return productoService.buscarPorId(id);
    }

    // Funcion para crear un producto.
    @PostMapping("/{id}")
    public ResponseEntity<Producto> guardar(@PathVariable int id, @RequestBody Producto p){
        return ResponseEntity.ok(productoService.crear(p));
    }

    // Funcion para actualizar un producto.
    @PutMapping("/{id}")
    public ResponseEntity<Producto> editar(@PathVariable int id, @RequestBody Producto p){
        return ResponseEntity.ok(productoService.actualizar(id, p));
    }

    // Funcion para borrar por id.
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> borrar(@PathVariable int id){
        productoService.borrar(id);
        return ResponseEntity.noContent().build();
    }
}
