package com.adecco.prueba.config;

import java.sql.Statement;
import org.springframework.stereotype.Component;

/**
 * Clase de configuracion de acceso a la Base de Datos
 * 
 * @author Juan Carlos Fuyo
 *
 */
@Component
public class DataBaseConfig {

	private java.sql.Connection connection = null;
    private final String url = "jdbc:microsoft:sqlserver://";
    private final String serverName = "10.11.4.82";
    private final String portNumber = "1433";
    private final String databaseName = "dbReportesHB";
    private final String statement = "select * from prueba;";
    // Informs the driver to use server a side-cursor,
    // which permits more than one active statement
    // on a connection.
    private final String selectMethod = "Direct";

    // Constructor

    private String getConnectionUrl() {
     return url + serverName + ":" + portNumber + ";databaseName=" + databaseName + ";selectMethod=" + selectMethod + ";";
    }

    private java.sql.Connection getConnection() {
     try {
      Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
      connection = java.sql.DriverManager.getConnection(getConnectionUrl());
      if (connection != null)
       System.out.println("Connection Successful!");
     } catch (Exception e) {
      e.printStackTrace();
      System.out.println("Error Trace in getConnection() : " + e.getMessage());
     }
     return connection;
    }

    /*
     * Display the driver properties, database details
     */

    public void displayDbProperties() {
     java.sql.DatabaseMetaData dm = null;
     java.sql.ResultSet result = null;
     try {
      connection = this.getConnection();
      if (connection != null) {
       dm = connection.getMetaData();
       System.out.println("Driver Information");
       System.out.println("\tDriver Name: " + dm.getDriverName());
       System.out
        .println("\tDriver Version: " + dm.getDriverVersion());
       System.out.println("\nDatabase Information ");
       System.out.println("\tDatabase Name: " + dm.getDatabaseProductName());
       System.out.println("\tDatabase Version: " + dm.getDatabaseProductVersion());

       Statement select = connection.createStatement();
       result = select.executeQuery(statement);

       while (result.next()) {
        System.out.println("Nombre: " + result.getString(1) + "\n");
        System.out.println("Apellido: " + result.getString(2) + "\n");
        System.out.println("Dni: " + result.getString(3) + "\n");
       }
       result.close();
       result = null;
       closeConnection();
      } else
       System.out.println("Error: No active Connection");
     } catch (Exception e) {
      e.printStackTrace();
     }
     dm = null;
    }

    private void closeConnection() {
     try {
      if (connection != null)
       connection.close();
      connection = null;
     } catch (Exception e) {
      e.printStackTrace();
     }
    }

}
