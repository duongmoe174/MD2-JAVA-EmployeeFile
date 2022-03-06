package controller;

import model.Employee;
import storage.EmployeeFromFileBinary;
import storage.IEployeeData;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class EmployeeManager {
    public static IEployeeData employeeData = new EmployeeFromFileBinary();
    public static ArrayList<Employee> employeeList = employeeData.reafile();

    public static void addNewEmployee(Employee employee) {
        employeeList.add(employee);
        try {
            employeeData.writeFile(employeeList);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static int getEmployeeById(String employeeId) {
        for (int i = 0; i < employeeList.size(); i++) {
            Employee employee = employeeList.get(i);
            if (employee.getEmployeeId().equals(employeeId)) {
                return i;
            }
        }
        return -1;
    }

    public static void editEmployeeByIndex (int index, Employee employee) {
        employeeList.set(index, employee);
        try {
            employeeData.writeFile(employeeList);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static int checkAge() {
        Scanner checkAge = new Scanner(System.in);
        int age;
        while (true) {
            try {
                System.out.println("Input age:");
                age = Integer.parseInt(checkAge.nextLine());
                if (age >= 0 && age <= 100) {
                    break;
                } else {
                    System.err.println("0 <= age <= 100");
                }
            } catch (Exception e) {
                System.err.println("Age must is a Integer!");
            }
        }
        return age;
    }
}
