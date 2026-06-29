package W3Resource;

import java.util.Scanner;

public class SumofDigits {
    public static void main(String[] args) {
        Scanner input= new Scanner(System.in);
        System.out.print("Enter the number : ");
        int n = input.nextInt();
        int sum=0;
        int digit;

        while (n>0){
            digit=n%10;
            n=n/10;
            sum+=digit;

        }
        System.out.println("Sum of digits is : "+sum);

    }
}
