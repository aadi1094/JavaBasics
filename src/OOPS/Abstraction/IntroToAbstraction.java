package OOPS.Abstraction;

/*
 =========================================================================
 INTRO TO ABSTRACTION  --  WORKED EXAMPLE, NOTHING TO WRITE
 =========================================================================

 Run this file, read the output, then read the code alongside it.
 This is the same role IntroToPolymorphism.java played for that topic.

 It shows the two tools side by side in one program:

     abstract class Vehicle      -- partial abstraction, has shared state
     interface     Serviceable   -- a pure CAN-DO contract

 and one class, ElectricCar, that uses BOTH at once.

 The two lines that DO NOT COMPILE are commented out and marked. Uncomment
 them one at a time, read the compiler error, then comment them back.
 Those errors ARE the topic -- they are the compiler enforcing a contract
 you wrote.
 =========================================================================
*/

public class IntroToAbstraction {

    public static void main(String[] args) {

        // ---------------------------------------------------------------
        // 1. You cannot instantiate an abstract class.
        // ---------------------------------------------------------------
        // Vehicle v = new Vehicle("Generic", 4);
        //     ERROR: Vehicle is abstract; cannot be instantiated
        //
        // Compare this with Polymorphism/ShapesExample.java, where
        //     new ShapesExample()
        // was allowed and produced a meaningless object. Abstract removes
        // that possibility at compile time.

        // ---------------------------------------------------------------
        // 2. Upcasting still works exactly as you learned it.
        //    A parent REFERENCE holding a child OBJECT.
        // ---------------------------------------------------------------
        Vehicle v1 = new PetrolCar("Swift", 4);
        Vehicle v2 = new ElectricCar("Nexon EV", 4);

        v1.describe();          // concrete method, inherited, not overridden
        v1.start();             // abstract method -> PetrolCar's version runs
        System.out.println();

        v2.describe();
        v2.start();             // same call, ElectricCar's version runs
        System.out.println();

        // ---------------------------------------------------------------
        // 3. The classic polymorphic loop. One reference type, three
        //    different behaviours, and the compiler guarantees every
        //    element HAS a start() -- because it is abstract in Vehicle.
        // ---------------------------------------------------------------
        System.out.println("--- all vehicles ---");
        Vehicle[] garage = { new PetrolCar("City", 4),
                             new ElectricCar("Nexon EV", 4),
                             new Bike("Splendor") };

        for (Vehicle v : garage) {
            v.start();
        }
        System.out.println();

        // ---------------------------------------------------------------
        // 4. An INTERFACE reference. Serviceable is not a Vehicle and is
        //    not in the Vehicle hierarchy at all -- it is a capability.
        // ---------------------------------------------------------------
        System.out.println("--- everything serviceable ---");
        Serviceable[] jobs = { new ElectricCar("Nexon EV", 4),
                               new Bike("Splendor"),
                               new Generator() };      // not a Vehicle!

        for (Serviceable s : jobs) {
            s.service();
        }
        System.out.println();

        // Note what just happened: Generator does not extend Vehicle. It
        // shares no ancestor with ElectricCar. Yet both fit in the same
        // array, because both signed the same contract. An abstract class
        // could never have grouped them -- that is the CAN-DO idea.

        // ---------------------------------------------------------------
        // 5. The reference type still limits what you can call.
        //    (Polymorphism/Notes, mistake number 4 -- unchanged here.)
        // ---------------------------------------------------------------
        Vehicle v3 = new ElectricCar("Nexon EV", 4);
        // v3.service();
        //     ERROR: cannot find symbol -- method service()
        //     The OBJECT has service(). The REFERENCE type Vehicle does not
        //     declare it, so the compiler refuses. Cast, or declare it as
        //     Serviceable in the first place:
        ((Serviceable) v3).service();

        // ---------------------------------------------------------------
        // 6. Interface constants and static methods.
        // ---------------------------------------------------------------
        System.out.println();
        System.out.println("Warranty: " + Serviceable.WARRANTY_MONTHS + " months");
        System.out.println(Serviceable.policy());
    }
}


/* ------------------------------------------------------------------------
   THE ABSTRACT CLASS -- partial abstraction, IS-A
   ------------------------------------------------------------------------
   Note what it has that an interface cannot have:
       instance fields, a constructor, a private method.
   And note it is NOT 100% abstract -- describe() has a body, and every
   subclass gets that code for free. That is the point of an abstract class.
*/
abstract class Vehicle {

    private final String model;         // instance field  -- interfaces cannot
    private final int wheels;           // private + final -- encapsulation

    Vehicle(String model, int wheels) { // a constructor in an abstract class.
        this.model = model;             // Legal. It runs when a SUBCLASS is
        this.wheels = wheels;           // created, via an implicit super(...).
    }

    public String getModel() {
        return model;
    }

    void describe() {                   // CONCRETE -- shared by every subclass
        System.out.println(model + " | " + wheels + " wheels | " + category());
    }

    private String category() {         // private helper. Interfaces could not
        return wheels > 2 ? "car" : "two-wheeler";   // do this before Java 9.
    }

    abstract void start();              // ABSTRACT -- no body, ends with ';'
                                        // Every concrete subclass MUST write it
}


/* ------------------------------------------------------------------------
   THE INTERFACE -- a pure contract, CAN-DO
   ------------------------------------------------------------------------ */
interface Serviceable {

    int WARRANTY_MONTHS = 24;           // implicitly public static final.
                                        // It is a CONSTANT, not a field.

    void service();                     // implicitly public abstract

    default void reminder() {           // Java 8+. A body, inside an interface.
        System.out.println("  reminder: service due every 6 months");
    }

    static String policy() {            // Java 8+. Called as Serviceable.policy()
        return "Free service within " + WARRANTY_MONTHS + " months.";
    }
}


/* ------------------------------------------------------------------------
   THE CONCRETE CLASSES
   ------------------------------------------------------------------------ */

class PetrolCar extends Vehicle {

    PetrolCar(String model, int wheels) {
        super(model, wheels);           // MANDATORY. Vehicle has no no-arg
    }                                   // constructor, so this cannot be omitted.

    @Override
    void start() {
        System.out.println(getModel() + " starts with the ignition key");
    }
}


/* extends ONE class AND implements an interface -- the normal shape of
   real Java code. Note the order: extends always comes before implements. */
class ElectricCar extends Vehicle implements Serviceable {

    ElectricCar(String model, int wheels) {
        super(model, wheels);
    }

    @Override
    void start() {
        System.out.println(getModel() + " starts silently with a button");
    }

    @Override
    public void service() {             // MUST be public. Interface methods are
        System.out.println("Servicing EV: " + getModel() + " (battery check)");
        reminder();                     // the inherited default method
    }
}


class Bike extends Vehicle implements Serviceable {

    Bike(String model) {
        super(model, 2);
    }

    @Override
    void start() {
        System.out.println(getModel() + " starts with a self-start button");
    }

    @Override
    public void service() {
        System.out.println("Servicing bike: " + getModel() + " (chain + oil)");
    }

    @Override
    public void reminder() {            // a default method CAN be overridden
        System.out.println("  reminder: service due every 3 months");
    }
}


/* Not a Vehicle at all. No shared ancestor with ElectricCar.
   This is the class that proves why interfaces exist. */
class Generator implements Serviceable {

    @Override
    public void service() {
        System.out.println("Servicing generator (filter + coolant)");
    }
}

/*
 =========================================================================
 EXPECTED OUTPUT

 Swift | 4 wheels | car
 Swift starts with the ignition key

 Nexon EV | 4 wheels | car
 Nexon EV starts silently with a button

 --- all vehicles ---
 City starts with the ignition key
 Nexon EV starts silently with a button
 Splendor starts with a self-start button

 --- everything serviceable ---
 Servicing EV: Nexon EV (battery check)
   reminder: service due every 6 months
 Servicing bike: Splendor (chain + oil)
 Servicing generator (filter + coolant)

 Servicing EV: Nexon EV (battery check)
   reminder: service due every 6 months

 Warranty: 24 months
 Free service within 24 months.


 FIVE THINGS TO TRY AFTER IT RUNS

   A) Uncomment  new Vehicle("Generic", 4)  and read the error. This is the
      single most important error in the topic.

   B) Delete  start()  from Bike. Read the error. Then make Bike itself
      abstract instead -- the error goes away. Work out why that is allowed.

   C) Delete the word  public  from ElectricCar.service(). Read the error.
      Interface methods are implicitly public, and an override may never
      REDUCE visibility. (Polymorphism/Notes overriding rules -- same rule.)

   D) Try  interface Serviceable { int WARRANTY_MONTHS; }  with no value.
      It fails: interface fields are static final, so they must be
      initialised right there.

   E) Add  void fly();  to Serviceable and compile. Three classes break at
      once. That is a contract being enforced -- and it is also the reason
      adding methods to a published interface is a big deal, which is
      exactly why default methods were invented in Java 8.
 =========================================================================
*/
