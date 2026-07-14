package HasADummy;

import ISAandHASA.Car;
import ISAandHASA.Engine;

public class CarDummy extends Car {
    public static void main(String[] args) {
        CarDummy cd = new CarDummy();
        cd.car();

        Engine e= new Engine();
        e.startEngine();

    }
}
