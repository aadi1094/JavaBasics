package OOPS.Inheritance.SingleInheritance.EmployeeDeveloper;

public class Developer extends Employee{
    double bonus=1000;

    double calculateSalary(){
        return salary+bonus;
    }
}
