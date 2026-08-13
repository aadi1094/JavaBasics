package StaticKeyword;

public class Main {
    public static void main(String[] args) {
        Human adi = new Human("Adityaa", 22,55000);
        Human yash = new Human("Yashh",21,400000);
        Human mayank;

        System.out.println(Human.population);


        greeting();

        //Static is the thing where we use that thing without creating the object of that class.

        //we know that something which is not static , belongs to object
    }

//    void greeting(){
//        System.out.println("Hello Everyoneeee"); ==> without object we cant call it
//    }

    static void greeting(){
        System.out.println("Heloo everyoneee"); //==>if the method is static then we can use it without object
    }
}
