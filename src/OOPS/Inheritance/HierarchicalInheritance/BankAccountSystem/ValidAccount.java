package OOPS.Inheritance.HierarchicalInheritance.BankAccountSystem;

public class ValidAccount extends BankAccount {
    boolean isValid(){
        if (salary>10000){
            return true;
        }else{
            return false;
        }

    }
}
