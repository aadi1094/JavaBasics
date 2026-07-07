package OOPS.Inheritance.HierarchicalInheritance.EmployeeSystem;

public class Tester extends Employee {
    int bugsFound=102;

    int bugSolve=180;

    double calculateBug(){
        return bugsFound*bugSolve;
    }

    void displayTester(){
        System.out.println("Bugs Found : "+bugsFound);
        System.out.println("Bugs Solve : "+bugSolve);
    }
}
