package com.campus.config;

import java.util.Properties;

// Simulación de un Bean/Componente para Autowired
public class DbProperties {

    private final Properties properties = new Properties();

    public DbProperties() {

        properties.setProperty("db.name", "H2");
        properties.setProperty("db.url", "jdbc:h2:./data/campus");
        properties.setProperty("db.username", "sa");
        properties.setProperty("db.password", "");
        properties.setProperty("db.driver", "org.h2.Driver");
        properties.setProperty("db.time.function", "CURRENT_TIMESTAMP()");
        
        System.out.println("Configuración de BD cargada: " + properties.getProperty("db.name"));
    }

    public String getUrl() {
        return properties.getProperty("db.url");
    }

    public String getUsername() {
        return properties.getProperty("db.username");
    }

    public String getPassword() {
        return properties.getProperty("db.password");
    }

    public String getDriver() {
        return properties.getProperty("db.driver");
    }
    
    public String getTimeFunction() {
        // Esta función es vital para el Adaptador
        return properties.getProperty("db.time.function");
    }
    
    public String getDbName() {
        return properties.getProperty("db.name");
    }
}
