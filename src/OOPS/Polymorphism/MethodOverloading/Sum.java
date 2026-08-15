package OOPS.Polymorphism.MethodOverloading;

public class Sum {
    void sum(int a , int b ){
        System.out.println("The sum : " +(a+b));
    }

    void sum(int a , double b){
        System.out.println("The sum : " +(a+b));
    }

    void sum(int a , int b , int c){
        System.out.println("The sum : " +(a+b+c));
    }

    void sum(double a , int b){
        System.out.println("The sum : " +(a+b));
    }

    public static void main(String[] args) {
        Sum s = new Sum();
        s.sum(2,4);
        s.sum(2.4,1);
        s.sum(1,2,3);
        s.sum(7,3.5);
    }
}
