package com.salesianostriana.dam.jpa.ejercicio02.model;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor @AllArgsConstructor
@Getter @Setter
@Builder
@ToString
public class CursoOnline {

    @Id @GeneratedValue
    private Long id;

    private String nombre;
    private double puntuacion;

    @ManyToOne
    @JoinColumn(name = "profesor_id", foreignKey = @ForeignKey(name = "FK_CURSOONLINE_PROFESOR"))
    private Profesor profesor;

    @OneToMany(mappedBy = "cursoOnline", fetch = FetchType.EAGER)
    @Builder.Default
    @ToString.Exclude
    private List<Video> videos = new ArrayList<>();

    public void addProfesor(Profesor p) {
        this.profesor = p;
        p.getCursosOnline().add(this);
    }

    public void removeProfesor(Profesor p) {
        this.profesor = null;
        p.getCursosOnline().remove(this);
    }

    @PreRemove
    public void setNullVideos() {
        videos.forEach(v -> v.setCursoOnline(null));
    }

}
