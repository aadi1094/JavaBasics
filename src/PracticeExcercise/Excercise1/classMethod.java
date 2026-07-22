package PracticeExcercise.Excercise1;

public  class classMethod{
    void greet(){
        System.out.println("Good Morning");
        introduce();
    }

    void introduce(){
        System.out.println("Myself Aditya Chawale");
    }

    public static void main(String[] args){
        classMethod C = new classMethod();
        C.greet();

    }
}
