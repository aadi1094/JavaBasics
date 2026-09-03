package BlocksInJava;

public class InstanceBlockExample
{
    // Declare 0-arg constructor.
    InstanceBlockExample()
    {
        System.out.println("0-arg constructor");
    }
    // Declare 1-arg constructor with a parameter x of type int.
    InstanceBlockExample(int x)
    {
        System.out.println("1-arg constructor");
    }
    // Declare 2-arg constructor with parameters x and y of type int.
    InstanceBlockExample(int x, int y)
    {
        System.out.println("2-arg constructor");
    }
    // Declare an instance block.
    {
        System.out.println("IIB");
    }
    public static void main(String[] args)
    {
       InstanceBlockExample obj = new InstanceBlockExample();
       InstanceBlockExample obj1 = new InstanceBlockExample(10);
       InstanceBlockExample obj2 = new InstanceBlockExample(10,20);

    }
}

//IIB
//0-arg constructor
//IIB
//1-arg constructor
//IIB
//2-arg constructor