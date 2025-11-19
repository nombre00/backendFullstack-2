package com.example.demo.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.example.demo.dto.Cliente;
import com.example.demo.repository.ClienteRepository;
import lombok.RequiredArgsConstructor;

// Logica del programa

@Service
@RequiredArgsConstructor
public class ClienteService {
    private final ClienteRepository clienteRepository;

    // Función que busca y devuelve todos.
    public List<Cliente> buscarTodos(){
        return clienteRepository.findAll();
    }

    // Función que busca un cliente por su id.
    public Cliente buscarPorId(int id){
        long long_id = id; // Transformamos el int a long.
        return clienteRepository.getReferenceById(long_id);
    }

    // Funcion que crea un cliente.
    public Cliente crear(Cliente c){
        return clienteRepository.save(c);
    }

    // Funcion que actualiza un cliente.
    public Cliente actualizar(int id, Cliente c){
        // Buscamos el cliente a editar.
        Cliente dbCliente = buscarPorId(id);
        // Editamos el cliente.
        dbCliente.setNombre(c.getNombre());
        dbCliente.setApellido(c.getApellido());
        dbCliente.setDireccion(c.getDireccion());
        dbCliente.setEmail(c.getEmail());
        dbCliente.setContrasenia(c.getContrasenia());
        dbCliente.setRol(c.getRol());
        dbCliente.setReferencia(c.getReferencia());
        // Persistimos y retornamos.
        return clienteRepository.save(dbCliente);
    }

    // Funcion que borra.
    public void borrar(int id){
        long long_id = id; // Transformamos el int a long.
        clienteRepository.deleteById(long_id);
    }
}
