package OOPS.Inheritance.HierarchicalInheritance.BankAccountSystem;

public class SavingsAccount extends BankAccount{
    float interestRate=12.8f;

    double calculateInterest(){
        return (interestRate /100.0)*salary;
    }
}
