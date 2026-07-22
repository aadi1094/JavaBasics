package PracticeExcercise.Excercise2;

import java.util.Scanner;

//Write program to check whether a year is leap or not?
public class Example7 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int year= sc.nextInt();

        if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)){
            System.out.println("Leap");
        }else{
            System.out.println("Not leap");
        }
    }
}
