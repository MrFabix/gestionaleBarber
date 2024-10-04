package com.example.barber.utils.db;
import com.example.barber.utils.exception.Trigger;
import com.example.barber.utils.exception.myecxeption.SystemException;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;




public class MySqlConnection {

    private static MySqlConnection instance;

    public static MySqlConnection getInstance() {
        if (instance == null)
            instance = new MySqlConnection();
        return instance;
    }

    private Connection connection;

    public Connection connect() throws SystemException {

        String user;
        String pass;
        String dbUrl;
        String driverClassName;

        try {
            if (connection == null || connection.isClosed()) {
                System.out.println("INIZIO CONNESSIONE");
                String resourceName = "config.properties";
                InputStream inputStream = MySqlConnection.class.getClassLoader().getResourceAsStream(resourceName);
                if (inputStream == null) {
                    throw new FileNotFoundException("File config.properties non trovato nel percorso: " + resourceName);
                }
                System.out.println("inputStream: " + inputStream);
                Properties props = new Properties();
                props.load(inputStream);
                pass = props.getProperty("PASS");
                user = props.getProperty("USER");
                dbUrl = props.getProperty("DB_URL");
                System.out.println("DBURL: " + dbUrl);
                driverClassName = props.getProperty("DRIVER_CLASS_NAME");
                Class.forName(driverClassName);
                DriverManager.setLoginTimeout(5);
                connection = DriverManager.getConnection(dbUrl, user, pass);
            }
        } catch (SQLException e) {
            Trigger trigger = new Trigger();
            trigger.throwDBConnectionFailedException(e);
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();

            throw new SystemException();
        }
        return connection;
    }


    public void closeConnection() throws SQLException { connection.close(); }
}