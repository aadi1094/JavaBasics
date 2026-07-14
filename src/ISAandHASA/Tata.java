package ISAandHASA;

public class Tata extends Car{
    public static void main(String[] args) {
        Tata t= new Tata();
        t.car();

        Engine e= new Engine();
        e.startEngine();
        e.closeEngine();
    }
}
