package com.employee;

import java.sql.Date;  // For date fields

public class Employee {
    private int id;
    private String name;
    private String email;
    private String department;
    private double salary;
    // New fields
    private String phone;
    private Date dob;
    private Date hireDate;
    private String address;
    private String position;
    private int managerId;
    private String gender;
    private String emergencyContact;

    // Constructors
    public Employee() {}
    public Employee(String name, String email, String department, double salary) {
        this.name = name;
        this.email = email;
        this.department = department;
        this.salary = salary;
    }
    public Employee(int id, String name, String email, String department, double salary, String phone, Date dob, Date hireDate, String address, String position, int managerId, String gender, String emergencyContact) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.department = department;
        this.salary = salary;
        this.phone = phone;
        this.dob = dob;
        this.hireDate = hireDate;
        this.address = address;
        this.position = position;
        this.managerId = managerId;
        this.gender = gender;
        this.emergencyContact = emergencyContact;
    }

    // Getters and Setters (original + new)
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getDepartment() { return department; }
    public void setDepartment(String department) { this.department = department; }
    public double getSalary() { return salary; }
    public void setSalary(double salary) { this.salary = salary; }
    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }
    public Date getDob() { return dob; }
    public void setDob(Date dob) { this.dob = dob; }
    public Date getHireDate() { return hireDate; }
    public void setHireDate(Date hireDate) { this.hireDate = hireDate; }
    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }
    public String getPosition() { return position; }
    public void setPosition(String position) { this.position = position; }
    public int getManagerId() { return managerId; }
    public void setManagerId(int managerId) { this.managerId = managerId; }
    public String getGender() { return gender; }
    public void setGender(String gender) { this.gender = gender; }
    public String getEmergencyContact() { return emergencyContact; }
    public void setEmergencyContact(String emergencyContact) { this.emergencyContact = emergencyContact; }

    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Email: " + email + ", Dept: " + department + ", Salary: " + salary +
               ", Phone: " + phone + ", DOB: " + dob + ", Hire Date: " + hireDate + ", Address: " + address +
               ", Position: " + position + ", Manager ID: " + managerId + ", Gender: " + gender + ", Emergency: " + emergencyContact;
    }
}