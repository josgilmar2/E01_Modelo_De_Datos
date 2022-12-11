package com.salesianostriana.dam.jpa.ejercicio01;

import com.salesianostriana.dam.jpa.ejercicio01.model.Categoria;
import com.salesianostriana.dam.jpa.ejercicio01.model.Producto;
import com.salesianostriana.dam.jpa.ejercicio01.service.CategoriaService;
import com.salesianostriana.dam.jpa.ejercicio01.service.ProductoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;

@Component
@RequiredArgsConstructor
public class MainDeMentira {

    private final CategoriaService categoriaService;
    private final ProductoService productoService;

    @PostConstruct
    public void run() {

        Categoria c = Categoria.builder()
                .nombre("Embutidos")
                .build();

        categoriaService.add(c);

        Categoria c1 = Categoria.builder()
                .nombre("Jamones")
                .build();

        c1.addCategoriaHija(c);

        categoriaService.add(c1);

        Producto p = Producto.builder()
                .nombre("Chorizo")
                .pvp(3.7)
                .build();

        Producto p1 = Producto.builder()
                .nombre("Jamón Ibérico de Bellota")
                .pvp(120.4)
                .build();

        Producto p2 = Producto.builder()
                .nombre("Mortadela Siciliana")
                .pvp(2.4)
                .build();

        List<Producto> productoList = List.of(p, p1, p2);

        p.addToCategoria(c);
        p1.addToCategoria(c1);
        p2.addToCategoria(c);

        productoService.addAll(productoList);

        categoriaService.findAll().forEach(categoria -> {
            System.out.println("Categoría: " + categoria.toString());
            categoria.getProductos().forEach(System.out::println);
        });

    }

}
