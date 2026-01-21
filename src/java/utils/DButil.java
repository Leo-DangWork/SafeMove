/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;
import java.sql.Connection;
import java.sql.DriverManager;
/**
 *
 * @author Dzung
 */
public class DButil {
    public static Connection getConnection() throws Exception {
        String url = "jdbc:sqlserver://localhost;instanceName=SQLEXPRESS;"
                   + "databaseName=SafeMove;"
                   + "encrypt=false;trustServerCertificate=true";
        String user = "sa";
        String pass = "123456";

        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        return DriverManager.getConnection(url, user, pass);
    }

}
