package Practice_Assignment_MethodCalling;

public class MiniStudentResultSystem {
    int calculateTotal(int x,int y , int z){
        return x+y+z;
    }
    float calculateAverage(float x){
        return x/3;
    }

    char getGrade(double avg) {
        if (avg >= 90) {
            return 'A';
        } else if (avg >= 75) {
            return 'B';
        } else {
            return 'f';
        }
    }
    String finalresult(double avg){
        if (avg>=50){
            return "Pass";
        }else{
            return "Fail";
        }
    }

    public static void main(String[] args) {
        MiniStudentResultSystem obj = new MiniStudentResultSystem();
        float res=obj.calculateTotal(80,90,100);
        System.out.println("Calculated total is "+res);
        double percentage= obj.calculateAverage(res);
        System.out.println("Percentage is "+ percentage);
        char grade= obj.getGrade(percentage);
        System.out.println("Grade is "+grade);
        String finalres= obj.finalresult(percentage);
        System.out.println("Final result is "+finalres);

    }
    }
    //Op:Calculated total is 270.0
//Percentage is 90.0
//Grade is A
//Final result is Pass
