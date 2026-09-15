package OOPS.Encapsulation;

/*
 =========================================================================
 PRACTICE PROBLEM  --  BANK ACCOUNT
 =========================================================================

 Rewrite your old BankAccountSystem/BankAccount.java properly.

 The old one looked like this:

     int accNumber = 12345;
     String accHolder = "Aditya Chawale";
     double salary = 10000;             <- an account balance called "salary"
     int depositdepositAmount = 1000;   <- a deposit amount stored as a FIELD

 Three things were wrong: the fields were unprotected, the amounts were
 fields instead of parameters, and withdraw() never checked the balance.


 THE CLASS INVARIANT -- the sentence that must ALWAYS be true:

     "balance is never negative, and accNumber never changes"

 Your job is to make that sentence impossible to break.


 WRITE THE CLASS

   FIELDS  (all private)
       accNumber    int      read-only after construction -- make it final
       holderName   String
       balance      double

   CONSTRUCTOR
       BankAccount(int accNumber, String holderName, double openingBalance)

   METHODS
       getAccNumber()    -> returns it.  NO setter: an account number must
                            never change once the account exists.
       getHolderName()   -> returns it
       setHolderName()   -> reject null or empty, print "Name cannot be empty"
       getBalance()      -> returns it.  NO setter: see below.

       deposit(double amount)
            amount <= 0   -> print "Deposit must be positive"
            otherwise     -> add it, print "Deposited <amt> | Balance: <bal>"

       withdraw(double amount)
            amount <= 0        -> print "Withdrawal must be positive"
            amount > balance   -> print "Insufficient balance. Available: <bal>"
            otherwise          -> subtract, print "Withdrew <amt> | Balance: <bal>"

 WHY THERE IS NO setBalance()
     A real bank account has no "set the balance to X" operation. It has
     deposit and withdraw. Expose the BEHAVIOUR, not the field.
     This is Notes PART 9 -- the difference between a class and a data bag.


 TEST IN MAIN

     BankAccount acc = new BankAccount(1001, "Aditya", 5000);

     acc.deposit(2000);
     acc.withdraw(3000);
     acc.withdraw(10000);
     acc.deposit(-500);
     acc.setHolderName("");
     System.out.println("Final balance: " + acc.getBalance());
     System.out.println("Holder: " + acc.getHolderName());


 EXPECTED OUTPUT

     Deposited 2000.0 | Balance: 7000.0
     Withdrew 3000.0 | Balance: 4000.0
     Insufficient balance. Available: 4000.0
     Deposit must be positive
     Name cannot be empty
     Final balance: 4000.0
     Holder: Aditya

 Notice the last two lines. The bad deposit and the bad name were both
 refused, and the object still holds valid data. That is encapsulation
 doing its job.


 AFTER IT WORKS -- THREE THINGS TO TRY

   A) Add  acc.balance = 999999;  to main. It must NOT compile.
      Read the error. That impossibility is the entire point.

   B) Add  acc.accNumber = 2002;  -- two separate reasons it fails.
      Work out both. (Hint: one is private, one is final.)

   C) In setHolderName, write  holderName = holderName;  instead of
      this.holderName = holderName;  It compiles with no warning. Run it
      and watch the name silently never change. See Notes PART 8.

 =========================================================================
*/

public class BankAccount {

    private final int accNumber;
    private String holderName;
    private double balance;

    BankAccount(int accNumber, String holderName, double balance){
        this.accNumber= accNumber;
        this.holderName=holderName;
        this.balance=balance;
    }

    public int getAccNumber(){
        return accNumber;
    }

    public String getHolderName(){
        return holderName;
    }

    public void setHolderName(String name){
        if(name==null || name.equals("")){
            System.out.println("Name cannot be empty");
            return;
        }
        this.holderName=name;
    }

    public double getBalance(){
        return balance;
    }

    public void deposit(double amount){
        if(amount<=0){
            System.out.println("Deposit must be positive");
            return;
        }
        balance+=amount;
        System.out.println("Deposited " +amount+" | Balance:"+balance);
    }

    public void withdraw(double amount){
        if(amount<=0){
            System.out.println("Withdrawal must be positive");
            return;
        } else if (amount > balance) {
            System.out.println("Insufficient balance. Available: "+balance);
            return;
        }
        balance-=amount;
        System.out.println("Withdrew "+amount+" | Balance: "+balance);

    }

    public static void main(String[] args) {
        BankAccount acc = new BankAccount(1001, "Aditya", 5000);

        acc.deposit(2000);
        acc.withdraw(3000);
        acc.withdraw(10000);
        acc.deposit(-500);
        acc.setHolderName("");
        System.out.println("Final balance: " + acc.getBalance());
        System.out.println("Holder: " + acc.getHolderName());
        System.out.println("Account Number: "+acc.getAccNumber());
    }
}

