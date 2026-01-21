/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import model.Service;
import java.util.*;
import utils.DButil;
import java.sql.*;

/**
 *
 * @author Dzung
 */
public class ServiceDAO {
    public List<Service> getAll() throws Exception {
        List<Service> list = new ArrayList<>();
        String sql = "SELECT * FROM Service";

        try (Connection con = DButil.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                list.add(new Service(
                    rs.getInt("service_id"),
                    rs.getInt("vehicle_type_id"),
                    rs.getString("service_name"),
                    rs.getString("description"),
                    rs.getDouble("base_price")
                ));
            }
        }
        return list;
    }
}
