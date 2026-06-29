package W3Resource;

import java.util.Scanner;

public class SwapVariables {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the value of x");
        int x=input.nextInt();
        System.out.println("Enter the value of y");
        int y = input.nextInt();
        System.out.println("Before swapping x is : "+x +" and y is : "+y);

        x=x^y;
        y=x^y;
        x=x^y;

        System.out.println("After swapping x is : "+x +" and y is : "+y);
    }
}
