package com.example.demo.controller;

import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.demo.dto.Cliente;
import com.example.demo.service.ClienteService;
import lombok.RequiredArgsConstructor;


// Manejo de endpoints.

@RestController
@RequestMapping("clientes")
@RequiredArgsConstructor
@CrossOrigin("*") // Autoriza comunicaciones no seguras.
public class ClienteController {
    
    private final ClienteService clienteService;

    @GetMapping
    public List<Cliente> buscarTodos(){
        return clienteService.buscarTodos();
    }

    @GetMapping("/{id}")
    public Cliente buscarPorId(@PathVariable int id){
        return clienteService.buscarPorId(id);
    }

    @PostMapping("/{id}")
    public ResponseEntity<Cliente> guardar(@PathVariable int id, @RequestBody Cliente c){
        return ResponseEntity.ok(clienteService.crear(c));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cliente> editar(@PathVariable int id, @RequestBody Cliente c){
        return ResponseEntity.ok(clienteService.actualizar(id, c));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> borrar(@PathVariable int id){
        return ResponseEntity.noContent().build();
    }
}
