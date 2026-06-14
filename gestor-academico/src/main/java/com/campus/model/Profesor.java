package com.campus.model;

public class Profesor extends Persona {
    private String tipoContrato;
    
    // Constructor por defecto, necesario para operaciones de la base de datos
    public Profesor() {
        super();
    }

    public Profesor(double id, String nombres, String apellidos, String email, String tipoContrato) {
        super(id, nombres, apellidos, email);
        this.tipoContrato = tipoContrato;
    }

    // Getters y Setters
    public String getTipoContrato() { return tipoContrato; }
    public void setTipoContrato(String tipoContrato) { this.tipoContrato = tipoContrato; }

    @Override
    public String toString() {
        return "Profesor{" +
                "tipoContrato='" + tipoContrato + '\'' +
                '}';
    }
}
