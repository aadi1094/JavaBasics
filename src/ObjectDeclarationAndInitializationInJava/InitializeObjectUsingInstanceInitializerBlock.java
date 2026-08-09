package ObjectDeclarationAndInitializationInJava;

public class InitializeObjectUsingInstanceInitializerBlock {
    int side;
    {
        side=20;
    }

    void areaOfsquare(){
        int square=side*side;
        System.out.println("Area of square : "+square);
    }

    public static void main(String[] args) {
        InitializeObjectUsingInstanceInitializerBlock obj = new InitializeObjectUsingInstanceInitializerBlock();
        obj.areaOfsquare();
    }
}
