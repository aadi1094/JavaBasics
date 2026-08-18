package Constructor.ConstructorChaining;

public class Developed {

    Developed(){
        System.out.println("Developed by Bhaiya Dj");
    }

    Developed(int age){
        this(10,"Addi");
        System.out.println("Bhaiya Dj lives in latur");
    }

    Developed(int age , String name){
        this();
        System.out.println("In 2019");
    }

    public static void main(String[] args) {
        Developed d = new Developed(21);

    }
}
