package com.employee;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAO {
    private static final String URL = "jdbc:mysql://localhost:3306/employee_db";
    private static final String USER = "root";
    private static final String PASSWORD = "Soumya@2000";

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    // Add employee (updated for new fields)
    public void addEmployee(Employee emp) {
        String sql = "INSERT INTO employees (name, email, department, salary, phone, dob, hire_date, address, position, manager_id, gender, emergency_contact) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, emp.getName());
            stmt.setString(2, emp.getEmail());
            stmt.setString(3, emp.getDepartment());
            stmt.setDouble(4, emp.getSalary());
            stmt.setString(5, emp.getPhone());
            stmt.setDate(6, emp.getDob());
            stmt.setDate(7, emp.getHireDate());
            stmt.setString(8, emp.getAddress());
            stmt.setString(9, emp.getPosition());
            stmt.setInt(10, emp.getManagerId());
            stmt.setString(11, emp.getGender());
            stmt.setString(12, emp.getEmergencyContact());
            stmt.executeUpdate();
            System.out.println("Employee added successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Get all employees (updated to fetch new fields)
    public List<Employee> getAllEmployees() {
        List<Employee> employees = new ArrayList<>();
        String sql = "SELECT * FROM employees";
        try (Connection conn = getConnection(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                employees.add(new Employee(
                    rs.getInt("id"), rs.getString("name"), rs.getString("email"), rs.getString("department"), rs.getDouble("salary"),
                    rs.getString("phone"), rs.getDate("dob"), rs.getDate("hire_date"), rs.getString("address"),
                    rs.getString("position"), rs.getInt("manager_id"), rs.getString("gender"), rs.getString("emergency_contact")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employees;
    }

    // Update employee (updated for new fields)
    public void updateEmployee(int id, Employee emp) {
        String sql = "UPDATE employees SET name=?, email=?, department=?, salary=?, phone=?, dob=?, hire_date=?, address=?, position=?, manager_id=?, gender=?, emergency_contact=? WHERE id=?";
        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, emp.getName());
            stmt.setString(2, emp.getEmail());
            stmt.setString(3, emp.getDepartment());
            stmt.setDouble(4, emp.getSalary());
            stmt.setString(5, emp.getPhone());
            stmt.setDate(6, emp.getDob());
            stmt.setDate(7, emp.getHireDate());
            stmt.setString(8, emp.getAddress());
            stmt.setString(9, emp.getPosition());
            stmt.setInt(10, emp.getManagerId());
            stmt.setString(11, emp.getGender());
            stmt.setString(12, emp.getEmergencyContact());
            stmt.setInt(13, id);
            int rows = stmt.executeUpdate();
            if (rows > 0) System.out.println("Employee updated!");
            else System.out.println("Employee not found.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Delete employee (unchanged)
    public void deleteEmployee(int id) {
        String sql = "DELETE FROM employees WHERE id=?";
        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            int rows = stmt.executeUpdate();
            if (rows > 0) System.out.println("Employee deleted!");
            else System.out.println("Employee not found.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}