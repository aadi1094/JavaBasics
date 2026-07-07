package OOPS.Inheritance.MultiLevelInheritance.UniversityDepartmentStudent;

public class Department extends University {
    String deptName="Computer Science & Engineering";
    float CGPA=8.9f;

    void displayAll(){
        System.out.println("University Name : "+universityName);
        System.out.println("University Code : "+universityCode);
        System.out.println("Department Name : "+deptName);
        System.out.println("CGPA : "+CGPA);

    }
}
