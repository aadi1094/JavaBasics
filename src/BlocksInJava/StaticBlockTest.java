package BlocksInJava;

public class StaticBlockTest
{
    // Declare two instance blocks.
    {
        System.out.println("Instance block-1 executed.");
    }
    {
        System.out.println("Instance block-2 executed.");
    }

    // Declare two static blocks.
    static {
        System.out.println("Static block-1 executed.");
    }
    static {
        System.out.println("Static block-2 executed.");
    }

    // Declare non-parameterized constructor.
    StaticBlockTest()
    {
        System.out.println("0-arg constructor executed.");
    }
    // Declare one parameter constructor with a parameter a of type int.
    StaticBlockTest(int a)
    {
        System.out.println("1-arg constructor executed.");
    }

    public static void main(String[] args)
    {
// Create an object of class.
        new StaticBlockTest(); // Nameless object.

// Create another object of class and pass an integer argument value.
        new StaticBlockTest(20); // Nameless object.
    }
}

//Static block-1 executed.
//Static block-2 executed.
//Instance block-1 executed.
//Instance block-2 executed.
//0-arg constructor executed.
//Instance block-1 executed.
//Instance block-2 executed.
//1-arg constructor executed.

// As you see , static block executes only once , but instance block when new object get created