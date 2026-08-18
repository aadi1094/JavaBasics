package Constructor.ConstructorOverloading;

public class Person {
    int age ;
    int roll_no;
    String name ;
    String college;


    Person(){
        age=21;
        name="yash";
    }

    Person(int age){
        this.age=age;
    }

    Person(int age , String name){
        this.name=name;
        this.age=age;
    }

    Person(int age, String name , String college){
        this.age=age;
        this.name=name;
        this.college=college;
    }

    void display(){
        System.out.println(name+" "+age+" "+roll_no+" "+college);
    }

    public static void main(String[] args) {
        Person p = new Person();
        Person p1= new Person(22);
        Person p2= new Person(22,"Adityaa");
        Person p3= new Person(23,"Addiii","Bidve Collge");


        p.display();
        p1.display();
        p2.display();
        p3.display();

    }
}
