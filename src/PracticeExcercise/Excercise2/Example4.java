package PracticeExcercise.Excercise2;

import java.util.Scanner;

//Write program to accept number and print if the number is even or odd.
public class Example4 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter number");
        int x= sc.nextInt();

        if (x%2==0){
            System.out.println("Even");
        }else{
            System.out.println("Odd");
        }
    }
}
