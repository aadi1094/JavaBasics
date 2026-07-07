package OOPS.Inheritance.HierarchicalInheritance.MovieTicketBooking;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        System.out.println("Enter which ticket you want to buy : Normal or premium");
        String x=input.next();
        System.out.println("Enter the number of quantity ");
        int y=input.nextInt();
        NormalTicket obj=new NormalTicket();
        Premium obj1=new Premium();

        System.out.println("bill is "+obj.calculateAmount(y));

        if(x.equalsIgnoreCase("Normal")){
            System.out.println("Your bill is : "+obj.totalNormalTicket(y));
        }else{
            System.out.println("Your bill is "+obj1.totalPremiumTicket(y));
        }

    }
}
