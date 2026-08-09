package ObjectLifeCycle;
//The life cycle of an object in Java is the complete journey of an object from its creation, its use in the program, and its removal from memory by garbage collector when it is no longer needed.
// Every object in Java goes through several stages, such as class loading, object creation, initialization, usage, and garbage collection.

//Overview of Object Life Cycle in Java
//The life cycle of an object in Java consists of the following stages:
//Creation of .class file
//Class loading into memory
//Class initialization
//Object creation (Instantiation)
//Memory allocation
//Constructor execution
//Object usage
//Object becomes eligible for Garbage Collection
//Garbage Collection and destruction


class Student {
    static {
        System.out.println("Class Loaded");
    }
    Student() {
        System.out.println("Constructor executed");
    }
    void display() {
        System.out.println("Object is in use");
    }
    public static void main(String[] args) {
        // Creating an object of class.
        Student s = new Student();
        // Calling method.
        s.display();
        // Setting reference to null.
        s = null;
        // Requesting JVM to run Garbage Collector (GC).
        System.gc();

        System.out.println("Object eligible for GC");
    }
}