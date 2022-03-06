package view;

import controller.EmployeeManager;
import controller.Validate;
import model.Employee;
import model.FullTimeEmployee;
import model.PartTimeEmployee;

import java.util.ArrayList;
import java.util.Scanner;


public class Client {
    private static ArrayList<Employee> employeesListClient = EmployeeManager.employeeList;

    public static void main(String[] args) {
        Scanner inputChoiceMain = new Scanner(System.in);
        int choice = -1;
        while (choice != 0) {
            System.out.println("Menu");
            System.out.println("1. Add new employee");
            System.out.println("2. Show all employee");
            System.out.println("3. Edit Employee");
            System.out.println("4. Show full time employee have lower salary");
            System.out.println("0. Exit");
            choice = inputChoiceMain.nextInt();
            switch (choice) {
                case 1:
                    addNewEmployee();
                    break;
                case 2:
                    showAllEmployee();
                    break;
                case 3:
                    editEmployeeById();
                    break;
                case 4:
                    showLowerEmployeeFTSalary();
                    break;
                case 0:
                    System.exit(0);
                default:
                    System.out.println("Please let's choose one!");
            }
        }
    }

    public static void showAllEmployee() {
        for (Employee e : employeesListClient
        ) {
            System.out.println(e);
        }
    }

    public static void addNewEmployee() {
        int choice = -1;
        Scanner inputChoice = new Scanner(System.in);
        while (choice != 0) {
            System.out.println("Add new employee:");
            System.out.println("1. New part time");
            System.out.println("2. New full time ");
            System.out.println("0. Return to main menu ");
            choice = inputChoice.nextInt();
            switch (choice) {
                case 1:
                    PartTimeEmployee partTimeEmployee = createNewPartTimeEmployee();
                    EmployeeManager.addNewEmployee(partTimeEmployee);
                    break;
                case 2:
                    FullTimeEmployee fullTimeEmployee = createNewFullTimeEmployee();
                    EmployeeManager.addNewEmployee(fullTimeEmployee);
                    break;
                case 0:
                    return;
                default:
                    System.err.println("Please let's choose one!");
            }
        }
    }

    public static PartTimeEmployee createNewPartTimeEmployee() {
        Validate valid = new Validate();
        System.out.println("Input id:");
        String id = valid.checkStringNotNull();

        System.out.println("Input name:");
        String name = valid.checkStringNotNull();

        int age = valid.checkAge();

        System.out.println("Input phone:");
        String phone = valid.checkStringNotNull();

        System.out.println("Input email:");
        String email = valid.checkStringNotNull();

        System.out.println("Input work hour:");
        double workHour = valid.checkDouble();


        PartTimeEmployee newPartTimeEmployee = new PartTimeEmployee(id, name, age, phone, email, workHour);
        return newPartTimeEmployee;
    }

    public static FullTimeEmployee createNewFullTimeEmployee() {
        Validate valid = new Validate();
        System.out.println("Input id:");
        String id = valid.checkStringNotNull();

        System.out.println("Input name:");
        String name = valid.checkStringNotNull();

        int age = valid.checkAge();

        System.out.println("Input phone:");
        String phone = valid.checkStringNotNull();

        System.out.println("Input email:");
        String email = valid.checkStringNotNull();

        System.out.println("Input bonus:");
        double bonus = valid.checkDouble();

        System.out.println("Input fine money:");
        double fineMoney = valid.checkDouble();

        System.out.println("Input basic salary:");
        double basicSalary = valid.checkDouble();

        FullTimeEmployee fullTimeEmployee = new FullTimeEmployee(id, name, age, phone, email, bonus, fineMoney, basicSalary);
        return fullTimeEmployee;
    }

    public static void editEmployeeById() {
        Validate valid = new Validate();
        System.out.println("Input employee's id need edit: ");
        String id = valid.checkStringNotNull();
        int check = -1;
        if (EmployeeManager.getEmployeeById(id) == check) {
            System.err.println("Can't find the id!");
        } else {
            int index = EmployeeManager.getEmployeeById(id);
            if (employeesListClient.get(index) instanceof FullTimeEmployee) {
                System.out.println("Editing full time employee...");
                System.out.println("Edit id:" + "(" + employeesListClient.get(index).getId() + ")");
                String editId = valid.checkStringNotNull();

                System.out.println("Edit name:" + "(" + employeesListClient.get(index).getFullName() + ")");
                String editName = valid.checkStringNotNull();

                int editAge = valid.checkAge();

                System.out.println("Edit phone number:" + "(" + employeesListClient.get(index).getPhone() + ")");
                String editPhone = valid.checkStringNotNull();

                System.out.println("Edit email:" + "(" + employeesListClient.get(index).getEmail() + ")");
                String editEmail = valid.checkStringNotNull();

                System.out.println("Edit bonus:" + "(" + ((FullTimeEmployee) employeesListClient.get(index)).getBonus() + ")");
                double editBonus = valid.checkDouble();

                System.out.println("Edit fine money:" + "(" + ((FullTimeEmployee) employeesListClient.get(index)).getFineMoney() + ")");
                double editFineMoney = valid.checkDouble();

                System.out.println("Edit basic salary:" + "(" + ((FullTimeEmployee) employeesListClient.get(index)).getBasicSalary() + ")");
                double editBasicSalary = valid.checkDouble();

                FullTimeEmployee fullTimeEmployee = new FullTimeEmployee(editId, editName, editAge, editPhone, editEmail, editBonus, editFineMoney, editBasicSalary);
                EmployeeManager.editEmployeeByIndex(index, fullTimeEmployee);
            }
            if (employeesListClient.get(index) instanceof PartTimeEmployee) {
                System.out.println("Editing part time employee...");
                System.out.println("Edit id:" + "(" + employeesListClient.get(index).getId() + ")");
                String editId = valid.checkStringNotNull();

                System.out.println("Edit name:" + "(" + employeesListClient.get(index).getFullName() + ")");
                String editName = valid.checkStringNotNull();

                System.out.println("Edit age:" + "(" + employeesListClient.get(index).getAge() + ")");
                int editAge = valid.checkAge();

                System.out.println("Edit phone number:" + "(" + employeesListClient.get(index).getPhone() + ")");
                String editPhone = valid.checkStringNotNull();

                System.out.println("Edit email:" + "(" + employeesListClient.get(index).getEmail() + ")");
                String editEmail = valid.checkStringNotNull();

                System.out.println("Edit work hour:" + "(" + ((PartTimeEmployee) employeesListClient.get(index)).getWorkHour() + ")");
                double editWorkHour = valid.checkDouble();

                PartTimeEmployee partTimeEmployee = new PartTimeEmployee(editId, editName, editAge, editPhone, editEmail, editWorkHour);
                EmployeeManager.editEmployeeByIndex(index, partTimeEmployee);
            }
        }
    }

    public static void showLowerEmployeeFTSalary() {
        System.out.println("Full time employee have salary lower than average company's salary:");
        int serial = 1;
        for (int i = 0; i < employeesListClient.size(); i++) {
            if (employeesListClient.get(i) instanceof FullTimeEmployee) {
                if (employeesListClient.get(i).getNetSalary() < EmployeeManager.getAverageSalary()) {
                    System.out.println(serial + ". " + employeesListClient.get(i).getFullName());
                    serial ++;
                }
            }
        }
    }
}
