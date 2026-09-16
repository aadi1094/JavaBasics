package OOPS.Abstraction.Interfaces;

/*
 =========================================================================
 INTERFACE DEMO  --  WORKED EXAMPLE, NOTHING TO WRITE
 =========================================================================

 Run it, read the output, then read the code. Every part of
 Interfaces/Notes appears here:

     PART 1   constants, and the invisible public/abstract/static/final
     PART 2   implements, and why the method must be public
     PART 3   one class, several interfaces
     PART 5   default methods
     PART 6   static methods (and the fact that they are NOT inherited)
              private methods (Java 9+)
     PART 7   the diamond problem, and "class always wins"
     PART 9   functional interface -> anonymous class -> lambda

 =========================================================================
*/

public class InterfaceDemo {

    public static void main(String[] args) {

        System.out.println("=== 1. an interface reference holding a class object ===");
        Notifier n1 = new EmailNotifier();        // upcasting to an INTERFACE
        n1.send("Your order has shipped");
        n1.log();                                 // inherited default method
        // Notifier bad = new Notifier();
        //     ERROR: Notifier is abstract; cannot be instantiated
        System.out.println();

        System.out.println("=== 2. a default method, overridden ===");
        Notifier n2 = new SmsNotifier();
        n2.send("OTP is 4821");
        n2.log();                                 // SmsNotifier's own version
        System.out.println();

        System.out.println("=== 3. constants (public static final) ===");
        System.out.println("Retries: " + Notifier.MAX_RETRIES);
        System.out.println("Channel: " + Notifier.CHANNEL);
        // Notifier.MAX_RETRIES = 5;
        //     ERROR: cannot assign a value to final variable MAX_RETRIES
        //     Interface fields are constants, not fields. Notes PART 1.
        System.out.println();

        System.out.println("=== 4. a static method on an interface ===");
        System.out.println(Notifier.describe());
        // System.out.println(EmailNotifier.describe());
        //     ERROR: cannot find symbol
        //     Interface static methods are NOT inherited by implementing
        //     classes. Call them on the INTERFACE name only. Notes PART 6.
        System.out.println();

        System.out.println("=== 5. one class, two interfaces ===");
        PushNotifier push = new PushNotifier();
        push.send("You have 3 new messages");     // from Notifier
        push.track("msg-1001");                   // from Trackable

        // The same object, seen through two different contracts:
        Notifier  asNotifier  = push;
        Trackable asTrackable = push;

        asNotifier.send("seen as a Notifier");
        // asNotifier.track("x");
        //     ERROR: the REFERENCE type Notifier has no track(). The OBJECT
        //     does. Reference limits the view -- Notes PART 2 rule 5.
        asTrackable.track("seen as a Trackable");
        System.out.println();

        System.out.println("=== 6. grouping UNRELATED classes ===");
        // ServerLog does not implement Notifier and shares no ancestor
        // with PushNotifier -- yet both are Trackable. No abstract class
        // could have put these two in one array. Notes PART 3.
        Trackable[] tracked = { new PushNotifier(), new ServerLog() };
        for (Trackable t : tracked) {
            t.track("evt-99");
        }
        System.out.println();

        System.out.println("=== 7. the diamond problem ===");
        new DiamondByRewriting().hello();
        new DiamondByChoosing().hello();
        System.out.println();

        System.out.println("=== 8. class always wins ===");
        new ClassWins().hello();     // prints Parent, NOT Helper. Notes PART 7.
        System.out.println();

        System.out.println("=== 9. functional interface, three ways ===");

        // (a) a named class
        Calculator add = new AddCalculator();
        System.out.println("named class      : " + add.apply(2, 3));

        // (b) an anonymous class -- an object of a class with no name.
        //     This is NOT instantiating the interface; the compiler
        //     generates a hidden class that implements it. Notes PART 11 q13.
        Calculator multiply = new Calculator() {
            @Override
            public int apply(int a, int b) {
                return a * b;
            }
        };
        System.out.println("anonymous class  : " + multiply.apply(2, 3));

        // (c) a lambda -- the same thing, one line. Legal ONLY because
        //     Calculator has exactly one abstract method. Notes PART 9.
        Calculator subtract = (a, b) -> a - b;
        System.out.println("lambda           : " + subtract.apply(2, 3));

        // the default method is available to all three
        add.describeOperation();
        System.out.println();
        System.out.println("You will see (c) everywhere in Collections and");
        System.out.println("Streams. Every lambda in Java is an object of a");
        System.out.println("functional interface.");
    }
}


/* ------------------------------------------------------------------------
   AN INTERFACE WITH ALL FIVE KINDS OF MEMBER
   ------------------------------------------------------------------------ */
interface Notifier {

    int MAX_RETRIES = 3;                    // public static final, implicitly
    String CHANNEL = "default";             // must be initialised right here

    void send(String message);              // public abstract, implicitly

    default void log() {                    // Java 8 -- has a body
        stamp("sent via " + CHANNEL);       // calls the private helper below
    }

    static String describe() {              // Java 8 -- called on the INTERFACE
        return "Notifier: retries up to " + MAX_RETRIES + " times";
    }

    private void stamp(String text) {       // Java 9 -- shared by default
        System.out.println("  [log] " + text);   // methods, invisible outside
    }
}


interface Trackable {
    void track(String id);
}


/* ------------------------------------------------------------------------
   IMPLEMENTATIONS
   ------------------------------------------------------------------------ */
class EmailNotifier implements Notifier {

    @Override
    public void send(String message) {      // public is MANDATORY here.
        System.out.println("Email: " + message);   // Remove it and read the
    }                                       // error -- Notes PART 2 rule 2.
}


class SmsNotifier implements Notifier {

    @Override
    public void send(String message) {
        System.out.println("SMS: " + message);
    }

    @Override
    public void log() {                     // a default method MAY be
        System.out.println("  [log] SMS delivery receipt requested");
    }                                       // overridden. It does not have to be.
}


/* one class, TWO interfaces -- Notes PART 3 */
class PushNotifier implements Notifier, Trackable {

    @Override
    public void send(String message) {
        System.out.println("Push: " + message);
    }

    @Override
    public void track(String id) {
        System.out.println("Tracking push " + id);
    }
}


/* Trackable only. No relation to PushNotifier whatsoever. */
class ServerLog implements Trackable {

    @Override
    public void track(String id) {
        System.out.println("Tracking server event " + id);
    }
}


/* ------------------------------------------------------------------------
   THE DIAMOND PROBLEM -- Notes PART 7 case 2
   ------------------------------------------------------------------------ */
interface AlphaGreeter {
    default void hello() { System.out.println("Hello from Alpha"); }
}

interface BetaGreeter {
    default void hello() { System.out.println("Hello from Beta"); }
}

// class Broken implements AlphaGreeter, BetaGreeter { }
//     ERROR: class Broken inherits unrelated defaults for hello()
//            from types AlphaGreeter and BetaGreeter

/* FIX 1 -- write your own version and ignore both */
class DiamondByRewriting implements AlphaGreeter, BetaGreeter {
    @Override
    public void hello() {
        System.out.println("Hello from DiamondByRewriting (own version)");
    }
}

/* FIX 2 -- choose one explicitly with InterfaceName.super */
class DiamondByChoosing implements AlphaGreeter, BetaGreeter {
    @Override
    public void hello() {
        AlphaGreeter.super.hello();     // syntax that exists ONLY for this
        // super.hello();               // ERROR: super here means Object
    }
}


/* ------------------------------------------------------------------------
   CLASS ALWAYS WINS -- Notes PART 7 case 3
   ------------------------------------------------------------------------ */
class GreeterParent {
    public void hello() { System.out.println("Hello from the CLASS parent"); }
}

interface GreeterHelper {
    default void hello() { System.out.println("Hello from the INTERFACE"); }
}

class ClassWins extends GreeterParent implements GreeterHelper {
    // nothing written here. No compile error, no warning.
    // The superclass method beats the interface default. Silently.
}


/* ------------------------------------------------------------------------
   FUNCTIONAL INTERFACE -- Notes PART 9
   ------------------------------------------------------------------------ */
@FunctionalInterface
interface Calculator {

    int apply(int a, int b);                // EXACTLY ONE abstract method

    default void describeOperation() {      // defaults do not count...
        System.out.println("  (a Calculator takes two ints and returns one)");
    }

    static Calculator zero() {               // ...and neither do statics
        return (a, b) -> 0;
    }

    // int apply(int a, int b, int c);
    //     ERROR: Calculator is not a functional interface --
    //            multiple non-overriding abstract methods
    //     Remove @FunctionalInterface and this compiles again, but then
    //     the lambda in main() stops working. The annotation just tells
    //     you EARLY, at the interface, instead of later at every lambda.
}

class AddCalculator implements Calculator {
    @Override
    public int apply(int a, int b) {
        return a + b;
    }
}

/*
 =========================================================================
 EXPECTED OUTPUT

 === 1. an interface reference holding a class object ===
 Email: Your order has shipped
   [log] sent via default

 === 2. a default method, overridden ===
 SMS: OTP is 4821
   [log] SMS delivery receipt requested

 === 3. constants (public static final) ===
 Retries: 3
 Channel: default

 === 4. a static method on an interface ===
 Notifier: retries up to 3 times

 === 5. one class, two interfaces ===
 Push: You have 3 new messages
 Tracking push msg-1001
 Push: seen as a Notifier
 Tracking push seen as a Trackable

 === 6. grouping UNRELATED classes ===
 Tracking push evt-99
 Tracking server event evt-99

 === 7. the diamond problem ===
 Hello from DiamondByRewriting (own version)
 Hello from Alpha

 === 8. class always wins ===
 Hello from the CLASS parent

 === 9. functional interface, three ways ===
 named class      : 5
 anonymous class  : 6
 lambda           : -1
   (a Calculator takes two ints and returns one)

 You will see (c) everywhere in Collections and
 Streams. Every lambda in Java is an object of a
 functional interface.


 SEVEN THINGS TO TRY

   A) Remove  public  from EmailNotifier.send(). Read the error:
      "attempting to assign weaker access privileges; was public".
      That single error explains Notes PART 1 -- the invisible modifiers.

   B) Uncomment  Notifier.MAX_RETRIES = 5;  -- interface fields are
      constants. Then try adding  int retries;  with no value to the
      interface. It also fails, for the same reason.

   C) Uncomment  EmailNotifier.describe();  -- interface static methods
      are not inherited. Compare with AbstractClassDemo, where
      Account.getCount() WAS available through the class. This asymmetry
      is a favourite interview question.

   D) Uncomment  class Broken implements AlphaGreeter, BetaGreeter { }
      and read the diamond error in full. Then fix it both ways yourself.

   E) In ClassWins, add  implements GreeterHelper  but ALSO remove
      extends GreeterParent. Now the interface default runs. Put the
      extends back and it silently loses again.

   F) Uncomment the three-argument apply() in Calculator. Two things
      break: the @FunctionalInterface check, and every lambda.

   G) Add  void track(String id);  to Notifier. EmailNotifier and
      SmsNotifier stop compiling instantly. Now make it a DEFAULT method
      instead -- everything compiles again. You have just reproduced, by
      hand, the exact problem default methods were invented to solve.
      Notes PART 5.
 =========================================================================
*/
