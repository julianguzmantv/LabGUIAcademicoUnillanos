package com.campus.model;

public class Programa {
    private double id;
    private String nombre;
    private double duracion;
    private String registro;
    private Facultad facultad;

    public Programa(double id, String nombre, double duracion, String registro, Facultad facultad) {
        this.id = id;
        this.nombre = nombre;
        this.duracion = duracion;
        this.registro = registro;
        this.facultad = facultad;
    }

    // Getters y Setters
    public double getId() { return id; }
    public void setId(double id) { this.id = id; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public double getDuracion() { return duracion; }
    public void setDuracion(double duracion) { this.duracion = duracion; }
    public String getRegistro() { return registro; }
    public void setRegistro(String registro) { this.registro = registro; }
    public Facultad getFacultad() { return facultad; }
    public void setFacultad(Facultad facultad) { this.facultad = facultad; }

    @Override
    public String toString() {
        return "Programa{" +
               "id=" + id +
               ", nombre='" + nombre + '\'' +
               ", duracion=" + duracion +
               ", registro='" + registro + '\'' +
               ", facultad=" + facultad.getNombre() +
               '}';
    }
}
