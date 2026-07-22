//Write a program to call A main method from B class main method?

package PracticeExcercise.Excercise1;

public class Example4 {
    public static void main(String[] args) {
        System.out.println("This is B main method ");
        A.main(args);
    }
}

class A{
    public static void main(String[] args) {
        System.out.println("this is A main method");
    }
}
