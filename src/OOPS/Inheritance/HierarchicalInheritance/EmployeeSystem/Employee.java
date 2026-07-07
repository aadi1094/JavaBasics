package OOPS.Inheritance.HierarchicalInheritance.EmployeeSystem;

public class Employee {
    int employeeId=123456;
    String employeeName="Aditya Chawale";
    double salary=100000;

    void displayEmployee(){
        System.out.println("Employee Name : "+employeeName);
        System.out.println("Employee Id : "+employeeId);
        System.out.println("Employee Salary : "+salary);
    }
}
