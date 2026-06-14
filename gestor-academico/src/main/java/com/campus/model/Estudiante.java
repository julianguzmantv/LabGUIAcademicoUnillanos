package com.campus.model;

public class Estudiante extends Persona {
    private String codigo;
    private Programa programa;
    private double promedio;
    private boolean activo;

    public Estudiante(double id, String nombres, String apellidos, String email, String codigo, Programa programa, double promedio, boolean activo) {
        super(id, nombres, apellidos, email);
        this.codigo = codigo;
        this.programa = programa;
        this.promedio = promedio;
        this.activo = activo;
    }

    // Getters y Setters
    public String getCodigo() { return codigo; }
    public void setCodigo(String codigo) { this.codigo = codigo; }
    public Programa getPrograma() { return programa; }
    public void setPrograma(Programa programa) { this.programa = programa; }
    public double getPromedio() { return promedio; }
    public void setPromedio(double promedio) { this.promedio = promedio; }
    public boolean isActivo() { return activo; }
    public void setActivo(boolean activo) { this.activo = activo; }

    @Override
    public String toString() {
        return "Estudiante{" +
               "codigo='" + codigo + '\'' +
               ", programa=" + programa.getNombre() +
               ", promedio=" + promedio +
               ", activo=" + activo +
               '}';
    }
}
