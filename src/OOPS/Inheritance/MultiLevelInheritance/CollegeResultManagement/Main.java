package OOPS.Inheritance.MultiLevelInheritance.CollegeResultManagement;


import OOPS.Inheritance.MultiLevelInheritance.UniversityDepartmentStudent.Department;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        Marks obj=new Marks();
        System.out.println("Enter the marks of 5 subjects according to subject ");
        System.out.println("Enter Maths Marks");
        obj.mathsMarks=input.nextInt();
        System.out.println("Enter Science Marks");
        obj.scienceMarks= input.nextInt();
        System.out.println("Enter history Marks");
        obj.historyMarks=input.nextInt();
        System.out.println("Enter english Marks");
        obj.EnglishMarks=input.nextInt();
        System.out.println("Enter Chemistry Marks");
        obj.ChemistryMarks=input.nextInt();

        System.out.println("----*Marksheet*----");
        obj.displayAll();


        int totalmarks=obj.calculateTotal(obj.mathsMarks, obj.ChemistryMarks, obj.EnglishMarks, obj.historyMarks,obj.scienceMarks);
        System.out.println("Total Marks obtained :"+totalmarks);
        double percentage=obj.calculatePercentage(totalmarks, obj.outOffMarks);
        System.out.println("Total Percentage is : "+obj.calculatePercentage(totalmarks, obj.outOffMarks));
        System.out.println("Grade is "+ obj.findGrade(percentage));
    }
}

class Marks extends Department{
    int mathsMarks;
    int scienceMarks;
    int historyMarks;
    int EnglishMarks;
    int ChemistryMarks;

    int outOffMarks=500;

    int calculateTotal(int x, int y , int z, int a, int b){
        return x+y+z+a+b;
    }

    double calculatePercentage(int totalMarks, int outOfMarks){
        return (totalMarks * 100.0) / outOfMarks;
    }

    String findGrade(double x){
        if (x > 90){
            return "A+";
        } else if (x > 80){
            return "A";
        } else if (x > 70){
            return "B+";
        } else if (x > 60){
            return "B";
        } else if (x > 50){
            return "C";
        } else{
            return "Fail";
        }
    }
}

