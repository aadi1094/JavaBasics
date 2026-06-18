package Practice_Assignment_MethodCalling;

public class BasicMethodCalling {
    void greet(){
        System.out.println("Welcome to Java practice");
    }

    void showCollege(){
        System.out.println("My College is M S Bidve Engineering College Latur");
    }

    void showBranch(){
        System.out.println("My barnch is Computer Science Engineering");
    }

    void showGoal(){
        System.out.println("My goal is to become the Software Engineer In MNC");
    }

    public static void main(String[] args) {
        BasicMethodCalling obj= new BasicMethodCalling();

        obj.greet();
        obj.showCollege();
        obj.showBranch();
        obj.showGoal();
    }
}

//Output -> Welcome to Java practice
//My College is M S Bidve Engineering college Latur
//My barnch is Computer Science Engineering
//My goal is to become the Software Engineer In MNC