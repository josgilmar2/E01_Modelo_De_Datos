package com.salesianostriana.dam.jpa.ejercicio02.repos;

import com.salesianostriana.dam.jpa.ejercicio02.model.Video;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VideoRepository extends JpaRepository<Video, Long> {
}
