package Constructor.Practice;

public class Car {
    String brand;
    String model;
    double price;

    Car(){
        brand="Toyata";
        model="Fortuner";
        price=3500000;
    }

    void display(){
        System.out.println("Brand is "+brand);
        System.out.println("Model is "+model);
        System.out.println("Price is "+price);
    }

    public static void main(String[] args) {
        Car c = new Car();
        c.display();
    }
}


// Example of the default constructor
