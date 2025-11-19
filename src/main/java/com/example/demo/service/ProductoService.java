package com.example.demo.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.example.demo.dto.Producto;
import com.example.demo.repository.ProductoRepository;
import lombok.RequiredArgsConstructor;

// Logica del programa

@Service
@RequiredArgsConstructor
public class ProductoService {

    private final ProductoRepository ProductoRepository;

    // Función que busca y devuelve todos.
    public List<Producto> buscarTodos(){
        return ProductoRepository.findAll();
    }

    // Función que busca un producto por su id.
    public Producto buscarPorId(int id){
        long long_id = id; // Transformamos el int a long.
        return ProductoRepository.getReferenceById(long_id);
    }

    // Funcion que crea un producto.
    public Producto crear(Producto p){
        return ProductoRepository.save(p);
    }

    // Funcion que actualiza un producto.
    public Producto actualizar(int id, Producto p){
        // Buscamos el producto a editar.
        Producto dbProducto = buscarPorId(id);
        // Editamos el producto.
        dbProducto.setNombre(p.getNombre());
        dbProducto.setPrecio(p.getPrecio());
        dbProducto.setCategoria(p.getCategoria());
        dbProducto.setResena(p.getResena());
        dbProducto.setUrl(p.getUrl());
        // Persistimos y retornamos.
        return ProductoRepository.save(dbProducto);
    }

    // Funcion que borra.
    public void borrar(int id){
        long long_id = id; // Transformamos el int a long.
        ProductoRepository.deleteById(long_id);
    }
}
