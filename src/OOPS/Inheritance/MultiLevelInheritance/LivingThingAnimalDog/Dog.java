package OOPS.Inheritance.MultiLevelInheritance.LivingThingAnimalDog;

public class Dog extends Animal {
    String Breed="Labador";
    String Color="Black";

    void bark(){
        System.out.println("Dog is Barking");
    }

    void displayAll(){
        System.out.println("Breed : "+Breed);
        System.out.println("Color : "+Color);
        System.out.println("Food : "+foodtype);
        System.out.println("LifeSpan : "+lifeSpan);
    }
}
