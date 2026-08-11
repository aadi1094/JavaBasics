package ArraysPractice;

import java.util.Arrays;

public class DifferenceBetweenMaxAndMinValues {
    public static void main(String[] args) {
        int[] arr= {1,2,3,4,5,6,6,10};

        Arrays.sort(arr);
        int n = arr.length;

        System.out.println("Difference between max and min is "+(arr[n-1] - arr[0]));

    }
}
