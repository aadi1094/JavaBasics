package OOPS.Inheritance.SingleInheritance.OnlineCourse;

public class Main {
    public static void main(String[] args) {
        Mentor obj = new Mentor();
        System.out.println("Course name : "+obj.courseName);
        System.out.println("Course duration : "+obj.duration);
        System.out.println("Course mentor : "+obj.Mentorname);
        System.out.println("Course fees : "+obj.fees);
    }
}

class Course{
    String courseName = "Java Course";
    int duration= 9;

}
class Mentor extends Course{
    String Mentorname="Prashant Sir";
    double fees=60000;
}