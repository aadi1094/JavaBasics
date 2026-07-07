package OOPS.Inheritance.HierarchicalInheritance.EmployeeSystem;

public class Developer extends Employee {
    String prog="Java";
    int projComp=12;

    int bonus=2000;

    double calculateBonus(){
        return bonus*projComp;
    }

    void displayDeveloper(){
        System.out.println("Dev Programming language : "+prog);
        System.out.println("Project Completed"+projComp);
    }
}
