package OOPS.Inheritance.MultiLevelInheritance.PersonEmployeeSoftwareEngineer;

public class Main {
    public static void main(String[] args) {
        SoftwareEngineer obj=new SoftwareEngineer();
        obj.displayerson();
        obj.displayEmployee();
        obj.displaySDE();
        System.out.println("Annual Salry : "+obj.salary*12);
    }
}

class Person{
    int age = 21;
    String name= "Adityaa";

    void displayerson(){
        System.out.println("Name is "+name + "\nAge is "+age);
    }
}

class Employee extends Person{
    int id =123456;
    double salary=100000;

    void displayEmployee(){
        System.out.println("Employee id : "+id);
        System.out.println("Employee Salary is "+salary);
    }
}

class SoftwareEngineer extends Employee{
    int exp=7;
    String prog="Java";

    void displaySDE(){
        System.out.println("Experience is : "+exp +"years");
        System.out.println("Programming lang is "+prog);
    }
}

