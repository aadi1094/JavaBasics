package W3Resource;

import java.util.Scanner;

public class MultiplicationTable {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the number: ");
        int x = input.nextInt();

        for(int i=1;i<11;i++){
            System.out.println(x + " * " + i + " = " + (x * i));
        }
    }
}
