package models;
import java.util.ArrayList;

public class Pedido {
    private int idPedido;
    private ArrayList<Producto> productos;
    private boolean procesado;

    public Pedido(int idPedido) {
        this.idPedido = idPedido;
        this.productos = new ArrayList<>();
        this.procesado = false;
    }

    public int getIdPedido() {
        return idPedido;
    }

    public void agregarProducto(Producto producto) {
        productos.add(producto);
    }

    public void cambiarEstado(boolean estado) {
        this.procesado = estado;
    }

    public String obtenerEstado() {
        return procesado ? "Procesado" : "No procesado";
    }

    public void mostrarPedido() {
        System.out.println("Pedido ID: " + idPedido);
        System.out.println("Estado: " + obtenerEstado());
        mostrarProductos();
        System.out.println();
    }

    public void mostrarProductos() {
        if (productos.isEmpty()) {
            System.out.println("El pedido no tiene productos.");
        } else {
            System.out.println("Productos en el pedido:");
            for (Producto producto : productos) {
                System.out.println("- " + producto.getNombre() + " | Precio: $" + producto.getPrecio());
            }
        }
    }
}
