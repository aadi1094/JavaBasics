package OOPS.Inheritance.HierarchicalInheritance.BankAccountSystem;

public class BankAccount {
    int accNumber=12345;
    String accHolder="Aditya Chawale";
    double salary=10000;

    int depositdepositAmount=1000;
    int withdrwaAmount=2000;

    double deposi(){
        salary=salary+depositdepositAmount;
        return salary;
    }

    double withdraw(){
        salary=salary-withdrwaAmount;
        return salary;
    }

    void displayAccount(){
        System.out.println("Account Number : "+accNumber);
        System.out.println("Account Holder name: "+accHolder);
        System.out.println("Initial Amount : "+salary);
    }
}
