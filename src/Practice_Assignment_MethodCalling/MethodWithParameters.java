package Practice_Assignment_MethodCalling;


public class MethodWithParameters {
    void showName(String name){
        System.out.println("Name: "+name);
    }
    void showAge(int age){
        System.out.println("Age: "+age);
    }
    void showPercentage(double percentage){
        System.out.println("Percentage: "+percentage);
    }
    void showGrade(char grade){
        System.out.println("Grade: "+grade);
    }
    void showDisplayAllDetails(String name,int age,double percentage, char grade){
        System.out.println("Name: "+name +" ,"+ "Age: "+ age +" ,"+ "Percentage: "+percentage +" ,"+ "Grade: "+grade);
    }


    public static void main(String[] args) {
        MethodWithParameters obj = new MethodWithParameters();
        obj.showName("Aditya Chawale");
        obj.showAge(21);
        obj.showPercentage(80.21);
        obj.showGrade('B');
        obj.showDisplayAllDetails("Bhaiyaa Dj",21,90.00,'A');
    }
}

//OP: Name: Aditya Chawale
//Age: 21
//Percentage: 80.21
//Grade: B

//Name: Bhaiyaa Dj ,Age: 21 ,Percentage: 90.0 ,Grade: A