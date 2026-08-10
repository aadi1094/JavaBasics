package ArraysPractice;

import java.util.Arrays;

public class FindMissingNumberInArray {
    public static void main(String[] args) {
        int[] arr= {1,2,3,5,6,7,8,9,10};
        int n = arr.length + 1;
        int expectedSum = n * (n + 1) / 2;

        int actualsum=0;
        for (int i = 0; i < arr.length; i++) {
            actualsum+=arr[i];
        }

        System.out.println("Missing numner is "+(expectedSum-actualsum));
    }
}
