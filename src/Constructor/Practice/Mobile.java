package Constructor.Practice;

public class Mobile {

    String brand;
    String model;
    int price;

    Mobile() {
        this("Iphone");
        System.out.println("This is default constructor");
    }

    Mobile(String brand) {
        this("Samsung", "S24");
        System.out.println("This constructor has 1 param");
    }

    Mobile(String brand, String model) {
        this("Redmi", "R-series", 25000);
        System.out.println("This constructor has 2 param");
    }

    Mobile(String brand, String model, int price) {
        this.brand = brand;
        this.model = model;
        this.price = price;

        System.out.println("This constructor has 3 params");
    }

    public static void main(String[] args) {

        Mobile m = new Mobile();

        System.out.println(m.brand);
        System.out.println(m.model);
        System.out.println(m.price);
    }
}