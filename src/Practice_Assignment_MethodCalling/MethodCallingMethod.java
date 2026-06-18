package Practice_Assignment_MethodCalling;

public class MethodCallingMethod {
    void MethodA(){
        System.out.println("Good Morning");
        MethodB();
    }

    void MethodB(){
        System.out.println("Heyy Everyone");
        MethodC();
    }

    void MethodC(){
        System.out.println("Method calling method works");
    }

    public static void main(String[] args) {
        MethodCallingMethod obj = new MethodCallingMethod();
        obj.MethodA();
        obj.MethodB();
    }
}

//OP:Good Morning
//Heyy Everyone
//Method calling method works
//Heyy Everyone
//Method calling method works