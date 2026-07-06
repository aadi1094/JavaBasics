package OOPS.Inheritance.MultiLevelInheritance.ECommerceOrderSystem;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Laptop obj=new Laptop();
        Scanner input=new Scanner(System.in);
        System.out.print("Enter laptop Name : ");
        obj.laptopName=input.next();
        System.out.print("Enter Price : ");
        obj.price= input.nextDouble();
        System.out.print("Enter Qunatity : ");
        obj.quantity=input.nextInt();

        System.out.println("Enter discount perecnatge: ");
        obj.discountPercenatge= input.nextFloat();

        obj.generateBill();

        System.out.println("Total price : "+obj.calculateTotalPrice(obj.price, obj.quantity));

        System.out.println("Discounted price : "+obj.calculatePercantage(obj.discountPercenatge));


    }
}

class Product{

    double calculateTotalPrice(double p,int q){
        double result=p*q;
        return result;
    }

    String laptopName;
    double price;
    int quantity;

}

class ElectronicProduct extends Product{
    float discountPercenatge;
    double calculatePercantage(float f){
        double result= calculateTotalPrice(price,quantity)-((f)/100.0*calculateTotalPrice(price,quantity));
        return result;
    }

}

class Laptop extends ElectronicProduct{
    String Processor ="AMD";
    String Storage="512 Gb";

    void generateBill(){
        System.out.println("\n----- BILL -----");
        System.out.println("Laptop Name : " + laptopName);
        System.out.println("Processor   : " + Processor);
        System.out.println("Storage     : " + Storage);
        System.out.println("Price       : " + price);
        System.out.println("Quantity    : " + quantity);

    }
}