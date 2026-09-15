package OOPS.Encapsulation;

/*
 =========================================================================
 ENCAPSULATION -- BEFORE AND AFTER, SIDE BY SIDE
 =========================================================================

 Two classes that store exactly the same data. One defends itself, one
 does not. Run this file and compare the output.

 Read Notes PART 1 and PART 6 alongside this.
 =========================================================================
*/

public class EncapsulationDemo {

    public static void main(String[] args) {

        System.out.println("---------- BEFORE : no encapsulation ----------");

        OpenStudent open = new OpenStudent();
        open.name = "Aditya";          // reaching straight into the field
        open.age = 21;
        open.show();

        open.age = -5;                 // nothing stops this. No error at all.
        open.show();                   // the object is now nonsense


        System.out.println("---------- AFTER : encapsulated ----------");

        SafeStudent safe = new SafeStudent();
        safe.setName("Aditya");        // going through the door
        safe.setAge(21);
        safe.show();

        safe.setAge(-5);               // the guard rejects it
        safe.show();                   // object is unchanged -- it defended itself

        // UNCOMMENT THE LINE BELOW AND TRY TO COMPILE.
        // This is the whole point of the topic: the bad assignment is not
        // "discouraged", it is IMPOSSIBLE.
        //
        // safe.age = -5;      // error: age has private access in SafeStudent
    }
}


/* ------------------------------------------------------------------
   BEFORE -- fields have DEFAULT (package-private) access.
   Any class in this package can read or write them directly.
   This is how almost every class in your repo is written today.
   ------------------------------------------------------------------ */
class OpenStudent {

    String name;
    int age;

    void show() {
        System.out.println("OpenStudent -> " + name + ", age " + age);
    }
}


/* ------------------------------------------------------------------
   AFTER -- fields are private. The only way in is through methods,
   and those methods enforce the rule "age is between 1 and 120".
   That sentence is this class's INVARIANT. See Notes PART 6.
   ------------------------------------------------------------------ */
class SafeStudent {

    private String name;
    private int age;

    public String getName() {
        return name;                        // returns, does not print
    }

    public void setName(String name) {
        if (name == null || name.isEmpty()) {
            System.out.println("Name cannot be empty");
            return;
        }
        this.name = name;                   // this.name, NOT name = name
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age <= 0 || age > 120) {
            System.out.println("Invalid age: " + age);
            return;                         // reject, leave the field alone
        }
        this.age = age;
    }

    void show() {
        System.out.println("SafeStudent -> " + name + ", age " + age);
    }
}
