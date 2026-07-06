package OOPS.Inheritance.SingleInheritance.SavingsAccount;

import java.util.Scanner;

public class Account {
    int AccountNumber =1001;
    String AccountName = "Aditya";
    double balance=10000;

    double deposit( double x){
        double result= balance+x;
        return result;
    }

    double withdraw(double x){
        double result=balance-x;
        return result;
    }

    void displayAccount(){
        System.out.println("Account Number : "+AccountNumber);
        System.out.println("Account Name : "+AccountName);
        System.out.println("Current Balance : "+balance);
    }
}
