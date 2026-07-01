package ConditionalStatements;

import java.util.Scanner;

public class SwitchCase {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the day number 1-9 : ");
        int x=input.nextInt();

        switch (x){
            case 1:
                System.out.println("Day 1: Orange");
                break;
            case 2:
                System.out.println("Day 2: White");
                break;
            case 3:
                System.out.println("Day 3: Red");
                break;
            case 4:
                System.out.println("Day 4: Royal blue");
                break;
            case 5:
                System.out.println("Day 5: Yellow");
                break;
            case 6:
                System.out.println("Day 6 : Green");
                break;
            case 7:
                System.out.println("Day 7: Grey");
                break;
            case 8:
                System.out.println("Day 8: Purple");
                break;
            case 9:
                System.out.println("Day 9: Peacock Green");
                break;
            default:
                System.out.println("Please provide the valid day between 1-9");
        }
    }
}
