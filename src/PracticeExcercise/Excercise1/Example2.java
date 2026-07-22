// Ex#3: Write a program with same method in different class.

package PracticeExcercise.Excercise1;

public class Example2 {
    public static void main(String[] args) {
        Test t= new Test();
        t.display();

        Intro i = new Intro();
        i.display();
    }

}
 class Test{
    void display(){
        System.out.println("Myself test Addy ");
    }
}

class Intro{
    void display(){
        System.out.println("Myself Addy");
    }
}