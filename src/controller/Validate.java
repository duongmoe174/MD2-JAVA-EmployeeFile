package controller;

import java.util.Scanner;

public class Validate {
    public  int checkAge() {
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
    public  double checkDouble() {
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

    public String checkStringNotNull() {
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
