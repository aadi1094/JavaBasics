package PracticeExcercise.Excercise2;

import java.util.Scanner;
//Write program to print given numbers are equal or not.
public class Example6 {
    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();

        if (x == 10) {
            System.out.println("Equal");
        } else {
            System.out.println("Not equal");
        }
    }
}