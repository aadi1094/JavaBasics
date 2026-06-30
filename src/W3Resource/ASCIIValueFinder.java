package W3Resource;

import java.util.Scanner;

public class ASCIIValueFinder {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter any character: ");
        char character = input.next().charAt(0);

        int asciiValue = character;

        System.out.println("ASCII value = " + asciiValue);
    }
}
