package OOPS.Polymorphism.MethodOverloading;

/*
 =========================================================================
 PRACTICE PROBLEM 2  --  PIZZA ORDER BILLING
 =========================================================================

 A pizza shop bills an order. Every caller wants the same thing -- the
 total price -- but each one knows a different amount of detail.

 PRICE RULES
     Size          :  Small = 150 , Medium = 250 , Large = 350
     Extra cheese  :  +50 per pizza
     Total         =  (sizePrice + cheese) * quantity

 DEFAULTS when the caller does not say
     size = "Medium" ,  quantity = 1 ,  extraCheese = false


 WRITE 5 OVERLOADS of a method named  order  that RETURN the total:

     1. the caller says nothing at all
     2. the caller gives only the size
     3. the caller gives the size, then the quantity
     4. the caller gives the quantity, then the size      <- sequence rule
     5. the caller gives size, quantity, and whether extra cheese is wanted

 Work out the signatures yourself from the descriptions above.


 CONSTRAINTS
     - only ONE overload may contain the formula; the others delegate to it
     - every other overload must be a single line
     - return the value, print it in main


 TEST IN MAIN  --  expected output on the right

     order()                     ->   250.0
     order("Large")              ->   350.0
     order("Small", 3)           ->   450.0
     order(2, "Large")           ->   700.0
     order("Medium", 2, true)    ->   600.0

 =========================================================================


 DELEGATION CHAIN -- information flows from LESS to MORE.
 Each overload fills in one missing blank and passes the request down.
 Only the last one, which has every value, does the arithmetic.

     order()              --supplies "Medium"-->  order(size)
     order(size)          --supplies 1--------->  order(size, qty)
     order(qty, size)     --reorders----------->  order(size, qty)
     order(size, qty)     --supplies false----->  order(size, qty, cheese)  *
                                                                           *
                                                  * the formula lives here
*/

public class PizzaOrder {

    private static final int SMALL  = 150;
    private static final int MEDIUM = 250;
    private static final int LARGE  = 350;
    private static final int CHEESE = 50;

    // #1 -- nothing given. Supplies the default size, then delegates.
    double order() {
        return order("Medium");
    }

    // #2 -- size only. Supplies the default quantity, then delegates.
    double order(String size) {
        return order(size, 1);
    }

    // #3 -- quantity first. Only reorders the arguments, then delegates.
    double order(int quantity, String size) {
        return order(size, quantity);
    }

    // #4 -- size + quantity. Supplies the default cheese flag, then delegates.
    double order(String size, int quantity) {
        return order(size, quantity, false);
    }

    // #5 -- the ONLY overload that holds the formula.
    double order(String size, int quantity, boolean cheese) {
        double price;
        if (size.equalsIgnoreCase("Small")) {
            price = SMALL;
        } else if (size.equalsIgnoreCase("Large")) {
            price = LARGE;
        } else {
            price = MEDIUM;
        }

        if (cheese) {
            price = price + CHEESE;
        }

        return price * quantity;
    }

    public static void main(String[] args) {
        PizzaOrder p = new PizzaOrder();
        System.out.println(p.order());                    // 250.0
        System.out.println(p.order("Large"));             // 350.0
        System.out.println(p.order("Small", 3));          // 450.0
        System.out.println(p.order(2, "Large"));          // 700.0
        System.out.println(p.order("Medium", 2, true));   // 600.0
    }
}
