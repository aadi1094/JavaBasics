package ObjectDeclarationAndInitializationInJava;

public class InitializeObjectUsingConstructor {
    //Constructor is the best and most recommended way to initialize objects in modern Java.
    // A constructor in Java is a special member of a class that is used to initialize objects of class.
    // It is automatically called when an object of the class is created. The constructor initializes the instance variables of the object.
    //
    //A constructor does not have any return type, not even void.
    // If the return type is specified, the JVM considers it as a normal method, not a constructor.

    String name ;
    int rollno;
    double salary;

    InitializeObjectUsingConstructor(){
        name="Aditya";
        rollno=69;
        salary=50000;
    }

    void display(){
        System.out.println("Name is "+name);
        System.out.println("Salary is"+salary);
        System.out.println("roll no"+rollno);
    }

    public static void main(String[] args) {
        InitializeObjectUsingConstructor obj = new InitializeObjectUsingConstructor();
        obj.display();
    }
}
