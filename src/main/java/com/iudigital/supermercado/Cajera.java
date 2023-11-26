package com.iudigital.supermercado;

/**
 *
 * @author YE
 */
public class Cajera {

    private String nombre;

    public Cajera(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void procesarCompra(Cliente cliente, long initialTime) {

        System.out.println("Inicio de compra a los " + (System.currentTimeMillis() + initialTime) / 1000 + " segundos"
                + "\n" + "Cajera: " + this.nombre
                + "\n" + "Nombre del cliente: " + cliente.getNombre()
                + "\n" + "Id del cliente: " + cliente.getId() + "\n"
        );

        for (Producto p : cliente.getProductos()) {

            esperarXsegundos();
            System.out.println("Procesando = " + p.getNombre()
                    + "\n" + "Precio producto " + p.getPrecio()
                    + "\n" + "Cantidad de producto " + p.getCantidad()
                    + "\n" + "Tiempo: " + (System.currentTimeMillis() - initialTime) / 1000 + " seg" + "\n");
        }

    }

    private void esperarXsegundos() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }
}
