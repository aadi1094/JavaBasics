package OOPS.Abstraction.Interfaces;

/*
 =========================================================================
 PRACTICE PROBLEM 4  --  HOTEL BOOKING  (CAPSTONE)
 =========================================================================

 The last three problems used ONE tool each. Real code uses both at once,
 and this is the shape you will see in every professional Java codebase:

     interface      Bookable        <- the contract, open to anything
     abstract class Room            <- shared fields + shared code
                        implements Bookable
     class          StandardRoom extends Room
     class          DeluxeRoom   extends Room implements Discountable
     class          BanquetHall  implements Bookable      <- NOT a Room

 Read that list again and notice the two different jobs:

     Room       answers "what IS this thing, and what do all of them
                share?" -- it holds the roomNumber and the rate, and it
                has a constructor to validate them. Only an abstract
                class can do that.

     Bookable   answers "what can this thing DO?" -- and BanquetHall is
                bookable without being a Room at all. Only an interface
                can do that.

 Abstraction/Notes PART 6 is the decision procedure. This problem is it,
 applied.


 WRITE THE INTERFACES

   1. interface Bookable
        ABSTRACT   double calculateBill(int nights);
        ABSTRACT   String label();
        DEFAULT    void cancellationPolicy()
                        -> prints "Free cancellation up to 24 hours before"

   2. interface Discountable
        CONSTANT   double MAX_DISCOUNT = 0.25;      // 25%
        ABSTRACT   double discountRate();           // e.g. 0.10
        DEFAULT    double applyDiscount(double amount)
                        - if discountRate() > MAX_DISCOUNT, print
                          "Discount capped at 25%" and use MAX_DISCOUNT
                        - return amount - (amount * rate)

      Note that applyDiscount() is a DEFAULT method calling an ABSTRACT
      one. The interface writes the rule once; each class supplies only
      its own number. That is the same trick Room.display() used in
      ShapeArea -- shared logic calling a body it has never seen.


 WRITE THE ABSTRACT CLASS

   3. abstract class Room implements Bookable

        FIELDS (private)
            roomNumber   int      final
            baseRate     double
            occupied     boolean

        CONSTRUCTOR Room(int roomNumber, double baseRate)
            - if baseRate < 500, print "Rate too low, using 500" and
              use 500 instead
            - occupied starts false

        CONCRETE
            getRoomNumber()   getBaseRate()   isOccupied()
            void checkIn()    -> if already occupied print
                                 "Room <n> is already occupied"
                                 otherwise set true and print
                                 "Checked in to room <n>"
            void checkOut()   -> if not occupied print
                                 "Room <n> is already free"
                                 otherwise set false and print
                                 "Checked out of room <n>"
            void summary()    -> prints
                                 "Room <n> | <label()> | rate <baseRate>"

        NOT WRITTEN HERE
            calculateBill() and label() come from Bookable and are simply
            left unimplemented. That is legal because Room is abstract --
            AbstractClass/Notes PART 2, last item. The first CONCRETE
            subclass has to supply them.


 WRITE THE CLASSES

   4. class StandardRoom extends Room
        constructor  StandardRoom(int roomNumber)   -> baseRate 2000
        label()          -> "Standard"
        calculateBill()  -> baseRate * nights

   5. class DeluxeRoom extends Room implements Discountable
        constructor  DeluxeRoom(int roomNumber)     -> baseRate 4000
        label()          -> "Deluxe"
        discountRate()   -> 0.10
        calculateBill()  -> applyDiscount(baseRate * nights)

   6. class Suite extends Room implements Discountable
        constructor  Suite(int roomNumber)          -> baseRate 9000
        label()          -> "Suite"
        discountRate()   -> 0.40      <- deliberately over the cap
        calculateBill()  -> applyDiscount(baseRate * nights) + 1500
                            (the 1500 is a butler charge, added AFTER
                             the discount)
        cancellationPolicy()  -> OVERRIDE the default:
                            "Suites: cancellation charged 50% within 7 days"

   7. class BanquetHall implements Bookable
        NOT a Room. No roomNumber, no check-in.
        private final double dayRate = 25000;
        label()          -> "Banquet Hall"
        calculateBill()  -> dayRate * nights


 CONSTRAINTS
     - Room's fields stay private; subclasses use getBaseRate()
     - every interface method implemented as public
     - @Override everywhere, including on the overridden default
     - nothing prints inside calculateBill() except the discount-cap
       warning that lives in the interface


 TEST IN MAIN

     Bookable[] bookings = { new StandardRoom(101),
                             new DeluxeRoom(201),
                             new Suite(301),
                             new BanquetHall() };

     for (Bookable b : bookings) {
         System.out.println(b.label() + " -> " + b.calculateBill(3));
         b.cancellationPolicy();
     }

     System.out.println();
     StandardRoom s = new StandardRoom(102);
     s.summary();
     s.checkIn();
     s.checkIn();
     s.checkOut();
     s.checkOut();

     System.out.println();
     Room cheap = new StandardRoom(103);    // watch the rate validation
     System.out.println("Rate: " + cheap.getBaseRate());


 EXPECTED OUTPUT

     Standard -> 6000.0
     Free cancellation up to 24 hours before
     Deluxe -> 10800.0
     Free cancellation up to 24 hours before
     Discount capped at 25%
     Suite -> 21750.0
     Suites: cancellation charged 50% within 7 days
     Banquet Hall -> 75000.0
     Free cancellation up to 24 hours before

     Room 102 | Standard | rate 2000.0
     Checked in to room 102
     Room 102 is already occupied
     Checked out of room 102
     Room 102 is already free

     Rate: 2000.0

 Check the Suite number by hand: 9000 * 3 = 27000, capped discount 25%
 gives 20250, plus the 1500 butler charge = 21750. If you get 20250 you
 applied the discount after adding the charge.


 THE FOUR THINGS THIS PROGRAM PROVES

   1. The loop calls b.calculateBill(3) on four objects. Three are Rooms,
      one is not. They share an INTERFACE, not a parent class. Nothing
      but an interface could have grouped them.

   2. Room has a constructor that enforces "rate is never below 500", for
      every room type that will ever exist. Nothing but an abstract class
      could have done that.

   3. Suite's discount is 0.40, over the cap. The rule that catches it is
      written ONCE, in a default method in Discountable, and Suite never
      sees it. That is abstraction: the caller does not know how.

   4. Room implements Bookable but writes neither of its methods. It just
      passes the obligation down. Legal only because Room is abstract.


 AFTER IT WORKS -- SIX THINGS TO TRY

   A) Add  Bookable b = new Bookable();  and  Room r = new Room(1, 1000);
      Both fail, for the same reason, with slightly different wording.

   B) Make StandardRoom implement Discountable with a 0 rate. Everything
      still compiles and the bill is unchanged. Adding a capability to
      ONE class in a hierarchy costs nothing -- try doing that with a
      superclass.

   C) Move calculateBill() out of Bookable and into Room as an abstract
      method. Everything still compiles EXCEPT BanquetHall, which is now
      excluded from the array. Put it back. You have just demonstrated
      the cost of choosing the wrong tool.

   D) In Room, change  private double baseRate  to  protected  and set it
      directly from Suite. It works -- and now the "never below 500" rule
      you wrote in the constructor can be bypassed by any subclass, for
      ever. Change it back. This is the argument against protected
      fields. Encapsulation/Notes PART 4.

   E) Add  void gymAccess();  as a new ABSTRACT method on Bookable. All
      four classes break at once. Now make it a DEFAULT method instead
      and everything compiles again. Interfaces/Notes PART 5 -- this is
      exactly why Java 8 added them.

   F) Delete the @Override from Suite.cancellationPolicy() and misspell
      it as cancelationPolicy(). It compiles fine, and the Suite silently
      gets the WRONG policy at runtime. Put @Override back and the
      compiler catches it instantly. This is the strongest possible
      argument for always writing @Override.

 =========================================================================
*/

public class HotelBookingApp {

    public static void main(String[] args) {


         Bookable[] bookings = { new StandardRoom(101),
                                 new DeluxeRoom(201),
                                 new Suite(301),
                                 new BanquetHall() };

         for (Bookable b : bookings) {
             System.out.println(b.label() + " -> " + b.calculateBill(3));
             b.cancellationPolicy();
         }

         System.out.println();
         StandardRoom s = new StandardRoom(102);
         s.summary();
         s.checkIn();
         s.checkIn();
         s.checkOut();
         s.checkOut();

         System.out.println();
         Room cheap = new StandardRoom(103);
         System.out.println("Rate: " + cheap.getBaseRate());
    }
}


interface Bookable {
    abstract double calculateBill(int nights);
    abstract String label();

    default void cancellationPolicy(){
        System.out.println("Free cancellation up to 24 hours before");
    }
}


interface Discountable {

    double MAX_DISCOUNT = 0.25;             // public static final
    abstract double discountRate();
    default double applyDiscount(double amount) {
        double rate = discountRate();
        if (rate > MAX_DISCOUNT) {
            System.out.println("Discount capped at 25%");
            rate = MAX_DISCOUNT;
        }
        return amount - (amount * rate);
    }

}
abstract class Room implements Bookable {

    private final int roomNumber;
    private double baseRate;
    private boolean occupied;

    Room(int roomNumber, double baseRate) {
        this.roomNumber = roomNumber;
        if (baseRate<500){
            System.out.println("Rate too low, using 500");
            baseRate=500;
        }
        this.baseRate = baseRate;
        this.occupied = false;
    }

    public int     getRoomNumber() { return roomNumber; }
    public double  getBaseRate()   { return baseRate; }
    public boolean isOccupied()    { return occupied; }

    void checkIn() {
        if (occupied) {
            System.out.println("Room " + roomNumber + " is already occupied");
            return;
        }
        occupied = true;
        System.out.println("Checked in to room " + roomNumber);
    }

    void checkOut() {

        if (!occupied) {
            System.out.println("Room "+roomNumber+ " is already free");
            return;
        }
        occupied = false;
        System.out.println("Checked out to room " + roomNumber);
    }

    void summary() {
        System.out.println("Room " + roomNumber + " | " + label() + " | rate " + baseRate);
    }

    // NOTE: calculateBill() and label() come from Bookable and are
    // deliberately NOT written here. AbstractClass/Notes PART 2.
}


class StandardRoom extends Room {

    StandardRoom(int roomNumber) {
        super(roomNumber, 2000);
    }

    @Override
    public String label() {
        return "Standard";
    }

    @Override
    public double calculateBill(int nights) {
        return getBaseRate()*nights;
    }
}


class DeluxeRoom extends Room implements Discountable {

    DeluxeRoom(int roomNumber) {
        super(roomNumber, 4000);
    }


    @Override
    public String label() {
        return "Deluxe";
    }


    @Override
    public double discountRate() {
        return 0.10;
    }

    @Override
    public double calculateBill(int nights) {
        return applyDiscount(getBaseRate()*nights);
    }
}


class Suite extends Room implements Discountable {

    Suite(int roomNumber) {
        super(roomNumber, 9000);
    }


    @Override
    public String label() {
        return "Suite";
    }

    @Override
    public double discountRate() {
        return 0.40;
    }

    @Override
    public double calculateBill(int nights) {
        return applyDiscount(getBaseRate()*nights)+1500;
    }

    @Override
    public void cancellationPolicy() {
        System.out.println("Suites: cancellation charged 50% within 7 days");
    }
}


/* Bookable, but NOT a Room. This is the class that justifies the
   interface. Delete Bookable and there is no type left that can hold
   both a Suite and a BanquetHall. */
class BanquetHall implements Bookable {

    private final double dayRate = 25000;


    @Override
    public String label() {
        return "Banquet Hall";
    }

    @Override
    public double calculateBill(int nights) {
        return dayRate*nights;
    }
}
