package W3Resource;

import java.util.Scanner;

public class PolygonArea {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Input the number of sides on the polygon : ");
        int n = input.nextInt();
        System.out.println("Input the length of one of the sides : ");
        int s=input.nextInt();

        System.out.println("The area of hexagon is " + (n*s*s)/(4*Math.tan(Math.toRadians(180/n))));

    }
}
