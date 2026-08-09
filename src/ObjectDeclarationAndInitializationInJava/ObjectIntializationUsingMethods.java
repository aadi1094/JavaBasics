package ObjectDeclarationAndInitializationInJava;

public class ObjectIntializationUsingMethods {
    // In this method, we assign values to the instance variables through a method.
    //A method in Java is a set of code that contains statements to perform a specific task or operation.
    // It helps in organizing and reusing the code. When a method is called, it may return a value to the caller.
    // However, it does not return a value if its return type is void.

    int len;
    int bre;

    void pervalue(int l,int b){
        len=l;
        bre=b;
    }

    void calclate(){
        int areaofrect=len*bre;
        System.out.println("Area of rect is "+areaofrect);
    }

    public static void main(String[] args) {
        ObjectIntializationUsingMethods obj = new ObjectIntializationUsingMethods();

        obj.pervalue(10,20);
        obj.calclate();

    }

}
