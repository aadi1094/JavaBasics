package PracticeExcercise.Excercise2;

import java.util.Scanner;

public class Example8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int x = sc.nextInt();
        int y = sc.nextInt();
        int z = sc.nextInt();

        if (x >= y && x >= z) {
            System.out.println(x + " is greatest");
        }

        if (y >= x && y >= z) {
            System.out.println(y + " is greatest");
        }

        if (z >= x && z >= y) {
            System.out.println(z + " is greatest");
        }
    }
}