package ISAandHASA.HumanBeing;

class Person{
    void heart(){
        System.out.println("Every person has the heart");
    }
}

class functions{
    void breathin(){
        System.out.println("Inhales");
    }
    void braethout(){
        System.out.println("Exhales");
    }
}

public class Main extends functions {
    public static void main(String[] args) {
        Person p = new Person();
        p.heart();

        Main m = new Main();
        m.breathin();
        m.braethout();
    }
}
