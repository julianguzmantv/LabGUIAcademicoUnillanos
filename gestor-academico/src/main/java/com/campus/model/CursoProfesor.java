package com.campus.model;

public class CursoProfesor {
    private int id;
    private int cursoId;
    private int profesorId;
    private Profesor profesor;
    private int anio;
    private int semestre;
    private Curso curso;
    
    // Default constructor is required for the Database class
    public CursoProfesor() {}

    public CursoProfesor(Profesor profesor, int anio, int semestre, Curso curso) {
        this.profesor = profesor;
        this.anio = anio;
        this.semestre = semestre;
        this.curso = curso;
    }

    // New getters and setters for database fields
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCursoId() {
        return cursoId;
    }

    public void setCursoId(int cursoId) {
        this.cursoId = cursoId;
    }

    public int getProfesorId() {
        return profesorId;
    }

    public void setProfesorId(int profesorId) {
        this.profesorId = profesorId;
    }
    
    // Original getters and setters
    public Profesor getProfesor() { return profesor; }
    public void setProfesor(Profesor profesor) { this.profesor = profesor; }
    public int getAnio() { return anio; }
    public void setAnio(int anio) { this.anio = anio; }
    public int getSemestre() { return semestre; }
    public void setSemestre(int semestre) { this.semestre = semestre; }
    public Curso getCurso() { return curso; }
    public void setCurso(Curso curso) { this.curso = curso; }

    @Override
    public String toString() {
        return "CursoProfesor{" +
                "profesor=" + profesor.getNombres() + " " + profesor.getApellidos() +
                ", anio=" + anio +
                ", semestre=" + semestre +
                ", curso=" + curso.getNombre() +
                '}';
    }
}
