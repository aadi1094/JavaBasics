package StaticKeyword;

public class Human {

    String name;
    int age ;
    double salary;
    static long population;
    boolean married = true;

    static void message(){
        System.out.println("Hi huyss");

        //System.out.println(this.age); // we cannot use the "this keyword" as it
        // represent to the refernce variabke which is the object.

    }

    Human(String name, int age , double salary ) {
        this.name = name;
        this.age=age;
        this.salary=salary;
        Human.population+=1;
    }

}
