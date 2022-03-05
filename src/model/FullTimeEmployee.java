package model;

public class FullTimeEmployee extends Employee{
    private double bonus;
    private double fineMoney;
    private double basicSalary;

    public FullTimeEmployee() {
    }

    public FullTimeEmployee(String employeeId, String employeeFullName, int employeeAge, String employeePhone, String employeeEmail, double bonus, double fineMoney, double basicSalary) {
        super(employeeId, employeeFullName, employeeAge, employeePhone, employeeEmail);
        this.bonus = bonus;
        this.fineMoney = fineMoney;
        this.basicSalary = basicSalary;
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    public double getFineMoney() {
        return fineMoney;
    }

    public void setFineMoney(double fineMoney) {
        this.fineMoney = fineMoney;
    }

    public double getBasicSalary() {
        return basicSalary;
    }

    public void setBasicSalary(double basicSalary) {
        this.basicSalary = basicSalary;
    }

    @Override
    public double getNetSalary() {
        double result = basicSalary + (bonus - fineMoney);
        return result;
    }

    @Override
    public String toString() {
        return "FullTimeEmployee{" +
                "employeeId='" + getEmployeeId() + '\'' +
                ", employeeFullName='" + getEmployeeFullName() + '\'' +
                ", employeeAge=" + getEmployeeAge() +
                ", employeePhone='" + getEmployeePhone() + '\'' +
                ", employeeEmail='" + getEmployeeEmail() + '\'' +
                ", bonus=" + bonus +
                ", fineMoney=" + fineMoney +
                ", basicSalary=" + basicSalary +
                '}';
    }
}
