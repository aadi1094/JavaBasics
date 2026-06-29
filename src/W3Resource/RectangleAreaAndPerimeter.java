package W3Resource;

import java.util.Scanner;

public interface RectangleAreaAndPerimeter {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double len=input.nextDouble();
        double bre= input.nextDouble();

        System.out.println("Area of rect: " +len*bre);
        System.out.println("Perimeter of rect: "+ (2*len+2*bre));
    }
}
