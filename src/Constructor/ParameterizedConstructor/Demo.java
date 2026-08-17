package Constructor.ParameterizedConstructor;

public class Demo
{
    // Declare non-parameterized constructor.
    Demo()
    {
        System.out.println("Zero argument constructor");
    }
    // Declare parameterized constructor with one argument.
    Demo(int a)
    {
        System.out.println("One argument constructor");
    }
    // Declare parameterized constructor with two arguments.
    Demo(int a, int b)
    {
        System.out.println("Two arguments constructor");
    }
    public static void main(String[] args)
    {
// Create an object of class.
        Demo d = new Demo(); // Calling Default constructor.
        d = new Demo(20); // Calling one argument constructor.
        d = new Demo(10,15); // Calling two arguments constructor.
    }
}

//Zero argument constructor
//One argument constructor
//Two arguments constructor