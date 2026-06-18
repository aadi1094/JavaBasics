package Practice_Assignment_MethodCalling;

public class CalculatorMethods {
    int add(int x, int y){
        return x+y;
    }
    int substract(int x, int y){
        return x-y;
    }
    int multiply(int x, int y){
        return x*y;
    }
    float divide(float x, float y){
        return x/y;
    }

    public static void main(String[] args) {
        CalculatorMethods obj=new CalculatorMethods();
        int addtion=obj.add(2,5);
        System.out.println(addtion);
        int substarction=obj.substract(2,5);
        System.out.println(substarction);
        int multiplication=obj.multiply(2,5);
        System.out.println(multiplication);
        float divison=obj.divide(2,5);
        System.out.println(divison);
    }
}
