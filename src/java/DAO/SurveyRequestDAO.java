/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
import java.sql.*;
import utils.DButil;
import model.SurveyRequest;

/**
 *
 * @author Dzung
 */
public class SurveyRequestDAO extends DButil{
    public int insert(SurveyRequest s) throws Exception {
        String sql = """
            INSERT INTO Survey_Request
            (customer_id, service_id, pickup_address, destination_address,
             start_date, num_staff, estimated_price, estimated_distance_km, status)
            VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)
        """;

        try (PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            ps.setInt(1, s.getCustomerId());
            ps.setInt(2, s.getServiceId());
            ps.setString(3, s.getPickupAddress());
            ps.setString(4, s.getDestinationAddress());
            ps.setTimestamp(5, Timestamp.valueOf(s.getStartDate()));
            ps.setInt(6, s.getNumStaff());
            ps.setDouble(7, s.getEstimatedPrice());
            ps.setDouble(8, s.getEstimatedDistanceKm());
            ps.setString(9, s.getStatus());

            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) return rs.getInt(1);
        }
        return -1;
    }
}
