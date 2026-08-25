package Constructor.Practice;

public class StudentDetails {
    String name ;
    String branch ;
    int roll_no;

    StudentDetails(String branch, String name , int roll_no){
        this.branch=branch;
        this.name= name ;
        this.roll_no= roll_no;
    }

    void display(){
        System.out.println("My name is "+name+" my branch is"+branch+" and roll no is"+roll_no);
    }

    public static void main(String[] args) {
        StudentDetails st = new StudentDetails("CsE","Adi",69);
        st.display();
        StudentDetails st1= new StudentDetails("IT","sauda",80);
        st1.display();
    }
}
