package ExceptionHandling;

import java.util.Scanner;

public class MultipleCatchBlocks {
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String x = sc.nextLine();
        String y= sc.nextLine();

        try{
            int parsex=Integer.parseInt(x);
            int parsey=Integer.parseInt(y);
            double result = parsex/parsey;
            System.out.println("Result is "+result);
        }catch (ArithmeticException ae){
            System.out.println(ae.getMessage());
        }catch(NumberFormatException ne){
            System.out.println(ne.getMessage());
        }
    }
}