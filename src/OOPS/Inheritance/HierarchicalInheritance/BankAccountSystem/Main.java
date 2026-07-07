package OOPS.Inheritance.HierarchicalInheritance.BankAccountSystem;

public class Main {
    public static void main(String[] args) {
        SavingsAccount obj=new SavingsAccount();
        obj.displayAccount();
        System.out.println("Amount after deposit:"+ obj.deposi());
        System.out.println("Amount after withraw:"+obj.withdraw());

        System.out.println("Interest amount is "+obj.calculateInterest());

        ValidAccount obj1=new ValidAccount();
        System.out.println("Is account active : "+obj1.isValid());
    }
}
