/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
import utils.DButil;
import java.sql.*;
/**
 *
 * @author Dzung
 */
public class PriceTableDAO {
     public double calculatePrice(int serviceId, double distanceKm) throws Exception {
        String sql = """
            SELECT price_per_km
            FROM Price_Table
            WHERE service_id = ?
              AND ? BETWEEN min_distance_km AND max_distance_km
        """;

        try (Connection con = DButil.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, serviceId);
            ps.setDouble(2, distanceKm);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getDouble("price_per_km") * distanceKm;
            }
        }
        return 0;
    }
}
