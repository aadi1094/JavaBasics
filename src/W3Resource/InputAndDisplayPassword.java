package W3Resource;

import java.util.Scanner;

public class InputAndDisplayPassword {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter password");
        String x = input.next();

        System.out.println("Your pass is : "+x);
    }
}
