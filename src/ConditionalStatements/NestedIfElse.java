package ConditionalStatements;

import java.util.Scanner;

public class NestedIfElse {
    public static void main(String[] args) {
        Scanner input= new Scanner(System.in);
        System.out.println("Are you coming to trek : True or False");
        boolean trek = input.nextBoolean();



        if (trek){
            System.out.println("Enter whoose bike A or B");
            String bike = input.next();
            if (bike.equalsIgnoreCase("A")) {
                System.out.println("Enter who is drving bike A or B");
                String drive = input.next();
                if (drive.equalsIgnoreCase("A")) {
                    System.out.println("Petrol should be filled by B");
                } else {
                    System.out.println("Petrol 50-50");
                }
            }else {
                System.out.println("Enter who is drving bike A or B");
                String drive = input.next();
                if (drive.equalsIgnoreCase("A")){
                    System.out.println("Petrol 50-50");
                }else{
                    System.out.println("Petrol should be filled by A");
                }
            }
        }else{
            System.out.println("No treking due to heavy rain");
        }
    }
}
