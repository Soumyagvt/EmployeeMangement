package com.ems.dao;
import com.ems.model.Attendance;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AttendanceDAO {
    public void addAttendance(Attendance att) {
        String sql = "INSERT INTO attendance (employee_id, date, status) VALUES (?, ?, ?)";
        try (Connection conn = DBConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, att.getEmployeeId());
            stmt.setDate(2, att.getDate());
            stmt.setString(3, att.getStatus());
            stmt.executeUpdate();
            System.out.println("Attendance added!");
        } catch (SQLException e) { e.printStackTrace(); }
    }

    public List<Attendance> getAttendanceByEmployee(int empId) {
        List<Attendance> atts = new ArrayList<>();
        String sql = "SELECT * FROM attendance WHERE employee_id = ?";
        try (Connection conn = DBConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, empId);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) atts.add(new Attendance(rs.getInt("id"), rs.getInt("employee_id"), rs.getDate("date"), rs.getString("status")));
        } catch (SQLException e) { e.printStackTrace(); }
        return atts;
    }
}