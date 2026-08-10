package Constructor;

public class ConstructorBasic {
    int rollno;
    String name = "Adii";
    float marks=90;



    ;

    public static void main(String[] args) {
        ConstructorBasic obj = new ConstructorBasic(); //--> this is by default constructor
                                        //this is know as the Constructor
        System.out.println(obj.rollno);

        System.out.println(obj.name);

        obj.marks=100;
        System.out.println(obj.marks);

    }
}
//op :69
//Adii
//100.0

//when i say obj.rollno it will check in Object (does rollno exist here , then go for default)