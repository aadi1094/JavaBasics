package ExceptionHandling;

import java.util.Scanner;

public class MarksEntry {
    public static void main(String[] args){
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter the marks : ");
        String typed= sc.nextLine();

        try{
            int marks=Integer.parseInt(typed);
            System.out.println("Marks entered is "+marks);
        }catch (NumberFormatException e){
            System.out.println("Entered marks is not whole number");
            System.out.println("Details : "+e.getMessage());
        }

        System.out.println("Thank you");
    }
}

//Enter the marks :
//70
//Marks entered is 70
//Thank you

//Enter the marks :
//8O (instead of 0 i have gave input as Capital "O")
//Entered marks is not whole number
//Details : For input string: "8O"
//Thank you