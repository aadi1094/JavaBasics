package StaticKeyword;

public class StaticBlock {

    static int a = 10;
    static int b ;


    // will only run the static block when the 1st object is created i.e when the class is loaded for 1st time
    static {
        System.out.println("This is a static block");
       b=3*a;
    }

    public static void main(String[] args) {
        StaticBlock obj = new StaticBlock();
        System.out.println("The value of a is "+StaticBlock.a +"and b is"+StaticBlock.b);

        StaticBlock.b+=3;
        System.out.println("The value of a is "+StaticBlock.a +"and b is"+StaticBlock.b);


        StaticBlock obj1 = new StaticBlock();
        System.out.println("The value of a is "+StaticBlock.a +"and b is"+StaticBlock.b);


    }

}
