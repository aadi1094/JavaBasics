package Interface;


interface  A1{
     void m1();
}

interface S2{
    abstract void m1();

}
public class ClassImplementsInterface implements A1,S2 {


    @Override
    public void m1() {
        System.out.println("Hello Sir");
    }

    public static void main(String[] args) {

        ClassImplementsInterface object= new ClassImplementsInterface();
        object.m1();

        A1 obj=new ClassImplementsInterface();
        obj.m1();

        S2 obj1=new ClassImplementsInterface();
        obj1.m1();
    }

}


//OP ; Hello Sir
//Hello Sir
//Hello Sir