package Constructor.DefaultConstructor;

public class Main {

    String name;
    int age ;

    // Here, we are not creating any constructor.
    // So, Java Compiler will automatically insert a default constructor.
    // Create a user-defined method to print the default values.
    void display(){
        System.out.println("My name is "+name+" and my age is "+age);
    }

    public static void main(String[] args) {
        Main m = new Main();
        m.display();
    }
}

//My name is null and my age is 0

//In this example:
//We have not created any constructor in the class Person. So, the compiler adds a default constructor inside class.
//null, 0, null is the default values of the instance variables provided by the default constructor.