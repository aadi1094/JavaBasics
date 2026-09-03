package BlocksInJava;

public class LocalBlock {
    int num=10;
    void display(){

        System.out.println("The value of num "+num);

        {
            int num=11;
            System.out.println("The value of num "+num);
        }

    }

    public static void main(String[] args) {
        LocalBlock obj = new LocalBlock();
        obj.display();
    }
}
