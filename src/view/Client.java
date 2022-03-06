package view;

import controller.EmployeeManager;
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
        Scanner idPT = new Scanner(System.in);
        System.out.println("Input id:");
        String id = idPT.nextLine();

        Scanner namePT = new Scanner(System.in);
        System.out.println("Input name:");
        String name = namePT.nextLine();

        int age = EmployeeManager.checkAge();

        Scanner phonePT = new Scanner(System.in);
        System.out.println("Input phone:");
        String phone = phonePT.nextLine();

        Scanner emailPT = new Scanner(System.in);
        System.out.println("Input email:");
        String email = emailPT.nextLine();

        System.out.println("Input work hour:");
        double workHour = EmployeeManager.checkDouble();


        PartTimeEmployee newPartTimeEmployee = new PartTimeEmployee(id, name, age, phone, email, workHour);
        return newPartTimeEmployee;
    }

    public static FullTimeEmployee createNewFullTimeEmployee() {
        Scanner idFT = new Scanner(System.in);
        System.out.println("Input id:");
        String id = idFT.nextLine();

        System.out.println("Input name:");
        String name = EmployeeManager.checkStringNotNull();

      int age = EmployeeManager.checkAge();

        Scanner phoneFT = new Scanner(System.in);
        System.out.println("Input phone:");
        String phone = phoneFT.nextLine();

        Scanner emailFT = new Scanner(System.in);
        System.out.println("Input email:");
        String email = emailFT.nextLine();

        System.out.println("Input bonus:");
        double bonus = EmployeeManager.checkDouble();

        System.out.println("Input fine money:");
        double fineMoney = EmployeeManager.checkDouble();

        System.out.println("Input basic salary:");
        double basicSalary = EmployeeManager.checkDouble();

        FullTimeEmployee fullTimeEmployee = new FullTimeEmployee(id, name, age, phone, email, bonus, fineMoney, basicSalary);
        return fullTimeEmployee;
    }

    public static void editEmployeeById() {
        Scanner inputIdFT = new Scanner(System.in);
        System.out.println("Input employee's id need edit: ");
        String id = inputIdFT.nextLine();
        int check = -1;
        if (EmployeeManager.getEmployeeById(id) == check) {
            System.err.println("Can't find the id!");
        } else {
            int index = EmployeeManager.getEmployeeById(id);
            if (employeesListClient.get(index) instanceof FullTimeEmployee) {
                System.out.println("Editing full time employee...");
                Scanner editIdFT = new Scanner(System.in);
                System.out.println("Edit id:" + "(" + employeesListClient.get(index).getEmployeeId() + ")");
                String editId = editIdFT.nextLine();

                Scanner editNameFT = new Scanner(System.in);
                System.out.println("Edit name:" + "(" + employeesListClient.get(index).getEmployeeFullName() + ")");
                String editName = editNameFT.nextLine();

                boolean valid = false;
                String strInput;
                int editAge = 0;
                Scanner editAgeFT = new Scanner(System.in);
                while (valid == false) {
                    System.out.println("Edit age:" + "(" + employeesListClient.get(index).getEmployeeAge() + ")");
                    strInput = editAgeFT.nextLine();
                    try {
                        editAge = Integer.parseInt(strInput);
                        valid = true;
                    } catch (NumberFormatException e) {
                        System.err.println("You need input the integer ");
                    }
                }

                Scanner editPhoneFT = new Scanner(System.in);
                System.out.println("Edit phone number:" + "(" + employeesListClient.get(index).getEmployeePhone() + ")");
                String editPhone = editPhoneFT.nextLine();

                Scanner editEmailFT = new Scanner(System.in);
                System.out.println("Edit email:" + "(" + employeesListClient.get(index).getEmployeeEmail() + ")");
                String editEmail = editEmailFT.nextLine();

                Scanner editBonusFT = new Scanner(System.in);
                System.out.println("Edit bonus:" + "(" + ((FullTimeEmployee) employeesListClient.get(index)).getBonus() + ")");
                double editBonus = editBonusFT.nextDouble();

                Scanner editFineMoneyFT = new Scanner(System.in);
                System.out.println("Edit fine money:" + "(" + ((FullTimeEmployee) employeesListClient.get(index)).getFineMoney() + ")");
                double editFineMoney = editFineMoneyFT.nextDouble();

                Scanner editBasicSalaryFT = new Scanner(System.in);
                System.out.println("Edit basic salary:" + "(" + ((FullTimeEmployee) employeesListClient.get(index)).getBasicSalary() + ")");
                double editBasicSalary = editBasicSalaryFT.nextDouble();

                FullTimeEmployee fullTimeEmployee = new FullTimeEmployee(editId, editName, editAge, editPhone, editEmail, editBonus, editFineMoney, editBasicSalary);
                EmployeeManager.editEmployeeByIndex(index, fullTimeEmployee);
            }
            if (employeesListClient.get(index) instanceof PartTimeEmployee) {
                System.out.println("Editing part time employee...");
                Scanner editIdPT = new Scanner(System.in);
                System.out.println("Edit id:" + "(" + employeesListClient.get(index).getEmployeeId() + ")");
                String editId = editIdPT.nextLine();

                Scanner editNamePT = new Scanner(System.in);
                System.out.println("Edit name:" + "(" + employeesListClient.get(index).getEmployeeFullName() + ")");
                String editName = editNamePT.nextLine();

                Scanner editAgePT = new Scanner(System.in);
                System.out.println("Edit age:" + "(" + employeesListClient.get(index).getEmployeeAge() + ")");
                int editAge = editAgePT.nextInt();

                Scanner editPhonePT = new Scanner(System.in);
                System.out.println("Edit phone number:" + "(" + employeesListClient.get(index).getEmployeePhone() + ")");
                String editPhone = editPhonePT.nextLine();

                Scanner editEmailPT = new Scanner(System.in);
                System.out.println("Edit email:" + "(" + employeesListClient.get(index).getEmployeeEmail() + ")");
                String editEmail = editEmailPT.nextLine();

                Scanner editWorkHourPT = new Scanner(System.in);
                System.out.println("Edit work hour:" + "(" + ((PartTimeEmployee) employeesListClient.get(index)).getWorkHour() + ")");
                double editWorkHour = editWorkHourPT.nextDouble();

                PartTimeEmployee partTimeEmployee = new PartTimeEmployee(editId, editName, editAge, editPhone, editEmail, editWorkHour);
                EmployeeManager.editEmployeeByIndex(index, partTimeEmployee);
            }
        }
    }
}
