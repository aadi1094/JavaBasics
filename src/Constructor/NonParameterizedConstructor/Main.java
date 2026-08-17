package Constructor.NonParameterizedConstructor;

public class Main {
    // Declaration of instance variables.
    String name;
    int age ;

    // Declare a non-parameterized constructor.
    Main(){
        // Initializing values to instance variables.
        name="Aditya";
        age=21;
    }

    void display(){
        System.out.println("My name is "+name+" and my age is "+age);
    }

    public static void main(String[] args) {
        Main m = new Main(); // Calling default constructor.
        m.display();

    }
}

//My name is Aditya and my age is 21