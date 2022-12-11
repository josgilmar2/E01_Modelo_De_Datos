package com.salesianostriana.dam.jpa.ejercicio02.service;

import com.salesianostriana.dam.jpa.ejercicio02.model.Profesor;
import com.salesianostriana.dam.jpa.ejercicio02.repos.ProfesorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProfesorService {

    private final ProfesorRepository repository;

    public Profesor add(Profesor profesor) {
        return repository.save(profesor);
    }

    public Optional<Profesor> findById(Long id) {
        return repository.findById(id);
    }

    public List<Profesor> findAll() {
        return repository.findAll();
    }

    public Profesor edit(Profesor profesor) {
        return repository.save(profesor);
    }

    public void delete(Profesor artist) {
        repository.delete(artist);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }

}
