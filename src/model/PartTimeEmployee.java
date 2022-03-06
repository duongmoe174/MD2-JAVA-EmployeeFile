package model;

public class PartTimeEmployee extends Employee {
    public static final int MONEYPERHOUR = 100000;
    private double workHour;

    public PartTimeEmployee() {
    }

    @Override
    public double getNetSalary() {
        double result = workHour * MONEYPERHOUR;
        return result;
    }

    public PartTimeEmployee(String id, String fullName, int age, String phone, String email, double workHour) {
        super(id, fullName, age, phone, email);
        this.workHour = workHour;
    }

    public double getWorkHour() {
        return workHour;
    }

    public void setWorkHour(double workHour) {
        this.workHour = workHour;
    }

    @Override
    public String toString() {
        return "PartTimeEmployee{" +
                "employeeId='" + getId() + '\'' +
                ", employeeFullName='" + getFullName() + '\'' +
                ", employeeAge=" + getAge() +
                ", employeePhone='" + getPhone() + '\'' +
                ", employeeEmail='" + getEmail() + '\'' +
                ", workHour=" + workHour +
                '}';
    }
}
