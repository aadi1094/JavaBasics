package OOPS.Inheritance.HierarchicalInheritance.VehicleShowroom;

public class Truck extends Vehicle{
    double truckTax(){
        return roadTax+roadTax*(15/100.0);
    }
}
