package OOPS.Polymorphism.MethodOverriding;

/*
 =========================================================================
 PRACTICE PROBLEM 1  --  PAYMENT SYSTEM
 =========================================================================

 An app lets a customer pay in different ways. Every payment type does the
 same job -- pay an amount -- but each one does it differently.

 This is the opposite of overloading. There the CALLER changed and the
 logic stayed the same. Here the caller stays the same and the OBJECT
 changes what happens.


 WRITE 4 CLASSES

   1. Payment                 (the parent)
        void pay(double amount)   ->  prints  "Processing payment of <amount>"
        void receipt()            ->  prints  "Receipt generated"

   2. CreditCardPayment extends Payment
        override pay()      ->  adds a 2% fee, then prints
                                "Paid <total> by Credit Card (2% fee included)"
        override receipt()  ->  prints "Credit card receipt sent to email"

   3. UpiPayment extends Payment
        override pay()      ->  prints "Paid <amount> by UPI"
        DO NOT override receipt()   <-- deliberately. See what happens.

   4. WalletPayment extends Payment
        override pay()      ->  call super.pay(amount) FIRST,
                                then print "Paid <amount> from Wallet"
        DO NOT override receipt()


 CONSTRAINTS
     - put @Override on every overridden method
     - WalletPayment must EXTEND the parent behaviour using super, not
       replace it
     - keep every method body to one or two printed lines


 TEST IN MAIN

     Payment[] payments = { new CreditCardPayment(),
                            new UpiPayment(),
                            new WalletPayment() };

     for (Payment p : payments) {
         p.pay(1000);
         p.receipt();
     }

 That single loop IS runtime polymorphism. The reference type is Payment
 every time, yet a different pay() runs on each pass.


 EXPECTED OUTPUT

     Paid 1020.0 by Credit Card (2% fee included)
     Credit card receipt sent to email
     Paid 1000.0 by UPI
     Receipt generated
     Processing payment of 1000.0
     Paid 1000.0 from Wallet
     Receipt generated

 Look closely at lines 4 and 7. UpiPayment and WalletPayment never wrote a
 receipt() method, so the PARENT's version ran. Not overriding is a choice.


 AFTER IT WORKS -- TWO THINGS TO TRY

   A) Give WalletPayment an extra method  void checkBalance()  and call
      p.checkBalance() inside the loop. Read the compile error. Why is it
      an error when the object really is a WalletPayment?

   B) Misspell one overridden method -- write  paY  instead of  pay  --
      while leaving @Override on it. Read that error too, then fix it.

 =========================================================================
*/

import java.sql.PreparedStatement;

public class PaymentSystem {

    public static void main(String[] args) {
        Payment[] payments = { new CreditCardPayment(),
                new UpiPayment(),
                new WalletPayment() };

        for (Payment p : payments) {
            p.pay(1000);
            p.receipt();
        }

    }
}

class Payment{
    void pay(double amount){
        System.out.println("Processing Payment of "+amount);
    }

    void receipt(){
        System.out.println("Receipt generated");
    }
}

class CreditCardPayment extends Payment {
    @Override
    void pay(double amount) {
        double result = amount+ amount*0.02;
        System.out.println("Paid " + result + " by Credit Card (2% fee included)");
    }

    @Override
    void receipt() {
        System.out.println("Credit card receipt sent to email");
    }
}

class UpiPayment extends Payment{
    @Override
    void pay(double amount) {
        System.out.println("Paid "+ amount+" by UPI");
    }

}

class WalletPayment extends Payment{
    @Override
    void pay(double amount) {
        super.pay(amount);
        System.out.println("Paid"+amount+" from wallet");
    }
}