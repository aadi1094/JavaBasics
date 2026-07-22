package PracticeExcercise.Excercise3;
//Write Program shows the four levels of accessibility permission with
//packages?
public class Example2 {
    private void m1(){
        System.out.println("Provate");
    }
    protected void m2(){
        System.out.println("Procted");
    }
    void m3(){
        System.out.println("defalul");
    }
    public void m4(){
        System.out.println("Public");
    }

    public static void main(String[] args) {
        Example2 ex=new Example2();
        ex.m1();
        ex.m2();
        ex.m3();
        ex.m4();
    }
}
