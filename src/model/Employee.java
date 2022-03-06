package model;

import java.io.Serializable;

public abstract class Employee implements Serializable {
    private String id;
    private String fullName;
    private int age;
    private String phone;
    private String email;

    public Employee() {
    }

    public Employee(String id, String fullName, int age, String phone, String email) {
        this.id = id;
        this.fullName = fullName;
        this.age = age;
        this.phone = phone;
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public abstract double getNetSalary();

    @Override
    public String toString() {
        return "Employee{" +
                "employeeId='" + id + '\'' +
                ", employeeFullName='" + fullName + '\'' +
                ", employeeAge=" + age +
                ", employeePhone='" + phone + '\'' +
                ", employeeEmail='" + email + '\'' +
                '}';
    }
}
