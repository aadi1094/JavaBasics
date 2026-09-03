package BlocksInJava;

public class StaticInitializationBlock {
    static String collegeName;
    // Static initialization block.
    static {
        collegeName = "PIET";
        System.out.println("Static1 block executed");
    }

    static {
        collegeName = "M S Bidve";
        System.out.println("Static2 block executed");
    }
    public static void main(String[] args) {
        System.out.println("College Name: " + collegeName);
    }
}
