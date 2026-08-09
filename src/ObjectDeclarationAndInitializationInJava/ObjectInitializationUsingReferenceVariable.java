package ObjectDeclarationAndInitializationInJava;

public class ObjectInitializationUsingReferenceVariable {

    //This is the simplest and most commonly used method to initialize the states of an object.
    //  In this method, we assign values to the instance variables using object reference variable.

    String name;
    int id;

    public static void main(String[] args) {
        ObjectInitializationUsingReferenceVariable obj = new ObjectInitializationUsingReferenceVariable();
        obj.name = "Aditya";
        obj.id=69;

        System.out.println("Name is "+obj.name);
        System.out.println("Id is "+obj.id);
    }
}
