package OOPS.Abstraction.AbstractClass;

/*
 =========================================================================
 ABSTRACT CLASS DEMO  --  WORKED EXAMPLE, NOTHING TO WRITE
 =========================================================================

 Run it, read the output, then read the code. Every rule from
 AbstractClass/Notes appears here at least once:

     PART 1  abstract method vs abstract class
     PART 2  what an abstract class may contain
     PART 3  the constructor, and the exact order things run in
     PART 4  choice 1 (concrete subclass) and choice 2 (abstract subclass)
     PART 5  the illegal combinations, commented out
     PART 6  an abstract class with no abstract methods

 =========================================================================
*/

public class AbstractClassDemo {

    public static void main(String[] args) {

        System.out.println("=== 1. creating a Savings account ===");
        // The parent constructor runs first -- watch the order.
        Account a1 = new Savings("Aditya", 10000);
        System.out.println();

        System.out.println("=== 2. abstract + concrete methods together ===");
        a1.showBalance();          // CONCRETE  -- inherited, shared by all
        a1.applyInterest();        // ABSTRACT  -- Savings' version runs
        a1.showBalance();
        System.out.println();

        System.out.println("=== 3. the polymorphic loop ===");
        Account[] accounts = { new Savings("Aditya", 10000),
                               new Current("Rahul", 50000),
                               new FixedDeposit("Sneha", 100000) };

        for (Account a : accounts) {
            a.applyInterest();     // three different bodies, one call site
        }
        System.out.println();

        System.out.println("=== 4. the abstract reference is fine ===");
        // Account acc = new Account("X", 1);
        //     ERROR: Account is abstract; cannot be instantiated
        //     ^ the OBJECT is illegal...
        Account acc = new Savings("Meera", 2000);
        //     ...the REFERENCE is not. This is Notes PART 8, question 8.
        System.out.println("Reference type: Account, real object: "
                           + acc.getClass().getSimpleName());
        System.out.println();

        System.out.println("=== 5. an abstract class with NO abstract methods ===");
        // Notes PART 6. AuditLog is abstract purely to say
        // "do not instantiate me, extend me".
        // AuditLog log = new AuditLog();     ERROR, still cannot instantiate
        AuditLog log = new FileAuditLog();
        log.record("transfer completed");
        System.out.println();

        System.out.println("=== 6. static method on an abstract class ===");
        System.out.println("Accounts created so far: " + Account.getCount());
    }
}


/* ------------------------------------------------------------------------
   THE ABSTRACT CLASS
   ------------------------------------------------------------------------ */
abstract class Account {

    private static int count = 0;              // static field  -- allowed
    static final String BANK = "State Bank";   // constant      -- allowed

    private final String holder;               // instance field -- allowed
    protected double balance;                  // protected, for subclasses

    static {                                   // static block  -- allowed
        System.out.println("[static block] Account class loaded");
    }

    {                                          // instance block -- allowed
        System.out.println("[instance block] preparing an account");
    }

    Account(String holder, double balance) {   // CONSTRUCTOR in an abstract
        this.holder = holder;                  // class. Notes PART 3.
        this.balance = balance;                // Called by super(...) from
        count++;                               // every subclass.
        System.out.println("[Account constructor] " + holder + " at " + BANK);
    }

    public String getHolder() {                // ordinary getter
        return holder;
    }

    void showBalance() {                       // CONCRETE -- shared code.
        System.out.println(holder + " | balance: " + balance);
    }

    final void accountType() {                 // FINAL method in an abstract
        System.out.println("Type: " + getClass().getSimpleName());
    }                                          // class -- allowed. Subclasses
                                               // may call it, never override it.

    static int getCount() {                    // STATIC method -- allowed
        return count;
    }

    private String mask() {                    // PRIVATE helper -- allowed
        return "****" + holder.length();
    }

    void printMasked() {
        System.out.println("Masked id: " + mask());
    }

    abstract void applyInterest();             // ABSTRACT -- no body.
                                               // Every concrete subclass
                                               // MUST write this.

    // --- Notes PART 5: the four illegal combinations. Uncomment to see. ---
    // abstract static void audit();        ERROR: illegal combination static
    // abstract final  void audit();        ERROR: illegal combination final
    // abstract private void audit();       ERROR: illegal combination private
    // abstract void audit() { }            ERROR: abstract methods cannot
    //                                             have a body
}
// abstract final class Broken { }          ERROR: illegal combination
//                                                 abstract and final


/* ------------------------------------------------------------------------
   CHOICE 1 -- concrete subclasses. Each implements EVERY abstract method.
   ------------------------------------------------------------------------ */
class Savings extends Account {

    Savings(String holder, double balance) {
        super(holder, balance);                // MANDATORY -- Account has no
        System.out.println("[Savings constructor] done");   // no-arg constructor
    }

    @Override
    void applyInterest() {
        balance += balance * 0.04;             // protected field, visible here
        System.out.println(getHolder() + ": savings interest 4% -> " + balance);
    }
}


class Current extends Account {

    Current(String holder, double balance) {
        super(holder, balance);
    }

    @Override
    void applyInterest() {
        System.out.println(getHolder() + ": current accounts earn no interest");
    }
}


/* ------------------------------------------------------------------------
   CHOICE 2 -- an abstract subclass. TermAccount adds shared code but does
   NOT implement applyInterest(), so it must stay abstract itself.
   Notes PART 4.
   ------------------------------------------------------------------------ */
abstract class TermAccount extends Account {

    private final int termMonths;

    TermAccount(String holder, double balance, int termMonths) {
        super(holder, balance);
        this.termMonths = termMonths;
    }

    int getTermMonths() {
        return termMonths;
    }

    void penalty() {                           // new shared code for all
        System.out.println("Early withdrawal penalty: 1%");
    }
    // applyInterest() is still not written. That is legal ONLY because
    // this class is abstract. Remove the keyword and it stops compiling.
}


class FixedDeposit extends TermAccount {

    FixedDeposit(String holder, double balance) {
        super(holder, balance, 12);
    }

    @Override
    void applyInterest() {                     // the last one, finally written
        balance += balance * 0.07;
        System.out.println(getHolder() + ": FD interest 7% for "
                           + getTermMonths() + " months -> " + balance);
    }
}


/* ------------------------------------------------------------------------
   NOTES PART 6 -- an abstract class with ZERO abstract methods.
   Perfectly legal. It says "I am complete, but I am a base class."
   ------------------------------------------------------------------------ */
abstract class AuditLog {

    void record(String message) {
        System.out.println("[" + getClass().getSimpleName() + "] " + message);
    }
}

class FileAuditLog extends AuditLog {
    // nothing to implement -- there were no abstract methods.
    // This class exists only to be instantiable.
}

/*
 =========================================================================
 EXPECTED OUTPUT

 === 1. creating a Savings account ===
 [static block] Account class loaded
 [instance block] preparing an account
 [Account constructor] Aditya at State Bank
 [Savings constructor] done

 === 2. abstract + concrete methods together ===
 Aditya | balance: 10000.0
 Aditya: savings interest 4% -> 10400.0
 Aditya | balance: 10400.0

 === 3. the polymorphic loop ===
 [instance block] preparing an account
 [Account constructor] Aditya at State Bank
 [Savings constructor] done
 [instance block] preparing an account
 [Account constructor] Rahul at State Bank
 [instance block] preparing an account
 [Account constructor] Sneha at State Bank
 Aditya: savings interest 4% -> 10400.0
 Rahul: current accounts earn no interest
 Sneha: FD interest 7% for 12 months -> 107000.0

 === 4. the abstract reference is fine ===
 [instance block] preparing an account
 [Account constructor] Meera at State Bank
 [Savings constructor] done
 Reference type: Account, real object: Savings

 === 5. an abstract class with NO abstract methods ===
 [FileAuditLog] transfer completed

 === 6. static method on an abstract class ===
 Accounts created so far: 5


 FIVE THINGS TO NOTICE IN THAT OUTPUT

   A) "[static block] Account class loaded" appears ONCE, at the very top,
      even though five accounts were created. Static blocks run when the
      CLASS loads, not per object. You proved this in BlocksInJava.

   B) The instance block and the parent constructor run BEFORE the child
      constructor, every single time. Notes PART 3.

   C) Every balance here happens to print cleanly. Do not trust that.
      Run  System.out.println(0.1 + 0.2);  and watch it print
      0.30000000000000004. double cannot represent most decimal
      fractions exactly, so the errors show up on SOME values and not
      others -- which is worse than always. Real money code uses
      BigDecimal, never double. Try an opening balance of 0.1 here.

   D) Section 3 creates the objects BEFORE any interest line prints,
      because the whole array initialiser runs first.

   E) "Accounts created so far: 5" -- one static counter shared by every
      subclass. Shared state like this is precisely what an interface
      could not give you.


 SIX THINGS TO TRY

   1. Uncomment  new Account("X", 1)  -- the core error of the topic.
   2. Uncomment each of the four illegal combinations at the end of
      Account and collect the error messages.
   3. Delete  applyInterest()  from Current. Read the error, then fix it
      the OTHER way -- by making Current abstract -- and confirm it
      compiles once you remove  new Current(...)  from main.
   4. Delete the word  abstract  from TermAccount. Read that error and
      explain it in your own words.
   5. Add  @Override void accountType() { }  to Savings. It fails, because
      accountType() is final. Overriding rules have not changed.
   6. Call  a1.printMasked()  from main. It works, even though mask() is
      private -- a public method exposing a private helper is exactly the
      abstraction/encapsulation pairing from Abstraction/Notes PART 5.
 =========================================================================
*/
