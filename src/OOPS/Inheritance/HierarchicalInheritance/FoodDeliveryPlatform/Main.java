package OOPS.Inheritance.HierarchicalInheritance.FoodDeliveryPlatform;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Pizza p=new Pizza();
        System.out.println("Do you want to buy the Pizza : true or false");
        boolean result;
        result=sc.nextBoolean();
        if(result){
            System.out.println("Enter the pizza size (large,medium,small)");
            p.Size=sc.next();
            System.out.println("Do you want to add the extra cheese : true or false");
            p.extraCheese=sc.nextBoolean();
            System.out.println("Enter the quantity number : ");
            p.quantity=sc.nextInt();
            System.out.println("Your pizza bill is "+p.calculatePizzaPrice(p.Size, p.extraCheese)* p.quantity);

        }

        Burger b=new Burger();
        System.out.println("Do you want to buy the Burger : true or false");
        boolean res;
        res=sc.nextBoolean();
        if(res){
            System.out.println("Do you want to add double patty : true or false");
            b.doublepatty=sc.nextBoolean();
            System.out.println("Do you want to add extraMayo : true or false");
            b.extraMayo=sc.nextBoolean();
            System.out.println("Enter the quantity number : ");
            b.quantity=sc.nextInt();
            System.out.println("Your Burger bill is "+b.calculateBurgerBill(b.doublepatty,b.extraMayo)* b.quantity);
        }
        System.out.println("Resto name : "+p.restaurantName);
        System.out.println("Your Total bill is "+(p.calculatePizzaPrice(p.Size, p.extraCheese)* p.quantity+b.calculateBurgerBill(b.doublepatty,b.extraMayo)* b.quantity));

    }
}
