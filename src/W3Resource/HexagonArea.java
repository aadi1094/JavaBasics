package W3Resource;

import java.util.Scanner;



public class HexagonArea {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the side value");
        int s = input.nextInt();

        System.out.println("The area of hexagon is " + (6 * s * s) / (4 * Math.tan(Math.toRadians(180.0 / 6))));

    }

}
