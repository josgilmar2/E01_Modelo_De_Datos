package com.salesianostriana.dam.jpa.ejercicio02.repos;

import com.salesianostriana.dam.jpa.ejercicio02.model.Profesor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfesorRepository extends JpaRepository<Profesor, Long> {
}
