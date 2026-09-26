package OOPS.Abstraction.Interfaces;

/*
 =========================================================================
 PRACTICE PROBLEM 3  --  OFFICE MACHINES
 =========================================================================

 An office has several machines. Some only print. Some only scan. The
 expensive one does everything.

 Try to model that with inheritance alone and you will fail. You would
 need a Printer class, a Scanner class, and an AllInOne that extends
 BOTH -- and Java gives you exactly one `extends`. That dead end is the
 whole reason interfaces exist. Interfaces/Notes PART 3.

 So: three small CAN-DO contracts, and each machine signs the ones it
 can honour.


 WRITE THE INTERFACES

   1. interface Printable
        CONSTANT       int MAX_COPIES = 50;
        ABSTRACT       void print(String doc, int copies);
        DEFAULT        void powerOn()  -> prints "Printable unit warming up..."

   2. interface Scannable
        ABSTRACT       void scan(String doc);
        DEFAULT        void powerOn()  -> prints "Scannable unit warming up..."
        STATIC         static String formats()
                            -> returns "PDF, PNG, JPG"

   3. interface Faxable
        ABSTRACT       void fax(String doc, String number);
        DEFAULT        void confirm(String number)
                            -> prints "Fax confirmation sent to <number>"


 WRITE THE CLASSES

   4. class BasicPrinter implements Printable
        print()  -> if copies > MAX_COPIES, print
                        "Cannot print <copies> copies. Limit is 50."
                        and return
                    otherwise print "Printing <copies> copy/copies of <doc>"

   5. class HomeScanner implements Scannable
        scan()   -> prints "Scanning <doc> at 300dpi"

   6. class OfficeAllInOne implements Printable, Scannable, Faxable
        print()  -> prints "[AllInOne] printing <copies> of <doc>"
        scan()   -> prints "[AllInOne] scanning <doc> at 600dpi"
        fax()    -> prints "[AllInOne] faxing <doc> to <number>"
                    then calls confirm(number)

        THIS CLASS WILL NOT COMPILE AT FIRST.

        Printable and Scannable BOTH declare a default powerOn(). A class
        that implements both inherits two competing bodies and the
        compiler refuses to choose:

            class OfficeAllInOne inherits unrelated defaults for
            powerOn() from types Printable and Scannable

        Read that error before you fix it. Then resolve it by overriding
        powerOn() and calling BOTH parents in turn:

            @Override
            public void powerOn() {
                Printable.super.powerOn();
                Scannable.super.powerOn();
                System.out.println("All-in-one ready");
            }

        `Printable.super.powerOn()` is syntax that exists nowhere else in
        Java. Notes PART 7 case 2.


 CONSTRAINTS
     - every implementing method must be public
     - @Override on all of them, including the default you resolve
     - no class may extend any other class in this file


 TEST IN MAIN

     Printable p = new BasicPrinter();
     p.powerOn();
     p.print("report.pdf", 3);
     p.print("report.pdf", 500);

     System.out.println();
     Scannable s = new HomeScanner();
     s.powerOn();
     s.scan("id-proof.jpg");
     System.out.println("Supported formats: " + Scannable.formats());

     System.out.println();
     OfficeAllInOne office = new OfficeAllInOne();
     office.powerOn();
     office.print("invoice.pdf", 2);
     office.scan("contract.pdf");
     office.fax("contract.pdf", "022-4455");

     System.out.println();
     // group by CAPABILITY, not by class hierarchy
     Printable[] printers = { new BasicPrinter(), new OfficeAllInOne() };
     for (Printable printer : printers) {
         printer.print("payslip.pdf", 1);
     }


 EXPECTED OUTPUT

     Printable unit warming up...
     Printing 3 copy/copies of report.pdf
     Cannot print 500 copies. Limit is 50.

     Scannable unit warming up...
     Scanning id-proof.jpg at 300dpi
     Supported formats: PDF, PNG, JPG

     Printable unit warming up...
     Scannable unit warming up...
     All-in-one ready
     [AllInOne] printing 2 of invoice.pdf
     [AllInOne] scanning contract.pdf at 600dpi
     [AllInOne] faxing contract.pdf to 022-4455
     Fax confirmation sent to 022-4455

     Printing 1 copy/copies of payslip.pdf
     [AllInOne] printing 1 of payslip.pdf


 AFTER IT WORKS -- SIX THINGS TO TRY

   A) Look at that last loop. BasicPrinter and OfficeAllInOne share no
      parent class at all, yet they sit in the same array and the same
      loop calls both. Write down, in one sentence, why no abstract class
      could have done this.

   B) HomeScanner implements Scannable, and Scannable has a static
      formats(). So try  HomeScanner.formats()  -- and then
      new HomeScanner().formats(). Both fail. Interface static methods
      are NOT inherited; Scannable.formats() is the only way to call it.
      Notes PART 6. Now compare with AbstractClassDemo: there,
      Savings.getCount() DOES work, because a CLASS static method is
      inherited by its subclasses. Interfaces behave differently. That
      asymmetry is the trap.

   C) Add  office.confirm("022-1111");  to main. It works -- confirm() is
      a default method that OfficeAllInOne never wrote. Then try calling
      it through a  Printable  reference. It fails. Why?

   D) Delete the word  public  from HomeScanner.scan(). Read the error.
      Then explain it using the invisible modifiers from Notes PART 1.

   E) Remove your powerOn() override from OfficeAllInOne to get the
      diamond error back. Now fix it the OTHER way -- write a completely
      new body that calls neither parent. Both fixes are legal; decide
      which you would prefer in real code and why.

   F) Add a  class SmartTV implements Printable  that prints photos.
      Nothing else in the file changes, and SmartTV joins the Printable
      array immediately. That is what "program to an interface" buys you.

 =========================================================================
*/

public class MultiFunctionMachine {

    public static void main(String[] args) {

        // TODO uncomment as you write the interfaces and classes below
         Printable p = new BasicPrinter();
         p.powerOn();
         p.print("report.pdf", 3);
         p.print("report.pdf", 500);

         System.out.println();
         Scannable s = new HomeScanner();
         s.powerOn();
         s.scan("id-proof.jpg");
         System.out.println("Supported formats: " + Scannable.formats());

         System.out.println();
         OfficeAllInOne office = new OfficeAllInOne();
         office.powerOn();
         office.print("invoice.pdf", 2);
         office.scan("contract.pdf");
         office.fax("contract.pdf", "022-4455");

         System.out.println();
         Printable[] printers = { new BasicPrinter(), new OfficeAllInOne() };
         for (Printable printer : printers) {
             printer.print("payslip.pdf", 1);
         }
    }
}


interface Printable {

    int MAX_COPIES = 50;                    // public static final, implicitly
    abstract void print(String doc, int copies);

    default void powerOn(){
        System.out.println("Printable unit warming up...");
    }
}


interface Scannable {

    abstract void scan(String doc);

    default void powerOn(){
        System.out.println("Scannable unit warming up...");
    }

    static String formats(){
        return "PDF, PNG, JPG";
    }
}


interface Faxable {

    abstract void fax(String doc, String number);

    // TODO default void confirm(String number)
    //      -> "Fax confirmation sent to <number>"

    default void confirm(String number){
        System.out.println("Fax confirmation sent to "+number);
    }
}


class BasicPrinter implements Printable {

    // TODO @Override public void print(String doc, int copies)

    @Override
    public void print(String doc, int copies) {
        if(copies>MAX_COPIES){
            System.out.println( "Cannot print "+copies+" copies. Limit is 50.");
            return;
        }else{
            System.out.println("Printing "+copies+" copy/copies of "+doc);
        }
    }

}


class HomeScanner implements Scannable {

    // TODO @Override public void scan(String doc)
    //      -> "Scanning <doc> at 300dpi"

    @Override
    public void scan(String doc) {
        System.out.println("Scanning "+doc+" at 300dpi");
    }
}


class OfficeAllInOne implements Printable, Scannable, Faxable {


    @Override
    public void print(String doc, int copies) {
        System.out.println("[AllInOne] printing "+copies+" of "+doc);
    }

    @Override
    public void scan(String doc) {
        System.out.println("[AllInOne] scanning "+doc+ " at 600dpi");
    }


    @Override
    public void fax(String doc, String number) {
        System.out.println("[AllInOne] faxing "+doc+ " to "+number);
        confirm(number);
    }

    @Override
    public void powerOn() {
        Printable.super.powerOn();     // "Printable unit warming up..."
        Scannable.super.powerOn();     // "Scannable unit warming up..."
        System.out.println("All-in-one ready");
    }
}


