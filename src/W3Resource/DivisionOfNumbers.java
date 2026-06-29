package W3Resource;

import java.util.Scanner;

public class DivisionOfNumbers {
    public static void main(String[] args) {
        Scanner input= new Scanner(System.in);
        System.out.print("Enter the 1st number: ");
        int x = input.nextInt();
        System.out.print("Enter the 2nd number: ");
        int y = input.nextInt();

        int result= x/y;
        System.out.println("The addition is: "+result);

    }
}
