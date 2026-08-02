package ArraysPractice;

public class CalculateAverageOfArrayElements {

    public static void main(String[] args) {
        int [] arr={1,2,3,4,5};

        int result =0;
        for (int j : arr) {
            result += j;
        }

        double avg_array= (double) result /arr.length;
        System.out.println("Average is "+avg_array);
    }
}
