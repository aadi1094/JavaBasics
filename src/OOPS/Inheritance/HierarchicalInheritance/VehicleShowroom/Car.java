package OOPS.Inheritance.HierarchicalInheritance.VehicleShowroom;

public class Car extends Vehicle{

    int carRoadTax=10;
    double CarTax(){
        return roadTax+roadTax*(carRoadTax/100.0);
    }
}
