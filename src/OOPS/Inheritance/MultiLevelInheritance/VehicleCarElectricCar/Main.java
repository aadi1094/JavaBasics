package OOPS.Inheritance.MultiLevelInheritance.VehicleCarElectricCar;

public class Main {
    public static void main(String[] args) {
        ElectricCar car=new ElectricCar();
        System.out.println("Vehicle : "+car.vehicleName);
        System.out.println("Modal : "+car.model);

        car.start();
        car.drive();
        System.out.println("Battery : "+car.batterPercentage);
        car.ChargeBattery();
        car.batterStatus();

        System.out.println("mileage :"+car.mileage);

        car.stop();
    }
}

class Vehicle{
    String vehicleName="Tata";
    String model="NexonEv";

    void start(){
        System.out.println("Starting ..");
    }

    void stop(){
        System.out.println("Stopped ..");
    }
}

class Car extends Vehicle{
    int mileage=22;

    void drive(){
        System.out.println("Driving ...");
    }
}

class ElectricCar extends Car{
    int batterPercentage=90;

    void ChargeBattery(){
        System.out.println("Charging Battery...");
    }

    void batterStatus(){
        System.out.println("Battery : 100%");
    }
}
