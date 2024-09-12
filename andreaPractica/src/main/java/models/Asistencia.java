package models;

import java.time.LocalDate;

public class Asistencia {
    private LocalDate fecha;
    private String estudiante;
    private boolean presente;

    public Asistencia(LocalDate fecha, String estudiante, boolean presente) {
        this.fecha = fecha;
        this.estudiante = estudiante;
        this.presente = presente;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public String getEstudiante() {
        return estudiante;
    }

    public boolean isPresente() {
        return presente;
    }

    public String obtenerEstado() {
        return presente ? "Presente" : "Ausente";
    }

    @Override
    public String toString() {
        return "Fecha: " + fecha + ", Estudiante: " + estudiante + ", Estado: " + obtenerEstado();
    }
}
