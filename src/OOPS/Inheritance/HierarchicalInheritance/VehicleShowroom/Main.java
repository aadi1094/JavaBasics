package OOPS.Inheritance.HierarchicalInheritance.VehicleShowroom;

public class Main {
    public static void main(String[] args) {
        Car car=new Car();
        System.out.println("Car roadtax is "+car.CarTax());

        Truck t=new Truck();
        System.out.println("Truck roadtax is "+t.truckTax());

        System.out.println("For other vehicles : "+t.roadTax);

    }
}
