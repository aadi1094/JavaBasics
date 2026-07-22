package PracticeExcercise.Excercise2;
//Write Program to read 2 numbers and print biggest number?(Using Scanner)rt java.util.Scanner;

import java.util.Scanner;

public class Example3 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter 1st number");
        int x= sc.nextInt();
        System.out.println("Enter 2nd number");
        int y= sc.nextInt();

        if(x>y){
            System.out.println("Greater : "+x);
        }else{
            System.out.println("Graeter :"+y);
        }
    }
}
