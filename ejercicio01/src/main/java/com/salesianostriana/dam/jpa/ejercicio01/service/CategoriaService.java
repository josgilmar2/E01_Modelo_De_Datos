package com.salesianostriana.dam.jpa.ejercicio01.service;

import com.salesianostriana.dam.jpa.ejercicio01.model.Categoria;
import com.salesianostriana.dam.jpa.ejercicio01.repos.CategoriaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CategoriaService {

    private final CategoriaRepository repository;

    public Categoria add(Categoria categoria) {
        return repository.save(categoria);
    }

    public Optional<Categoria> findById(Long id) {
        return repository.findById(id);
    }

    public List<Categoria> findAll() {
        return repository.findAll();
    }

    public Categoria edit(Categoria categoria) {
        return repository.save(categoria);
    }

    public void delete(Categoria categoria) {
        repository.delete(categoria);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }

}
