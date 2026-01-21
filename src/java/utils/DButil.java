/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author Dzung
 */
public class DButil {
    private static String url = "jdbc:sqlserver://localhost;instanceName=SQLEXPRESS;"
                                + "databaseName=SafeMove;"
                                + "encrypt=false;trustServerCertificate=true";
    private static String user = "sa";
    private static String pass = "123456";

    static {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Cannot load SQL Server Driver", e);
        }
    }

    public static Connection getConnection() throws SQLException{
        return DriverManager.getConnection(url, user, pass);
    }

}
