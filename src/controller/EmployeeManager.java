package controller;

import model.Employee;
import model.PartTimeEmployee;
import storage.EmployeeFromFileBinary;
import storage.IEployeeData;

import java.io.IOException;
import java.util.ArrayList;

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
            if (employee.getId().equals(employeeId)) {
                return i;
            }
        }
        return -1;
    }

    public static void editEmployeeByIndex(int index, Employee employee) {
        employeeList.set(index, employee);
        try {
            employeeData.writeFile(employeeList);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static double getSumSalary() {
        double sum = 0;
        for (int i = 0; i < employeeList.size(); i++) {
            sum += employeeList.get(i).getNetSalary();
        }
        return sum;
    }

    public static double getAverageSalary() {
        double avg = getSumSalary() / employeeList.size();
        return avg;
    }

    public static double getSalaryForPartTime() {
        int sum = 0;
        for (int i = 0; i < employeeList.size(); i++) {
            if (employeeList.get(i) instanceof PartTimeEmployee) {
                sum += employeeList.get(i).getNetSalary();
            }
        }
        return sum;
    }
}
