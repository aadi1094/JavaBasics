package OOPS.Inheritance.MultiLevelInheritance.ProductElectronicLaptop;

public class Main {
    public static void main(String[] args) {
        Laptop obj=new Laptop();
        obj.displayAll();
    }
}

class Product{
    String productName="Apple Mac";
    double price=123456;
}

class ElectronicProduct extends Product{
    String Warranty= "7 Years";

}

class Laptop extends ElectronicProduct{
    int ram=12;
    int rom=512;

    void displayAll(){
        System.out.println("Product name : "+productName);
        System.out.println("Product price : "+price);
        System.out.println("Warranty: "+Warranty);
        System.out.println("RAM : "+ram);
        System.out.println("ROM : "+rom);
    }
}