/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author daniel
 */
public class ConnectionFactory {

    public static final String DRIVER = "com.mysql.jdbc.Driver";
    public static final String URL = "jdbc:mysql://sql527.main-hosting.eu:3306/u206807805_todoApp";
    public static final String USER = "u206807805_tdapuser";
    public static final String PASSWORD = "SE:*iA0N*7a";

    public static Connection getConnection() throws RunTimeException {
        try {
            Class.forName(DRIVER);
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (Exception ex) {
            throw new RunTimeException("Erro na conexão com o banco de dados", ex);
        }
    }

    public static void closeConnection(Connection connection) throws RunTimeException {

        try {
            if (connection != null) {
                connection.close();
            }

        } catch (Exception ex) {
            throw new RunTimeException("Erro ao fechar conexão com o banco de dados", ex);
        }
    }

}
