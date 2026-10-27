package ExceptionHandling;

public class DivisionCalculator {
    public static void main(String[] args){
        int a=10;
        int b=0;

        try{
            double result=(a/b);
            System.out.println("Division is "+result);
        } catch (ArithmeticException e){
            System.out.println("Cannot divide by zero");
        }
    }
}
