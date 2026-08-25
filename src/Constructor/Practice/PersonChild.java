package Constructor.Practice;

public class PersonChild {
    String name;
    int age;

    PersonChild(String name , int age){
        this.name = name;
        this.age=age;

        System.out.println("The name is "+name+" age is"+age);
    }
}

class student extends PersonChild{
    int rollno;
    String course;

    student(int rollno, String course){
        super("Aditya", 22);
        this.rollno=rollno;
        this.course=course;

        System.out.println("The roll no is "+rollno+" course is "+course);
    }
}

class Main{
    public static void main(String[] args) {
        student st = new student(69,"Btech Cse");

    }
}
