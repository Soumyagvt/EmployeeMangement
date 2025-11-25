package com.ems.service;

import com.employee.EmployeeDAO;
import com.employee.Employee;
import java.util.List;

public class EmployeeService {
    private EmployeeDAO dao = new EmployeeDAO();

    public void addEmployee(Employee emp) throws Exception {
        if (emp.getName().isEmpty() || emp.getEmail().isEmpty()) throw new Exception("Name and email required");
        if (emp.getPhone() != null && emp.getPhone().length() != 10) throw new Exception("Phone must be 10 digits");
        dao.addEmployee(emp);
    }

    public List<Employee> getAllEmployees() { return dao.getAllEmployees(); }
    public void updateEmployee(int id, Employee emp) throws Exception {
        if (emp.getName().isEmpty()) throw new Exception("Name required");
        dao.updateEmployee(id, emp);
    }
    public void deleteEmployee(int id) { dao.deleteEmployee(id); }
}