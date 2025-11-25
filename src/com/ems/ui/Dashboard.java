package com.ems.ui;

import com.ems.service.EmployeeService;
import com.ems.service.AttendanceService;  
import com.employee.Employee;  
import com.ems.model.Attendance;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;  
import java.util.List;

public class Dashboard extends JFrame {
    private EmployeeService empService = new EmployeeService();

    public Dashboard() {
        setTitle("Dashboard - Employee Management");
        setSize(600, 500);  // Larger size to fit all buttons
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        // Button: Add Employee
        JButton addButton = new JButton("Add Employee");
        addButton.setBounds(50, 50, 150, 30);
        addButton.addActionListener(e -> new EmployeeForm().setVisible(true));
        add(addButton);

        // Button: View Employees
        JButton viewButton = new JButton("View Employees");
        viewButton.setBounds(50, 100, 150, 30);
        viewButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<Employee> emps = empService.getAllEmployees();
                StringBuilder sb = new StringBuilder("Employees:\n");
                for (Employee emp : emps) sb.append(emp.toString()).append("\n");
                JOptionPane.showMessageDialog(null, sb.toString());
            }
        });
        add(viewButton);

        // Button: Update Employee (UPDATED - now prompts for ALL fields)
        JButton updateButton = new JButton("Update Employee");
        updateButton.setBounds(50, 150, 150, 30);
        updateButton.addActionListener(e -> {
            String idStr = JOptionPane.showInputDialog("Enter Employee ID to update:");
            if (idStr != null) {
                try {
                    int id = Integer.parseInt(idStr);
                    // Prompt for ALL fields (original + new)
                    String name = JOptionPane.showInputDialog("New Name:");
                    String email = JOptionPane.showInputDialog("New Email:");
                    String dept = JOptionPane.showInputDialog("New Department:");
                    String salaryStr = JOptionPane.showInputDialog("New Salary:");
                    double salary = Double.parseDouble(salaryStr);
                    String phone = JOptionPane.showInputDialog("New Phone:");
                    String dobStr = JOptionPane.showInputDialog("New DOB (YYYY-MM-DD):");
                    Date dob = Date.valueOf(dobStr);
                    String hireDateStr = JOptionPane.showInputDialog("New Hire Date (YYYY-MM-DD):");
                    Date hireDate = Date.valueOf(hireDateStr);
                    String address = JOptionPane.showInputDialog("New Address:");
                    String position = JOptionPane.showInputDialog("New Position:");
                    String managerIdStr = JOptionPane.showInputDialog("New Manager ID:");
                    int managerId = Integer.parseInt(managerIdStr);
                    String gender = JOptionPane.showInputDialog("New Gender (Male/Female/Other):");
                    String emergency = JOptionPane.showInputDialog("New Emergency Contact:");
                    
                    // Use full Employee constructor with all fields
                    empService.updateEmployee(id, new Employee(id, name, email, dept, salary, phone, dob, hireDate, address, position, managerId, gender, emergency));
                    JOptionPane.showMessageDialog(null, "Employee updated!");
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
                }
            }
        });
        add(updateButton);

        // Button: Delete Employee
        JButton deleteButton = new JButton("Delete Employee");
        deleteButton.setBounds(50, 200, 150, 30);
        deleteButton.addActionListener(e -> {
            String idStr = JOptionPane.showInputDialog("Enter Employee ID to delete:");
            if (idStr != null) {
                try {
                    int id = Integer.parseInt(idStr);
                    empService.deleteEmployee(id);
                    JOptionPane.showMessageDialog(null, "Employee deleted!");
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
                }
            }
        });
        add(deleteButton);

        // Button: Manage Departments
        JButton deptButton = new JButton("Manage Departments");
        deptButton.setBounds(250, 50, 150, 30);
        deptButton.addActionListener(e -> {
            JOptionPane.showMessageDialog(null, "Departments: IT, HR, Finance (from DB)");
            // TODO: Expand to a full DepartmentForm or integrate DepartmentService
        });
        add(deptButton);

        // Button: Track Attendance (UPDATED - now saves to database)
        JButton attendanceButton = new JButton("Track Attendance");
        attendanceButton.setBounds(250, 100, 150, 30);
        attendanceButton.addActionListener(e -> {
            String empIdStr = JOptionPane.showInputDialog("Employee ID:");
            String dateStr = JOptionPane.showInputDialog("Date (YYYY-MM-DD):");
            String status = JOptionPane.showInputDialog("Status (Present/Absent):");
            if (empIdStr != null && dateStr != null && status != null) {
                try {
                    int empId = Integer.parseInt(empIdStr);
                    java.sql.Date date = java.sql.Date.valueOf(dateStr);
                    // Create Attendance object and save via service
                    Attendance att = new Attendance(0, empId, date, status);  // ID is auto-generated
                    AttendanceService attService = new AttendanceService();
                    attService.addAttendance(att);
                    JOptionPane.showMessageDialog(null, "Attendance added for Emp ID: " + empId);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
                }
            }
        });
        add(attendanceButton);

        // Optional: Add a Logout button or more features
        JButton logoutButton = new JButton("Logout");
        logoutButton.setBounds(250, 150, 150, 30);
        logoutButton.addActionListener(e -> {
            dispose();  // Close dashboard
            new LoginPage().setVisible(true);  // Back to login
        });
        add(logoutButton);
    }
}
