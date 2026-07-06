package OOPS.Inheritance.SingleInheritance.HospitalDoctor;

class Hospital{
    String hospitalname="Apollo";
    String City="Latur";
}

class Doctor extends Hospital{
    String doctorName="Prashant sir";
    String Specialization="Cardiologist";
}
public class Main {
    public static void main(String[] args) {
        Doctor obj = new Doctor();
        System.out.println("Hospital : "+obj.hospitalname);
        System.out.println("City : "+obj.City);
        System.out.println("Doctor name : "+obj.doctorName);
        System.out.println("Doctor specialization : "+obj.Specialization);
    }
}
