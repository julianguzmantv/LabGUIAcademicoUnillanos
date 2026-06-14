package com.campus.view;
import com.campus.dao.Database;
import com.campus.model.Profesor;
import com.campus.model.Curso;
import com.campus.model.CursoProfesor;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class MainFrame extends JFrame {
    private JTabbedPane tabbedPane;
    private Database db;

    private JTextField profesorIdField, profesorNombresField, profesorApellidosField, profesorEmailField, profesorContratoField;
    private JTextField cursoIdField, cursoNombreField, cursoProgramaField;
    private JCheckBox cursoActivoField;
    private JTextField inscripcionProfesorIdField, inscripcionCursoIdField, inscripcionAnioField, inscripcionSemestreField;
    private JTable inscripcionesTable;
    private DefaultTableModel inscripcionesTableModel;

    public MainFrame() {
        setTitle("Gestor Académico");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        db = new Database();
        Database.initialize(); // Inicializar la base de datos y tablas

        // Precargar algunos datos
        precargarDatos();

        tabbedPane = new JTabbedPane();

        // Pestaña Profesores
        JPanel profesoresPanel = createProfesoresPanel();
        tabbedPane.addTab("Profesores", profesoresPanel);

        // Pestaña Cursos
        JPanel cursosPanel = createCursosPanel();
        tabbedPane.addTab("Cursos", cursosPanel);

        // Pestaña Cursos Profesores
        JPanel inscripcionesPanel = createInscripcionesPanel();
        tabbedPane.addTab("Cursos Profesores", inscripcionesPanel);
        
        // Pestaña Estudiantes
        JPanel estudiantesPanel = createEstudiantesPanel();
        tabbedPane.addTab("Estudiantes", estudiantesPanel);
        
        // Pestaña Inscripciones de Estudiantes
        JPanel inscripcionesEstudiantesPanel = createInscripcionesEstudiantesPanel();
        tabbedPane.addTab("Inscripciones Estudiantes", inscripcionesEstudiantesPanel);

        add(tabbedPane);
        setVisible(true);
    }

    private JPanel createProfesoresPanel() {
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        profesorIdField = new JTextField(10);
        profesorNombresField = new JTextField(20);
        profesorApellidosField = new JTextField(20);
        profesorEmailField = new JTextField(20);
        profesorContratoField = new JTextField(20);

        gbc.gridx = 0; gbc.gridy = 0; panel.add(new JLabel("ID:"), gbc);
        gbc.gridx = 1; gbc.gridy = 0; panel.add(profesorIdField, gbc);
        gbc.gridx = 0; gbc.gridy = 1; panel.add(new JLabel("Nombres:"), gbc);
        gbc.gridx = 1; gbc.gridy = 1; panel.add(profesorNombresField, gbc);
        gbc.gridx = 0; gbc.gridy = 2; panel.add(new JLabel("Apellidos:"), gbc);
        gbc.gridx = 1; gbc.gridy = 2; panel.add(profesorApellidosField, gbc);
        gbc.gridx = 0; gbc.gridy = 3; panel.add(new JLabel("Email:"), gbc);
        gbc.gridx = 1; gbc.gridy = 3; panel.add(profesorEmailField, gbc);
        gbc.gridx = 0; gbc.gridy = 4; panel.add(new JLabel("Tipo de Contrato:"), gbc);
        gbc.gridx = 1; gbc.gridy = 4; panel.add(profesorContratoField, gbc);

        JButton addButton = new JButton("Agregar Profesor");
        addButton.addActionListener(e -> {
            try {
                double id = Double.parseDouble(profesorIdField.getText());
                String nombres = profesorNombresField.getText();
                String apellidos = profesorApellidosField.getText();
                String email = profesorEmailField.getText();
                String contrato = profesorContratoField.getText();
                db.addProfesor(new Profesor(id, nombres, apellidos, email, contrato));
                JOptionPane.showMessageDialog(this, "Profesor agregado.");
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "ID debe ser un número válido.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
        gbc.gridx = 0; gbc.gridy = 5; gbc.gridwidth = 2; panel.add(addButton, gbc);

        return panel;
    }

    private JPanel createCursosPanel() {
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        cursoIdField = new JTextField(10);
        cursoNombreField = new JTextField(20);
        cursoProgramaField = new JTextField(20);
        cursoActivoField = new JCheckBox("Activo");

        gbc.gridx = 0; gbc.gridy = 0; panel.add(new JLabel("ID:"), gbc);
        gbc.gridx = 1; gbc.gridy = 0; panel.add(cursoIdField, gbc);
        gbc.gridx = 0; gbc.gridy = 1; panel.add(new JLabel("Nombre:"), gbc);
        gbc.gridx = 1; gbc.gridy = 1; panel.add(cursoNombreField, gbc);
        gbc.gridx = 0; gbc.gridy = 2; panel.add(new JLabel("Programa:"), gbc);
        gbc.gridx = 1; gbc.gridy = 2; panel.add(cursoProgramaField, gbc);
        gbc.gridx = 0; gbc.gridy = 3; panel.add(new JLabel("Estado:"), gbc);
        gbc.gridx = 1; gbc.gridy = 3; panel.add(cursoActivoField, gbc);

        JButton addButton = new JButton("Agregar Curso");
        addButton.addActionListener(e -> {
            try {
                double id = Double.parseDouble(cursoIdField.getText());
                String nombre = cursoNombreField.getText();
                String programa = cursoProgramaField.getText();
                boolean activo = cursoActivoField.isSelected();
                db.addCurso(new Curso(id, nombre, programa, activo));
                JOptionPane.showMessageDialog(this, "Curso agregado.");
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "ID debe ser un número válido.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
        gbc.gridx = 0; gbc.gridy = 4; gbc.gridwidth = 2; panel.add(addButton, gbc);
        
        return panel;
    }

    private JPanel createInscripcionesPanel() {
        JPanel panel = new JPanel(new BorderLayout());

        // Panel de entrada de datos
        JPanel inputPanel = new JPanel(new FlowLayout());
        inscripcionProfesorIdField = new JTextField(5);
        inscripcionCursoIdField = new JTextField(5);
        inscripcionAnioField = new JTextField(5);
        inscripcionSemestreField = new JTextField(5);
        JButton addButton = new JButton("Guardar");
        JButton refreshButton = new JButton("Refrescar");

        inputPanel.add(new JLabel("ID Profesor:"));
        inputPanel.add(inscripcionProfesorIdField);
        inputPanel.add(new JLabel("ID Curso:"));
        inputPanel.add(inscripcionCursoIdField);
        inputPanel.add(new JLabel("Año:"));
        inputPanel.add(inscripcionAnioField);
        inputPanel.add(new JLabel("Semestre:"));
        inputPanel.add(inscripcionSemestreField);
        inputPanel.add(addButton);
        inputPanel.add(refreshButton);

        // Tabla
        String[] columnNames = {"ID Profesor", "ID Curso", "Nombre Profesor", "Nombre Curso", "Año", "Semestre"};
        inscripcionesTableModel = new DefaultTableModel(columnNames, 0);
        inscripcionesTable = new JTable(inscripcionesTableModel);
        JScrollPane scrollPane = new JScrollPane(inscripcionesTable);

        // Acciones
        addButton.addActionListener(e -> {
            try {
                double profId = Double.parseDouble(inscripcionProfesorIdField.getText());
                double cursoId = Double.parseDouble(inscripcionCursoIdField.getText());
                int anio = Integer.parseInt(inscripcionAnioField.getText());
                int semestre = Integer.parseInt(inscripcionSemestreField.getText());

                Profesor profesor = findProfesorById(profId);
                Curso curso = findCursoById(cursoId);

                if (profesor != null && curso != null) {
                    db.addCursoProfesor(new CursoProfesor(profesor, anio, semestre, curso));
                    refreshInscripcionesTable();
                    JOptionPane.showMessageDialog(this, "Inscripción guardada.");
                } else {
                    JOptionPane.showMessageDialog(this, "Profesor o Curso no encontrado.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "ID, Año y Semestre deben ser números válidos.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        refreshButton.addActionListener(e -> refreshInscripcionesTable());
        
        panel.add(inputPanel, BorderLayout.NORTH);
        panel.add(scrollPane, BorderLayout.CENTER);

        refreshInscripcionesTable();
        return panel;
    }
    
    // Métodos placeholder para las pestañas no implementadas
    private JPanel createEstudiantesPanel() {
        JPanel panel = new JPanel();
        panel.add(new JLabel("Pestaña Estudiantes (sin funcionalidad completa)"));
        return panel;
    }
    
    private JPanel createInscripcionesEstudiantesPanel() {
        JPanel panel = new JPanel();
        panel.add(new JLabel("Pestaña Inscripciones de Estudiantes (sin funcionalidad completa)"));
        return panel;
    }

    private void refreshInscripcionesTable() {
        inscripcionesTableModel.setRowCount(0); // Limpiar la tabla
        List<CursoProfesor> inscripciones = db.getCursoProfesores();
        for (CursoProfesor cp : inscripciones) {
            Object[] row = {
                cp.getProfesor().getId(),
                cp.getCurso().getId(),
                cp.getProfesor().getNombres() + " " + cp.getProfesor().getApellidos(),
                cp.getCurso().getNombre(),
                cp.getAnio(),
                cp.getSemestre()
            };
            inscripcionesTableModel.addRow(row);
        }
    }

    private Profesor findProfesorById(double id) {
        List<Profesor> profesores = db.getProfesores();
        for (Profesor p : profesores) {
            if (p.getId() == id) {
                return p;
            }
        }
        return null;
    }

    private Curso findCursoById(double id) {
        List<Curso> cursos = db.getCursos();
        for (Curso c : cursos) {
            if (c.getId() == id) {
                return c;
            }
        }
        return null;
    }
    
    private void precargarDatos() {
        // Precarga de profesores
        db.addProfesor(new Profesor(101, "Carlos", "Perez", "carlos.perez@uni.edu", "Planta"));
        db.addProfesor(new Profesor(102, "Maria", "Gomez", "maria.gomez@uni.edu", "Cátedra"));

        // Precarga de cursos
        db.addCurso(new Curso(201, "Algoritmos y Estructuras de Datos", "Ingeniería de Sistemas", true));
        db.addCurso(new Curso(202, "Programación Orientada a Objetos", "Ingeniería de Software", true));
    }
}
