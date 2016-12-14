/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


/**
 *
 * @author Mylena
 */

public class ConnectionFactory {
      public static java.sql.Connection getConnection() {  
        Connection connection = null;  
  
        try {  
          
            Class.forName("com.mysql.jdbc.Driver");  
  
            String url = "jdbc:mysql://localhost:3306/projetobanca";  
            String username = "root";   
            String password = "";  
              
            connection = DriverManager.getConnection(url, username, password);
  
            return connection;  
              
        } catch (ClassNotFoundException e) {              
            System.out.println("O driver expecificado nao foi encontrado.");  
            return null;  
              
        } catch (SQLException e) {  
            System.out.println("Nao foi possivel conectar ao banco de dados.");  
            return null;  
        }  
    }  
   
}
