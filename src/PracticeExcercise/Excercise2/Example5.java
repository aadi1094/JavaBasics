package PracticeExcercise.Excercise2;

import java.util.Scanner;

//Write program to print if a given number is positive or negative.
public class Example5 {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int x=sc.nextInt();

        if (x>=0){
            System.out.println("Positibe");
        }else{
            System.out.println("Negative");
        }
    }
}
