package Practice_Assignment_MethodCalling;

public class StaticAndNonStaticMethods {
    static void showCompanyName(){
        System.out.println("Company name: REEN");
    }
    static void showCountryName(){
        System.out.println("Country:India");
    }
    void showEmployeeName(String name){
        System.out.println("Employee Name:"+name);
    }
    void showEmployeeSalary(double salary){
        System.out.println("Employee Salary:"+salary);
    }

    public static void main(String[] args) {
        StaticAndNonStaticMethods obj= new StaticAndNonStaticMethods();
        showCompanyName();
        showCountryName();
        obj.showEmployeeName("Aditya Chawale");
        obj.showEmployeeSalary(456789);
    }
}

//Op: Company name: REEN
//Country:India
//Employee Name:Aditya Chawale
//Employee Salary:456789.0
