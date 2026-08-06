package ArraysPractice;

public class SwapNumbers {
    public static void main(String[] args) {
        int a=10;
        int b=20;
        System.out.println("Before swap a is "+a+ " b is "+b);
        //without temp variable
        a=a^b;
        b=a^b;
        a=a^b;

        System.out.println("After swap a is "+a+ " b is "+b);

        //Using temp variable
//        int temp=a;
//        a=b;
//        b=temp;
//
//        System.out.println("After swap a is "+a+ " b is "+b);


    }
}
