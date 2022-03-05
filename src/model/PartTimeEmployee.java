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

    public PartTimeEmployee(String employeeId, String employeeFullName, int employeeAge, String employeePhone, String employeeEmail, double workHour) {
        super(employeeId, employeeFullName, employeeAge, employeePhone, employeeEmail);
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
                "employeeId='" + getEmployeeId() + '\'' +
                ", employeeFullName='" + getEmployeeFullName() + '\'' +
                ", employeeAge=" + getEmployeeAge() +
                ", employeePhone='" + getEmployeePhone() + '\'' +
                ", employeeEmail='" + getEmployeeEmail() + '\'' +
                ", workHour=" + workHour +
                '}';
    }
}
