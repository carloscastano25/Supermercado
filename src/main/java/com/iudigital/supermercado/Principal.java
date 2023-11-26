package com.iudigital.supermercado;

/**
 *
 *
 */
public class Principal implements Runnable {

    private final Cajera cajera;
    private final Cliente cliente;
    private final long initialTime;

    public Principal(Cliente cliente, Cajera cajera, long initialTime) {
        this.cajera = cajera;
        this.cliente = cliente;
        this.initialTime = initialTime;
    }

    public static void main(String[] args) {

        Cliente cliente1 = new Cliente(8653232L, "Pedro");
        cliente1.añadirProducto(new Producto(2L, "Mariano", 2, 2700));
        cliente1.añadirProducto(new Producto(4L, "Azucar", 1, 3200));
        cliente1.añadirProducto(new Producto(3L, "Papaya", 3, 1500));
        cliente1.añadirProducto(new Producto(6L, "Papa", 4, 900));

        Cliente cliente2 = new Cliente(5343123L, "Juan");
        cliente2.añadirProducto(new Producto(2L, "Arbeja", 2, 4000));
        cliente2.añadirProducto(new Producto(4L, "Guayabas 1Kg", 1, 3600));
        cliente2.añadirProducto(new Producto(3L, "Sal 1L", 3, 3000));
        cliente2.añadirProducto(new Producto(6L, "Leche 1Lt", 2, 3600));

        Cliente cliente3 = new Cliente(144323413L, "Mariano");
        cliente3.añadirProducto(new Producto(5L, "Galletas", 2, 4000));
        cliente3.añadirProducto(new Producto(1L, "Fríjoles 1Kg", 1, 3600));
        cliente3.añadirProducto(new Producto(8L, "Atún", 3, 3000));
        cliente3.añadirProducto(new Producto(9L, "Lentejas", 2, 3600));

        Cajera cajera1 = new Cajera("Cajera 1");
        Cajera cajera2 = new Cajera("Cajera 2");
        Cajera cajera3 = new Cajera("Cajera 3");

        // Tiempo inicial de referencia
        long initialTime = System.currentTimeMillis();

        try {
            Runnable process_1 = new Principal(cliente1, cajera1, initialTime);
            Runnable process_2 = new Principal(cliente2, cajera2, initialTime);
            Runnable process_3 = new Principal(cliente3, cajera3, initialTime);

            new Thread(process_1).start();
            new Thread(process_2).start();
            new Thread(process_3).start();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    @Override
    public void run() {
        this.cajera.procesarCompra(this.cliente, this.initialTime);
    }
}
