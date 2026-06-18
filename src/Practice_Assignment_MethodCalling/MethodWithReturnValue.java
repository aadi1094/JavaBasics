package Practice_Assignment_MethodCalling;

public class MethodWithReturnValue {
    int addNumbers(int x,int y){
        return x+y;
    }
    int findsquare(int a){
        return a*a;
    }
    String fullName(String firstname, String lastName){
        return firstname+" "+lastName;
    }
    boolean isEligibletoVote(int age){
        if (age>18){
            return true;
        }
        else{
            return false;
        }
    }

    public static void main(String[] args) {
        MethodWithReturnValue obj = new MethodWithReturnValue();
        int add= obj.addNumbers(2,7);
        System.out.println("Addition :"+add);
        int square=obj.findsquare(4);
        System.out.println("Square :"+square);
        boolean vote=obj.isEligibletoVote(20);
        System.out.println("Vote:"+vote);
        String fullname=obj.fullName("Aditya","Chawale");
        System.out.println("FullName :"+fullname);

    }
}
