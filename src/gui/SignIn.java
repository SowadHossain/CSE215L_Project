package gui;

import Exceptions.EmployeeAlreadyExistsException;
import dbMangers.LoadDataSaveData;
import entity.Employee;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class SignIn {

        public static void signIn() throws EmployeeAlreadyExistsException {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter employee name:");
            String name = scanner.nextLine();
            System.out.print("Enter employee ID:");
            int employeeID = Integer.parseInt(scanner.nextLine());
            System.out.print("Enter employee position:");
            String position = scanner.nextLine();
            System.out.print("Enter employee password:");
            String password = scanner.nextLine();
            Employee newEmployee = new Employee(name, employeeID, position, password);
            ArrayList<Employee>employees = LoadDataSaveData.getEmployeeData();
            for (Employee employee : employees) {
                if (employee.getEmployeeID() == newEmployee.getEmployeeID()) {
                    throw new EmployeeAlreadyExistsException("Employee with ID " + newEmployee.getEmployeeID() + " already exists.");
                }
            }
            employees.add(newEmployee);
            try {
                LoadDataSaveData.saveEmployeeData();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Employee added successfully.");
        }
    }

