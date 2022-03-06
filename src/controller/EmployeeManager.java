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
    public static double checkDouble() {
        Scanner checkDouble = new Scanner(System.in);
        double number;
        while (true) {
            try {
                number = Double.parseDouble(checkDouble.nextLine());
                if (number > 0) {
                    break;
                } else {
                    System.err.println("Do not input negative number!");
                }

            } catch (Exception e) {
                System.err.println("Please in put the number!");
            }
        }
        return number;
    }

    public static String checkStringNotNull() {
        Scanner checkString = new Scanner(System.in);
        String str;
        while (true) {
            str = checkString.nextLine();
            if(!str.trim().equals("")) {
                break;
            } else {
                System.err.println("String is empty!");
            }
        }
        return str;
    }
}
