package com.campus.model;

public class Curso {
    private double id;
    private String nombre;
    private String programa; // String en lugar de objeto Programa
    private boolean activo;
    
    // Constructor por defecto, necesario para operaciones de la base de datos
    public Curso() {}

    public Curso(double id, String nombre, String programa, boolean activo) {
        this.id = id;
        this.nombre = nombre;
        this.programa = programa;
        this.activo = activo;
    }

    // Getters y Setters
    public double getId() { return id; }
    public void setId(double id) { this.id = id; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getPrograma() { return programa; }
    public void setPrograma(String programa) { this.programa = programa; }
    public boolean isActivo() { return activo; }
    public void setActivo(boolean activo) { this.activo = activo; }

    @Override
    public String toString() {
        return "Curso{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", programa=" + programa +
                ", activo=" + activo +
                '}';
    }
}
