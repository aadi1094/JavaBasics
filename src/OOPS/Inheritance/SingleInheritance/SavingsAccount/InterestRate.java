package OOPS.Inheritance.SingleInheritance.SavingsAccount;

public class InterestRate extends Account {
    float interestRate=7.5f;

    double calculateYearlyInterest(){
        double result= balance+ balance*(interestRate / 100);
        return result;
    }
}
