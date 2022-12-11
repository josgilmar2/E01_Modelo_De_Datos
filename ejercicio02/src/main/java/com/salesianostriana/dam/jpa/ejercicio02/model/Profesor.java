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
public class Profesor {

    @Id @GeneratedValue
    private Long id;

    private String nombre, email;
    private double puntuacion;

    @OneToMany(mappedBy = "profesor", fetch = FetchType.EAGER)
    @Builder.Default
    @ToString.Exclude
    private List<CursoOnline> cursosOnline = new ArrayList<>();

    @PreRemove
    public void setNullCursosOnline() {
        cursosOnline.forEach(c -> c.setProfesor(null));
    }

}
