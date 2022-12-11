package com.salesianostriana.dam.jpa.ejercicio01.repos;

import com.salesianostriana.dam.jpa.ejercicio01.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
}
