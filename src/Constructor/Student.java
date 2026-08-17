package Constructor;

public class Student
{
    // Declaration of Instance variables.
    String name;
    String schoolName;
    int std;
    String city;

    // We can initialize instance variables in two manners.
// First manner:
    public Student(String name, String schoolName, int std, String city)
    {
        // Here, the parameter's identifier is the same as that of the variables name.
        // It is permissible to do this in Java.
        // 'this' refers to the current object.
        // The '.'called attribute's identifier selects the variables name, schoolName, std, city from the current object.
        // The '=' is the argument's identifier.
        System.out.println("Constructor called...");
        this.name = name;
        this.schoolName = schoolName;
        this.std = std;
        this.city = city;
    }
    // Second manner.
//    public Student(String n, String scn, int s, String c)
//    {
//        // Here, the name of the parameters is different from the name of the variables that we set.
//        // Therefore, we don't need to refer to the current object with 'this'.
//        name = n;
//        schoolName = scn;
//        std = s;
//        city = c;
//    }
    // Create a method to print the output. You can also print the output inside the constructor.
    void display()
    {
        System.out.println(name+ " " +schoolName+ " " +std+ " " +city);
    }
    // main method.
    public static void main(String[] args)
    {
        // Create an object of the class and pass values to the constructor.
        Student s = new Student("Aditya", "Wale English", 10, "Latur");
         Student s1= new Student("Vedant","Wale English", 10, "Latur");

        // Call display method to print the output. If you don't call, display() method will not print output.
        s.display();
        s1.display();
    }
}