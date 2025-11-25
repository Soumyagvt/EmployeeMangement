package com.ems.ui;
import com.ems.service.EmployeeService;
import com.employee.Employee;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;

public class EmployeeForm extends JFrame {
    private JTextField nameField, emailField, deptField, salaryField, phoneField, dobField, hireDateField, positionField, managerIdField, emergencyField;
    private JTextArea addressArea;
    private JComboBox<String> genderBox;
    private JButton saveButton;
    private EmployeeService empService = new EmployeeService();

    public EmployeeForm() {
        setTitle("Add Employee");
        setSize(400, 600);  // Increased size for more fields
        setLayout(null);

        // Labels and Fields 
        int y = 20;
        nameField = new JTextField(); nameField.setBounds(120, y, 200, 25); add(new JLabel("Name:")).setBounds(20, y, 80, 25); add(nameField); y += 40;
        emailField = new JTextField(); emailField.setBounds(120, y, 200, 25); add(new JLabel("Email:")).setBounds(20, y, 80, 25); add(emailField); y += 40;
        deptField = new JTextField(); deptField.setBounds(120, y, 200, 25); add(new JLabel("Department:")).setBounds(20, y, 80, 25); add(deptField); y += 40;
        salaryField = new JTextField(); salaryField.setBounds(120, y, 200, 25); add(new JLabel("Salary:")).setBounds(20, y, 80, 25); add(salaryField); y += 40;
        phoneField = new JTextField(); phoneField.setBounds(120, y, 200, 25); add(new JLabel("Phone:")).setBounds(20, y, 80, 25); add(phoneField); y += 40;
        dobField = new JTextField(); dobField.setBounds(120, y, 200, 25); add(new JLabel("DOB (YYYY-MM-DD):")).setBounds(20, y, 100, 25); add(dobField); y += 40;
        hireDateField = new JTextField(); hireDateField.setBounds(120, y, 200, 25); add(new JLabel("Hire Date:")).setBounds(20, y, 80, 25); add(hireDateField); y += 40;
        addressArea = new JTextArea(); addressArea.setBounds(120, y, 200, 50); add(new JLabel("Address:")).setBounds(20, y, 80, 25); add(addressArea); y += 70;
        positionField = new JTextField(); positionField.setBounds(120, y, 200, 25); add(new JLabel("Position:")).setBounds(20, y, 80, 25); add(positionField); y += 40;
        managerIdField = new JTextField(); managerIdField.setBounds(120, y, 200, 25); add(new JLabel("Manager ID:")).setBounds(20, y, 80, 25); add(managerIdField); y += 40;
        genderBox = new JComboBox<>(new String[]{"Male", "Female", "Other"}); genderBox.setBounds(120, y, 200, 25); add(new JLabel("Gender:")).setBounds(20, y, 80, 25); add(genderBox); y += 40;
        emergencyField = new JTextField(); emergencyField.setBounds(120, y, 200, 25); add(new JLabel("Emergency Contact:")).setBounds(20, y, 120, 25); add(emergencyField); y += 40;

        saveButton = new JButton("Save");
        saveButton.setBounds(120, y, 100, 25);
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String name = nameField.getText();
                    String email = emailField.getText();
                    String dept = deptField.getText();
                    double salary = Double.parseDouble(salaryField.getText());
                    String phone = phoneField.getText();
                    Date dob = Date.valueOf(dobField.getText());
                    Date hireDate = Date.valueOf(hireDateField.getText());
                    String address = addressArea.getText();
                    String position = positionField.getText();
                    int managerId = Integer.parseInt(managerIdField.getText());
                    String gender = (String) genderBox.getSelectedItem();
                    String emergency = emergencyField.getText();

                    empService.addEmployee(new Employee(0, name, email, dept, salary, phone, dob, hireDate, address, position, managerId, gender, emergency));
                    JOptionPane.showMessageDialog(null, "Employee added!");
                    dispose();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
                }
            }
        });
        add(saveButton);
    }
}