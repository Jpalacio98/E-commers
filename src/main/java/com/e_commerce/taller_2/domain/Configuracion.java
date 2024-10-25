package com.e_commerce.taller_2.domain;

import java.util.Properties;

public class Configuracion {
    public static String configureAdapterDB() {
        // Simulación de lectura de un archivo de configuración (por ejemplo application.properties)
        Properties properties = new Properties();
        properties.setProperty("dbType", "MySQL"); // Cambiar a "Oracle" según se necesite

        return properties.getProperty("dbType");
    }
}
