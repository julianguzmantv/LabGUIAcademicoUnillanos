package com.campus.dao;

import com.campus.model.Persona;
import com.campus.model.CursoProfesor;
import com.campus.model.Profesor;
import java.util.List;
import java.util.ArrayList;

public class Servicios {
    private final Database db;

    public Servicios(Database db) {
        this.db = db;
    }
    
    /**
     * Crea un nuevo objeto Profesor y lo agrega a la base de datos a través del DAO.
     * Este método es el experto en información para la lógica de negocio de Profesor.
     * * @param nombres Los nombres del profesor.
     * @param apellidos Los apellidos del profesor.
     * @param email El correo electrónico único del profesor.
     * @param tipoContrato El tipo de contrato (e.g., "Planta", "Cátedra").
     */
    public void agregarProfesor(String nombres, String apellidos, String email, String tipoContrato) {
        // Validar la entrada de datos. El experto en información es esta clase.
        if (nombres == null || nombres.trim().isEmpty() || 
            apellidos == null || apellidos.trim().isEmpty() || 
            email == null || email.trim().isEmpty() ||
            tipoContrato == null || tipoContrato.trim().isEmpty()) {
            System.err.println("Error: Todos los campos del profesor son obligatorios.");
            return;
        }
        
        // Creador GRASP: La capa de Servicios es responsable de crear el objeto
        // de negocio (Profesor) a partir de los datos simples de la UI.
        Profesor nuevoProfesor = new Profesor();
        // Nota: Los IDs se asignan automáticamente en la BD, por lo que no los establecemos aquí.
        nuevoProfesor.setNombres(nombres);
        nuevoProfesor.setApellidos(apellidos);
        nuevoProfesor.setEmail(email);
        nuevoProfesor.setTipoContrato(tipoContrato);
        
        // Llamar al método en Database para insertar el profesor
        // Database.java espera un objeto Profesor, no solo Strings.
        db.addProfesor(nuevoProfesor);
        System.out.println("Profesor creado y enviado al DAO: " + nombres + " " + apellidos);
    }
    
    public String imprimirPosicion(int posicion) {
        // Implementación de ejemplo
        return "Posición " + posicion;
    }

    public int cantidadActual() {
        return this.db.getCursoProfesores().size();
    }

    public List<String> imprimirListado() {
        List<CursoProfesor> listado = this.db.getCursoProfesores();
        List<String> result = new ArrayList<>();
        // ... Lógica para imprimir listado ...
        return result;
    }
}
