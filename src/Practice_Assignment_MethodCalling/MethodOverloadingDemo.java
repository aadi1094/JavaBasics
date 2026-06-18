package Practice_Assignment_MethodCalling;

public class MethodOverloadingDemo {
    int add (int x,int y){
        return x+y;
    }
    int add(int x, int y,int z){
        return x+y+z;
    }
    double add(int x ,double y){
        return x+y;
    }
    float add(float x, float y){
        return x+y;
    }

    public static void main(String[] args) {
        MethodOverloadingDemo obj = new MethodOverloadingDemo();
        System.out.println(obj.add(2,5));
        System.out.println(obj.add(3,10000000));
        System.out.println(obj.add(2,3,4));
        System.out.println(obj.add(23,33.43));
    }
}
