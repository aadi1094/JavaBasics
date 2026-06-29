package W3Resource;

import java.util.Scanner;

public class CircleAreaAndPerimeter {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        float r= input.nextFloat();
        double result= 2*3.14*r;
        System.out.println("Area of circle is : "+result);

        double res=3.14*r*r;
        System.out.println("Perimeter of circle is : "+res);

    }
}
