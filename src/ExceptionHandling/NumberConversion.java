package ExceptionHandling;

import java.util.Scanner;

public class NumberConversion {
    static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        String x= sc.nextLine();

        try{
            int result=Integer.parseInt(x);
            System.out.println("Integer is "+result);
        }catch(NumberFormatException e){
            System.out.println(e.getMessage());
        }
    }
}
