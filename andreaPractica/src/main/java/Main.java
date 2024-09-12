import models.Pedido;
import models.PedidoManager;

import models.Asistencia;
import models.AsistenciaManager;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Main main = new Main();
        main.asistencias();
    }

    public void pedidos(){
        Scanner scanner = new Scanner(System.in);
        ArrayList<Pedido> pedidos = new ArrayList<>();

        int opcion;
        do {
            System.out.println("==== MENÚ DE TIENDA ONLINE ====");
            System.out.println("1. Crear un nuevo pedido");
            System.out.println("2. Agregar producto a un pedido");
            System.out.println("3. Cambiar estado de un pedido");
            System.out.println("4. Mostrar todos los pedidos");
            System.out.println("5. Mostrar productos de un pedido");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar si no da error por alguna razon

            switch (opcion) {
                case 1:
                    pedidos.add(PedidoManager.crearPedido(scanner));
                    break;
                case 2:
                    if (!pedidos.isEmpty()) {
                        PedidoManager.agregarProductoAPedido(pedidos, scanner);
                    } else {
                        System.out.println("No hay pedidos creados. Primero debe crear un pedido.\n");
                    }
                    break;
                case 3:
                    if (!pedidos.isEmpty()) {
                        PedidoManager.cambiarEstadoDePedido(pedidos, scanner);
                    } else {
                        System.out.println("No hay pedidos creados. Primero debe crear un pedido.\n");
                    }
                    break;
                case 4:
                    PedidoManager.mostrarPedidos(pedidos);
                    break;
                case 5:
                    if (!pedidos.isEmpty()) {
                        PedidoManager.mostrarProductosDePedido(pedidos, scanner);
                    } else {
                        System.out.println("No hay pedidos creados. Primero debe crear un pedido.\n");
                    }
                    break;
                case 6:
                    System.out.println("Adios");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 6);
    }

    public void asistencias(){
        Scanner scanner = new Scanner(System.in);
        AsistenciaManager asistenciaManager = new AsistenciaManager();

        int opcion;
        do {
            System.out.println("---- MENÚ ASISTENCIAS ----");
            System.out.println("1. Marcar asistencia");
            System.out.println("2. Generar reporte de asistencia");
            System.out.println("3. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer

            switch (opcion) {
                case 1:
                    asistenciaManager.marcarAsistencia(scanner);
                    break;
                case 2:
                    asistenciaManager.generarReporte();
                    break;
                case 3:
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 3);
    }

}

