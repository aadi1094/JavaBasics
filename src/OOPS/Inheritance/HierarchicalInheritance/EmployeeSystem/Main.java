package OOPS.Inheritance.HierarchicalInheritance.EmployeeSystem;

public class Main {
    public static void main(String[] args) {
        Developer obj=new Developer();
        obj.displayEmployee();
        obj.displayDeveloper();
        System.out.println("Bonus salry is : "+obj.calculateBonus());

        Tester obj1=new Tester();
        obj1.displayTester();
        System.out.println("Bugs solve slary is : "+obj1.calculateBug());

    }
}
