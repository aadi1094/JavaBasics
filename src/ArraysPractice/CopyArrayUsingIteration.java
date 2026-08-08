package ArraysPractice;

import java.util.Arrays;

public class CopyArrayUsingIteration {
    public static void main(String[] args) {

        int [] arr={1,2,3,3,45,53,2,2,3,3,33,3,2};

        int n = arr.length;

        int[] arr1 = new int[n];
        for (int i = 0; i < arr.length ; i++) {
            arr1[i]=arr[i];
        }
        System.out.println(Arrays.toString(arr1));
    }
}
