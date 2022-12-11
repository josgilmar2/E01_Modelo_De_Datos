package com.salesianostriana.dam.jpa.ejercicio01.service;

import com.salesianostriana.dam.jpa.ejercicio01.model.Producto;
import com.salesianostriana.dam.jpa.ejercicio01.repos.ProductoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductoService {

    private final ProductoRepository repository;

    public Producto add(Producto producto) {
        return repository.save(producto);
    }

    public Optional<Producto> findById(Long id) {
        return repository.findById(id);
    }

    public List<Producto> findAll() {
        return repository.findAll();
    }

    public Producto edit(Producto producto) {
        return repository.save(producto);
    }

    public void delete(Producto producto) {
        repository.delete(producto);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    public List<Producto> addAll(Iterable<Producto> productos) {
        return repository.saveAll(productos);
    }

}
