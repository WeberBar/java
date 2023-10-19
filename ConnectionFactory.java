
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    private static String db = "db_produto";
    private static String url = "jdbc:mysql://localhost:3306/"+db+"?zeroDateTimeBehavior=CONVERT_TO_NULL&useTimezone=true&serverTimezone=UTC";
    private static String usuario = "root";
    private static String senha = "W3b2004@";
    
    public static Connection getConnection(){
        try {
            return DriverManager.getConnection(url,usuario,senha);
        } catch (SQLException ex) {
            System.out.println(ConnectionFactory.class.getName()+ " "+ ex.getMessage());
        }
        return null;
    }
}
