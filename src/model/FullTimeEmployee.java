package model;

public class FullTimeEmployee extends Employee{
    private double bonus;
    private double fineMoney;
    private double basicSalary;

    public FullTimeEmployee() {
    }

    public FullTimeEmployee(String id, String fullName, int age, String phone, String email, double bonus, double fineMoney, double basicSalary) {
        super(id, fullName, age, phone, email);
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
                "id='" + getId() + '\'' +
                ", fullName='" + getFullName() + '\'' +
                ", age=" + getAge() +
                ", phone='" + getPhone() + '\'' +
                ", email='" + getEmail() + '\'' +
                ", bonus=" + bonus +
                ", fineMoney=" + fineMoney +
                ", basicSalary=" + basicSalary +
                '}';
    }
}
