package OOPS.Inheritance.MultiLevelInheritance.UniversityDepartmentStudent;

public class Main {
    public static void main(String[] args) {
        Studnet st=new Studnet();
        st.displayAll();
    }
}

 class University{
    String uniname="Dbatu";
}
 class Department extends University{
    String depName="cse";
}

class Studnet extends Department{
    String studname="adityaa";
    int rollno=69;

    void displayAll(){
        System.out.println("University : "+uniname);
        System.out.println("Department : "+depName);
        System.out.println("Student Name : "+studname);
        System.out.println("Studnet Roll no: "+rollno);
    }
}
