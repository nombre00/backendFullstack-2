package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.dto.Producto;


// Accesador de productos
public interface ProductoRepository extends JpaRepository<Producto, Long> {

    
}
