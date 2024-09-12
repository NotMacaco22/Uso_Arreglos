package models;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class AsistenciaManager {
    private ArrayList<Asistencia> registroAsistencias;

    public AsistenciaManager() {
        this.registroAsistencias = new ArrayList<>();
    }

    public void marcarAsistencia(Scanner scanner) {
        System.out.print("Ingrese el nombre del estudiante: ");
        String estudiante = scanner.nextLine();

        System.out.print("¿Está presente el estudiante? (1 para sí, 0 para no): ");
        int presenteInt = scanner.nextInt();
        boolean presente = presenteInt == 1;
        scanner.nextLine();

        Asistencia asistencia = new Asistencia(LocalDate.now(), estudiante, presente);
        registroAsistencias.add(asistencia);

        System.out.println("Asistencia registrada correctamente.\n");
    }

    public void generarReporte() {
        if (registroAsistencias.isEmpty()) {
            System.out.println("No hay asistencias registradas.\n");
        } else {
            System.out.println("Reporte de Asistencias:");
            for (Asistencia asistencia : registroAsistencias) {
                System.out.println(asistencia);
            }
            System.out.println();
        }
    }
}

