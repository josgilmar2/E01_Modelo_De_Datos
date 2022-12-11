package com.salesianostriana.dam.jpa.ejercicio02.service;

import com.salesianostriana.dam.jpa.ejercicio02.model.CursoOnline;
import com.salesianostriana.dam.jpa.ejercicio02.repos.CursoOnlineRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CursoOnlineService {

    private final CursoOnlineRepository repository;

    public CursoOnline add(CursoOnline cursoOnline) {
        return repository.save(cursoOnline);
    }

    public Optional<CursoOnline> findById(Long id) {
        return repository.findById(id);
    }

    public List<CursoOnline> findAll() {
        return repository.findAll();
    }

    public CursoOnline edit(CursoOnline cursoOnline) {
        return repository.save(cursoOnline);
    }

    public void delete(CursoOnline cursoOnline) {
        repository.delete(cursoOnline);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    public List<CursoOnline> addAll(Iterable<CursoOnline> cursosOnline) {
        return repository.saveAll(cursosOnline);
    }

}
