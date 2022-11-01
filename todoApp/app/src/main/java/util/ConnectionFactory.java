/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author daniel
 */
public class ConnectionFactory {

    //public static final String DRIVER = "com.mysql.jdbc.Driver"; 
   public static final String DRIVER =  "com.mysql.cj.jdbc.Driver";
    public static final String URL = "jdbc:mysql://localhost:3306/NOME_BANCO";
    public static final String USER = "USUARIO_BANCO";
    public static final String PASSWORD = "SENHA_BANCO";

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

    
    public static void closeConnection(Connection connection,PreparedStatement statement) throws RunTimeException {

        try {
            if (connection != null) {
                connection.close();
            }
            
            if(statement!=null){
                statement.close();
            }

        } catch (Exception ex) {
            throw new RunTimeException("Erro ao fechar conexão com o banco de dados", ex);
        }
    }
    
    public static void closeConnection(Connection connection,PreparedStatement statement,ResultSet resultSet) throws RunTimeException {

        try {
            if (connection != null) {
                connection.close();
            }
            
            if(statement!=null){
                statement.close();
            }
            
             if(resultSet!=null){
                resultSet.close();
            }

        } catch (Exception ex) {
            throw new RunTimeException("Erro ao fechar conexão com o banco de dados", ex);
        }
    }
}
