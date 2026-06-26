package Practice_Assignment_IfElse;

import java.util.Scanner;

public class Result {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the marks: ");
        int marks=input.nextInt();

        if (marks<35){
            System.out.println("You are Fail");
        } else if (marks >=35 && marks <60) {
            System.out.println("Passed with 2nd class");
        } else if (marks >=60 && marks <75) {
            System.out.println("Passed with 1st2 class");
        } else if (marks >=75 && marks <90){
            System.out.println("Passes with 1st class distinction");
        } else if (marks >=90 && marks <=100) {
            System.out.println("Merit class");
        }else {
            System.out.println("Marks should be in range 1-100");
        }
    }
}

//23-> Fail
//43->Passed with 2nd class
//75->Passes with 1st class distinction
//90->Merit class
//100-> Merit class
//101->Marks should be in range 1-100