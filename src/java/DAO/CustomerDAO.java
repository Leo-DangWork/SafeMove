/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
import java.sql.*;
import java.util.*;
import model.Customer;
import utils.DButil;
/**
 *
 * @author Dzung
 */
public class CustomerDAO {
    public void insert(Customer c) throws Exception {
        String sql = """
            INSERT INTO Customer(username, password, full_name, phone)
            VALUES (?, ?, ?, ?)
        """;
        try (Connection con = DButil.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, c.getUsername());
            ps.setString(2, c.getPassword());
            ps.setString(3, c.getFullName());
            ps.setString(4, c.getPhone());
            ps.executeUpdate();
        }
    }

    public Customer findByUsername(String username) throws Exception {
        String sql = "SELECT * FROM Customer WHERE username = ?";
        try (Connection con = DButil.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Customer(
                    rs.getInt("customer_id"),
                    rs.getString("username"),
                    rs.getString("password"),
                    rs.getString("full_name"),
                    rs.getString("phone")
                );
            }
        }
        return null;
    }
}
