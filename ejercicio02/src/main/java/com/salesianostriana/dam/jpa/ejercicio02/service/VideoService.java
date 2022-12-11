package com.salesianostriana.dam.jpa.ejercicio02.service;

import com.salesianostriana.dam.jpa.ejercicio02.model.Video;
import com.salesianostriana.dam.jpa.ejercicio02.repos.VideoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class VideoService {

    private final VideoRepository repository;

    public Video add(Video video) {
        return repository.save(video);
    }

    public Optional<Video> findById(Long id) {
        return repository.findById(id);
    }

    public List<Video> findAll() {
        return repository.findAll();
    }

    public Video edit(Video video) {
        return repository.save(video);
    }

    public void delete(Video video) {
        repository.delete(video);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    public List<Video> addAll(Iterable<Video> videos) {
        return repository.saveAll(videos);
    }

}
