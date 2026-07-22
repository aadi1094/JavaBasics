package PracticeExcercise.Excercise1;

public class Example3 {
    public static void main(String[] args) {
        System.out.println("This is 1st main class");
        System.out.println("Only public class main method is called after running the code , thats why we are calling Test class method in this method only as shown in code");
        test.main(args);
    }
}

class test{
    public static void main(String[] args) {
        System.out.println("this is 2nd main test class");

    }
}