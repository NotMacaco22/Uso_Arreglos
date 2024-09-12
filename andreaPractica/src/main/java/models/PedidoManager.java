package models;

import java.util.ArrayList;
import java.util.Scanner;

public class PedidoManager {

    public static Pedido crearPedido(Scanner scanner) {
        System.out.print("Ingrese el ID del nuevo pedido: ");
        int idPedido = scanner.nextInt();
        scanner.nextLine();

        return new Pedido(idPedido); // Crear y devolver el nuevo pedido
    }

    public static void agregarProductoAPedido(ArrayList<Pedido> pedidos, Scanner scanner) {
        mostrarPedidos(pedidos);
        System.out.print("Seleccione el ID del pedido al que desea agregar un producto: ");
        int idPedido = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer

        Pedido pedido = buscarPedidoPorId(pedidos, idPedido);
        if (pedido != null) {
            System.out.print("Ingrese el nombre del producto: ");
            String nombreProducto = scanner.nextLine();
            System.out.print("Ingrese el precio del producto: ");
            double precioProducto = scanner.nextDouble();
            scanner.nextLine();

            Producto producto = new Producto(nombreProducto, precioProducto);
            pedido.agregarProducto(producto); // Agregar el producto al pedido
            System.out.println("Producto agregado exitosamente.\n");
        } else {
            System.out.println("Pedido no encontrado.\n");
        }
    }

    public static void cambiarEstadoDePedido(ArrayList<Pedido> pedidos, Scanner scanner) {
        mostrarPedidos(pedidos);
        System.out.print("Seleccione el ID del pedido cuyo estado desea cambiar: ");
        int idPedido = scanner.nextInt();
        scanner.nextLine();

        Pedido pedido = buscarPedidoPorId(pedidos, idPedido);
        if (pedido != null) {
            System.out.print("Ingrese el nuevo estado del pedido (1 para procesado, 0 para no procesado): ");
            int nuevoEstado = scanner.nextInt();
            scanner.nextLine();

            boolean procesado = nuevoEstado == 1;
            pedido.cambiarEstado(procesado); // Cambiar el estado del pedido
            System.out.println("Estado del pedido actualizado.\n");
        } else {
            System.out.println("Pedido no encontrado.\n");
        }
    }

    public static void mostrarPedidos(ArrayList<Pedido> pedidos) {
        if (pedidos.isEmpty()) {
            System.out.println("No hay pedidos disponibles.\n");
        } else {
            System.out.println("Lista de pedidos:");
            for (Pedido pedido : pedidos) {
                System.out.println("ID Pedido: " + pedido.getIdPedido() + " | Estado: " + pedido.obtenerEstado());
            }
            System.out.println();
        }
    }

    public static void mostrarProductosDePedido(ArrayList<Pedido> pedidos, Scanner scanner) {
        mostrarPedidos(pedidos);
        System.out.print("Seleccione el ID del pedido para ver sus productos: ");
        int idPedido = scanner.nextInt();
        scanner.nextLine();

        Pedido pedido = buscarPedidoPorId(pedidos, idPedido);
        if (pedido != null) {
            pedido.mostrarProductos(); // Mostrar los productos del pedido
        } else {
            System.out.println("Pedido no encontrado.\n");
        }
    }

    private static Pedido buscarPedidoPorId(ArrayList<Pedido> pedidos, int idPedido) {
        for (Pedido pedido : pedidos) {
            if (pedido.getIdPedido() == idPedido) {
                return pedido;
            }
        }
        return null;
    }
}
