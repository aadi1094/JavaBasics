package OOPS.Inheritance.MultiLevelInheritance.BankAccountSavingsAccount;

public class Main {
    public static void main(String[] args) {
        SavingsAccount obj=new SavingsAccount();
        obj.displayBank();
        System.out.println("Initial Amount is"+obj.Salary);
        obj.Withdraw();
        obj.deposit();
        System.out.println("After interest rate amt is "+ obj.calculateInterest());
    }
}

class Bank{
    String bankName="bank of maharashtra";
    String branch="MIDC latur";

    void displayBank(){
        System.out.println("Bank name : "+bankName +"\nBank Branch : "+branch);
    }
}

class Account extends Bank{
    int accountNumber=1235;
    double Salary=10000;

    int deposit=1000;
    int withdraw=2000;

    void deposit() {
        Salary = Salary + deposit;
        System.out.println("Deposited amount : " + deposit);
        System.out.println("Amount after deposit : " + Salary);
    }

    void Withdraw() {
        Salary = Salary - withdraw;
        System.out.println("Withdrawal amount : " + withdraw);
        System.out.println("Amount after withdrawal : " + Salary);
    }
}

class SavingsAccount extends Account{
    int interest=7;

    double calculateInterest(){
        return Salary+((interest/100.0)*Salary);
    }
}