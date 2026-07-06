package OOPS.Inheritance.SingleInheritance.SmartPhoneMobile;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        SmartPhone sp=new SmartPhone();
        sp.turnOn();
        sp.message();
        sp.makeCall();
        sp.turnOff();

        System.out.println("SmartPhone information is : ");
        sp.androidVersion();
        sp.storage();
        sp.ram();
    }
}
