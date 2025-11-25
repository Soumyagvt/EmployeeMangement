package com.ems.dao;
import com.ems.model.Department;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DepartmentDAO {
    public void addDepartment(Department dept) {
        String sql = "INSERT INTO departments (name) VALUES (?)";
        try (Connection conn = DBConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, dept.getName());
            stmt.executeUpdate();
            System.out.println("Department added!");
        } catch (SQLException e) { e.printStackTrace(); }
    }

    public List<Department> getAllDepartments() {
        List<Department> depts = new ArrayList<>();
        String sql = "SELECT * FROM departments";
        try (Connection conn = DBConnection.getConnection(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) depts.add(new Department(rs.getInt("id"), rs.getString("name")));
        } catch (SQLException e) { e.printStackTrace(); }
        return depts;
    }
}