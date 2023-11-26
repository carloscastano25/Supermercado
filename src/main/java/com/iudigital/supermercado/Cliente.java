package com.iudigital.supermercado;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author YE
 */
public class Cliente {

    private final long id;
    private String nombre;
    private List<Producto> productos;

    public Cliente(long id, String nombre) {
        productos = new ArrayList<>();
        this.id = id;
        this.nombre = nombre;
    }

    public long getId() {
        return id;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void añadirProducto(Producto producto) {
        productos.add(producto);
    }

}
