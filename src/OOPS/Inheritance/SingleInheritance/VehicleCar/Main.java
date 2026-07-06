package OOPS.Inheritance.SingleInheritance.VehicleCar;

public class Main {
    public static void main(String[] args) {
        Car car=new Car();
        System.out.println("Car brand : "+car.brand);
        System.out.println("Car fuel type is "+car.fuel);

        car.startEngine();
        car.drive();
        car.applyBrake();
        car.stopEngine();
    }
}

//Car brand : Tata
//Car fuel type is Petrol
//Engine Started ..
//Car is moving ..
//Brakes Applied ..
//Engine stopped ..
