package OOPS.Inheritance.SingleInheritance.EmployeeDeveloper;

public class Main {
    public static void main(String[] args) {
        Developer dev= new Developer();
        System.out.println("Employee Name : "+dev.employeename);
        System.out.println("Salary is "+dev.salary);
        System.out.println("Bonus is "+dev.bonus);
        System.out.println("Total salary is "+dev.calculateSalary());
    }
}
