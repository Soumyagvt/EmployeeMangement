package com.employee;

import java.util.List;
import java.util.Scanner;

public class EmployeeManagementApp {
    public static void main(String[] args) {
        EmployeeDAO dao = new EmployeeDAO();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nEmployee Management System");
            System.out.println("1. Add Employee");
            System.out.println("2. View All Employees");
            System.out.println("3. Update Employee");
            System.out.println("4. Delete Employee");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Email: ");
                    String email = scanner.nextLine();
                    System.out.print("Department: ");
                    String dept = scanner.nextLine();
                    System.out.print("Salary: ");
                    double salary = scanner.nextDouble();
                    dao.addEmployee(new Employee(name, email, dept, salary));
                    break;
                case 2:
                    List<Employee> employees = dao.getAllEmployees();
                    for (Employee emp : employees) {
                        System.out.println(emp);
                    }
                    break;
                case 3:
                    System.out.print("Enter Employee ID to update: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("New Name: ");
                    name = scanner.nextLine();
                    System.out.print("New Email: ");
                    email = scanner.nextLine();
                    System.out.print("New Department: ");
                    dept = scanner.nextLine();
                    System.out.print("New Salary: ");
                    salary = scanner.nextDouble();
                    dao.updateEmployee(id, new Employee(name, email, dept, salary));
                    break;
                case 4:
                    System.out.print("Enter Employee ID to delete: ");
                    id = scanner.nextInt();
                    dao.deleteEmployee(id);
                    break;
                case 5:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}