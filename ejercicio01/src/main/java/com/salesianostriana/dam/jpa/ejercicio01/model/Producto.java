package com.salesianostriana.dam.jpa.ejercicio01.model;

import lombok.*;

import javax.persistence.*;

@Entity
@NoArgsConstructor @AllArgsConstructor
@Getter @Setter
@Builder
@ToString
public class Producto {

    @Id @GeneratedValue
    private Long id;

    private String nombre;
    private double pvp;

    @ManyToOne
    @JoinColumn(name = "categoria_id", foreignKey = @ForeignKey(name = "FK_PRODUCTO_CATEGORIA"))
    private Categoria categoria;

    public void addToCategoria(Categoria c) {
        this.categoria = c;
        c.getProductos().add(this);
    }

    public void removeFromCategoria(Categoria c) {
        this.categoria = null;
        c.getProductos().remove(this);
    }

}
