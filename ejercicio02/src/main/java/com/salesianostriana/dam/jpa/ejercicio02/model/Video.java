package com.salesianostriana.dam.jpa.ejercicio02.model;

import lombok.*;

import javax.persistence.*;

@Entity
@NoArgsConstructor @AllArgsConstructor
@Getter @Setter
@Builder
@ToString
public class Video {

    @Id @GeneratedValue
    private Long id;

    private int orden;
    private String titulo, descripcion, url;

    @ManyToOne
    @JoinColumn(name = "cursoonline_id", foreignKey = @ForeignKey(name = "FK_VIDEO_CURSOONLINE"))
    private CursoOnline cursoOnline;

    public void addToCursoOnline(CursoOnline c) {
        this.cursoOnline = c;
        c.getVideos().add(this);
    }

    public void removeFromCursoOnline(CursoOnline c) {
        this.cursoOnline = null;
        c.getVideos().remove(this);
    }

}
