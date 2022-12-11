package com.salesianostriana.dam.jpa.ejercicio01.model;

import lombok.*;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor @AllArgsConstructor
@Getter @Setter
@Builder
@ToString
public class Categoria {

    @Id @GeneratedValue
    private Long id;

    private String nombre;

    @OneToMany(mappedBy = "categoria", fetch = FetchType.EAGER)
    @Builder.Default
    @ToString.Exclude
    private List<Producto> productos = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "categoriapadre_id", foreignKey = @ForeignKey(name = "FK_CATEGORIAPADRE_CATEGORIAHIJA"))
    private Categoria categoriaPadre;

    @OneToMany(mappedBy = "categoriaPadre", fetch = FetchType.EAGER)
    @Builder.Default
    @ToString.Exclude
    private List<Categoria> categoriasHijas = new ArrayList<>();

    public void addCategoriaHija(Categoria c) {
        this.categoriaPadre = c;
        this.categoriasHijas.add(this);
    }

    public void removeCategoriaHija() {
        this.categoriaPadre = null;
        this.categoriasHijas.remove(this);
    }

    @PreRemove
    public void setNullProductos() {
        productos.forEach(p -> p.setCategoria(null));
    }

}
