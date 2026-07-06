package OOPS.Inheritance.SingleInheritance.PersonStudent;

public class Main {
    public static void main(String[] args) {
        Student student = new Student();
        student.displayPerson();
        System.out.println("Student name : "+student.name);
        System.out.println("Student Age: "+student.age);

        System.out.println("Student roll no : "+student.rollno);
        System.out.println("Student course : "+student.course);
    }
}
