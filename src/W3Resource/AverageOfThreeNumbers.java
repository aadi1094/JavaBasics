package W3Resource;

import java.util.Scanner;

public class AverageOfThreeNumbers {
    public static void main(String[] args) {
        Scanner input= new Scanner(System.in);
        int x=input.nextInt();
        int y= input.nextInt();
        int z=input.nextInt();

        double res=(x+y+z)/3;
        System.out.println(res);

    }
}
