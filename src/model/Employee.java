package model;

import java.io.Serializable;

public abstract class Employee implements Serializable {
    private String employeeId;
    private String employeeFullName;
    private int employeeAge;
    private String employeePhone;
    private String employeeEmail;

    public Employee() {
    }

    public Employee(String employeeId, String employeeFullName, int employeeAge, String employeePhone, String employeeEmail) {
        this.employeeId = employeeId;
        this.employeeFullName = employeeFullName;
        this.employeeAge = employeeAge;
        this.employeePhone = employeePhone;
        this.employeeEmail = employeeEmail;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeFullName() {
        return employeeFullName;
    }

    public void setEmployeeFullName(String employeeFullName) {
        this.employeeFullName = employeeFullName;
    }

    public int getEmployeeAge() {
        return employeeAge;
    }

    public void setEmployeeAge(int employeeAge) {
        this.employeeAge = employeeAge;
    }

    public String getEmployeePhone() {
        return employeePhone;
    }

    public void setEmployeePhone(String employeePhone) {
        this.employeePhone = employeePhone;
    }

    public String getEmployeeEmail() {
        return employeeEmail;
    }

    public void setEmployeeEmail(String employeeEmail) {
        this.employeeEmail = employeeEmail;
    }

    public abstract double getNetSalary();

    @Override
    public String toString() {
        return "Employee{" +
                "employeeId='" + employeeId + '\'' +
                ", employeeFullName='" + employeeFullName + '\'' +
                ", employeeAge=" + employeeAge +
                ", employeePhone='" + employeePhone + '\'' +
                ", employeeEmail='" + employeeEmail + '\'' +
                '}';
    }
}
