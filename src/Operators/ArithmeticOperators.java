package Operators;

public class ArithmeticOperators {
    int a = 10;
    int b=7;

    public static void main(String[] args) {


        int x = 10;
        int y = 3;

        System.out.println(x + y); // 13
        System.out.println(x - y); // 7
        System.out.println(x * y); // 30
        System.out.println(x / y); // 3
        System.out.println(x % y); // 1

        System.out.println("Post and pre increment");
        int z = 5;
        ++z;
        System.out.println(z); // 6
        --z;
        System.out.println(z); // 5

        System.out.println(z++);
        z--;
        System.out.println(z--);

        int c=201;
        System.out.println(++c);
        System.out.println(--c);
        System.out.println(c++);
        System.out.println(c);

        int num=5;
        num+=+5;
        System.out.println(num);

    }
}
