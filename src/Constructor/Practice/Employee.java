package Constructor.Practice;

public class Employee {
    int id ;
    String name ;
    double salary;

    Employee(){
        name="Adityaa";
        id=124;
        salary= 600000;
    }

    Employee(int id){
        this.id= id;
    }

    Employee(int id, String name, double salary){
        this.id= id;
        this.name= name;
        this.salary=salary;

    }

    void display(){
        System.out.println("Employee id "+id);
        System.out.println("Employee name "+name);
        System.out.println("Employee salary"+salary);

        System.out.println("----*-----*------*------");
    }

    public static void main(String[] args) {
        Employee e = new Employee();
        e.display();
        Employee e1 = new Employee(100);
        e1.display();
        Employee e2= new Employee(101, "BhaiyaDj", 63463546);
        e2.display();
    }
}

//constructor overloading