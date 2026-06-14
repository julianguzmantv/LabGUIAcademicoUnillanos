package com.campus.logic;

import com.campus.config.DbProperties;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.text.SimpleDateFormat;

public class DatabaseTimeAdapter {

    private final DbProperties properties;

    // Inyección a través del constructor (Fábrica Externa/Autowired)
    public DatabaseTimeAdapter(DbProperties properties) {
        this.properties = properties;
    }

    public String getCurrentServerTime(Connection conn) {
        // La función SQL cambia según el motor (Oracle usa SYSDATE, MySQL usa NOW(), H2 usa CURRENT_TIMESTAMP())
        String sqlFunction = properties.getTimeFunction();
        String sql = "SELECT " + sqlFunction;
        
        System.out.println("Ejecutando consulta de hora: " + sql + " en " + properties.getDbName());

        try (PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
            
            if (rs.next()) {
                Date dbTime = rs.getTimestamp(1);
                SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
                return formatter.format(dbTime);
            }
        } catch (SQLException e) {
            System.err.println("Error al obtener la hora del servidor de BD (" + properties.getDbName() + "): " + e.getMessage());
        }
        return "N/A";
    }
}
