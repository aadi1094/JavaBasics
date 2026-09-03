package BlocksInJava;

public class InstanceInitializationBlock {

    void add(int x , int y){
        System.out.println("The sum of two numbers is "+(x+y));
    }

    {
        System.out.println("Instance Block");
    }

    public static void main(String[] args) {
        InstanceInitializationBlock obj = new InstanceInitializationBlock();
        obj.add(10,20);
        obj.add(21,20);

        InstanceInitializationBlock obj1 = new InstanceInitializationBlock();
        obj1.add(10,3);


    }
}

//output is :
//Instance Block
//The sum of two numbers is 30
//The sum of two numbers is 41
//Instance Block
//The sum of two numbers is 13

//As you see , whenever i m creating the new object , the instance block will get printed .
