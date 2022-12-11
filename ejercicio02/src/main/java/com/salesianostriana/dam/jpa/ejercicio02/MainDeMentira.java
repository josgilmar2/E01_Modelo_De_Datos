package com.salesianostriana.dam.jpa.ejercicio02;

import com.salesianostriana.dam.jpa.ejercicio02.model.CursoOnline;
import com.salesianostriana.dam.jpa.ejercicio02.model.Profesor;
import com.salesianostriana.dam.jpa.ejercicio02.model.Video;
import com.salesianostriana.dam.jpa.ejercicio02.repos.CursoOnlineRepository;
import com.salesianostriana.dam.jpa.ejercicio02.repos.ProfesorRepository;
import com.salesianostriana.dam.jpa.ejercicio02.repos.VideoRepository;
import com.salesianostriana.dam.jpa.ejercicio02.service.CursoOnlineService;
import com.salesianostriana.dam.jpa.ejercicio02.service.ProfesorService;
import com.salesianostriana.dam.jpa.ejercicio02.service.VideoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;

@Component
@RequiredArgsConstructor
public class MainDeMentira {

    private final ProfesorService profesorService;
    private final CursoOnlineService cursoOnlineService;
    private final VideoService videoService;

    @PostConstruct
    public void run() {

        Profesor p1 = Profesor.builder()
                .nombre("Luismi")
                .email("lmlopezmagana@gmail.com")
                .puntuacion(5)
                .build();

        profesorService.add(p1);

        Profesor p2 = Profesor.builder()
                .nombre("Miguel")
                .email("miguelcampos@gmail.com")
                .puntuacion(5)
                .build();

        profesorService.add(p2);

        CursoOnline c1 = CursoOnline.builder()
                .nombre("Spring Data JPA")
                .puntuacion(4.3)
                .profesor(p1)
                .build();

        CursoOnline c2 = CursoOnline.builder()
                .nombre("Spring Security")
                .puntuacion(4.6)
                .build();

        CursoOnline c3 = CursoOnline.builder()
                .nombre("Angular")
                .puntuacion(4.4)
                .build();

        List<CursoOnline> cursoOnlineList = List.of(c1, c2, c3);

        c1.addProfesor(p1);
        c2.addProfesor(p1);
        c3.addProfesor(p2);

        cursoOnlineService.addAll(cursoOnlineList);

        Video v1 = Video.builder()
                .orden(1)
                .titulo("Introducción a Spring Data JPA")
                .descripcion("Pequeña introducción para conocer más sobre Spring Data JPA")
                .url("https://www.youtube.com/watch?v=gH82uEKfils")
                .build();

        Video v2 = Video.builder()
                .orden(2)
                .titulo("Asociaciones")
                .descripcion("Asociaciones en Spring Data JPA")
                .url("https://www.youtube.com/watch?v=yrfCie03YSg")
                .build();

        Video v3 = Video.builder()
                .orden(1)
                .titulo("Introducción a Spring Security")
                .descripcion("Pequeña introducción para conocer más sobre Spring Security")
                .url("https://www.youtube.com/watch?v=ksLYIavT2L0")
                .build();

        Video v4 = Video.builder()
                .orden(1)
                .titulo("Introducción a Angular")
                .descripcion("Pequeña introducción para conocer más sobre Angular")
                .url("https://www.youtube.com/watch?v=fXpMiweCC_o")
                .build();

        Video v5 = Video.builder()
                .orden(2)
                .titulo("Componentes")
                .descripcion("Explicación del funcionamiento de componentes en Angular")
                .url("https://www.youtube.com/watch?v=df0eH9mM9nU")
                .build();

        List<Video> videoList = List.of(v1, v2, v3, v4, v5);

        v1.addToCursoOnline(c1);
        v2.addToCursoOnline(c1);
        v3.addToCursoOnline(c2);
        v4.addToCursoOnline(c3);
        v5.addToCursoOnline(c3);

        videoService.addAll(videoList);

        profesorService.findAll().forEach(p -> {
            System.out.println("Profesor: " + p.toString());
            p.getCursosOnline().forEach(System.out::println);
        });

        cursoOnlineService.findAll().forEach(c -> {
            System.out.println("Curso Online: " + c.toString());
            c.getVideos().forEach(System.out::println);
        });

    }

}
