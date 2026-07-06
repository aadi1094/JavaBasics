package OOPS.Inheritance.SingleInheritance.SavingsAccount;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        InterestRate i=new InterestRate();
        i.displayAccount();
        System.out.println("Yearly Interest rate : "+i.calculateYearlyInterest());

        System.out.println("If you want to deposit then Enter : Deposit and if you want to withdraw then Enter : Withdraw");

        Scanner input=new Scanner(System.in);
        String x =input.next();
        System.out.println("Enter the amount");
        double y=input.nextDouble();
        if (x.equalsIgnoreCase("Deposit")){
            System.out.println("final balance : "+i.deposit(y));
        }else{
            System.out.println("final balance : "+i.withdraw(y));
        }
    }
}
