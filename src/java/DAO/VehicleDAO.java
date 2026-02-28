/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
import model.Vehicle;
import utils.DButil;
import java.sql.*;
/**
 *
 * @author Dzung
 */
public class VehicleDAO extends DButil{
    public Vehicle findAvailableVehicleByType(int vehicleTypeId) throws Exception {
        String sql = """
            SELECT TOP 1 * FROM Vehicle
            WHERE vehicle_type_id = ?
              AND status = 'AVAILABLE'
        """;

        try (PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setInt(1, vehicleTypeId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Vehicle(
                    rs.getInt("vehicle_id"),
                    rs.getInt("vehicle_manager_staff_id"),
                    rs.getInt("vehicle_type_id"),
                    rs.getString("plate_number"),
                    rs.getString("status")
                );
            }
        }
        return null;
    }
}
