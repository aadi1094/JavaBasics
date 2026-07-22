package PracticeExcercise.Excercise3;



//Write a sample demo program regarding accessible modifiers using private.
public class Example1 {
    private void m1(){
        System.out.println("Nothing");
    }

    public static void main(String[] args) {
        Example1 ex=new Example1();
        ex.m1();
    }
}
