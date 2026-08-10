package Constructor;

public class ThisKeyword {
    int rno;
    String name ;
    double salary;

    ThisKeyword(){
        this.rno=10;
        this.name="Aditya";
        this.salary=100000;

        //this gonna replaced with the given object (currently it got replaced by the "th" and then with "th1")
    }

    void greeting(String name ){
        System.out.println("My name is "+name);
    }

    ThisKeyword(int r , String n , double s){
        this.rno=r;
        this.name=n;
        this.salary=s;
    }

    public static void main(String[] args) {
        ThisKeyword th = new ThisKeyword();
        System.out.println(th.name);
        System.out.println(th.rno);
        System.out.println(th.salary);

        ThisKeyword th1 = new ThisKeyword();
        System.out.println(th1.name);
        System.out.println(th1.rno);
        System.out.println(th1.salary);


        th.greeting("adityaaaa");

        ThisKeyword th2= new ThisKeyword(19,"Bhiaya",20000);
        System.out.println(th2.rno);
        System.out.println(th2.name);
        System.out.println(th2.salary);
    }

}
