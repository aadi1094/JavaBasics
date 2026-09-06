package DSALeetcodePractice;

import java.util.Arrays;

public class RemoveDuplicatesFromSortedArray_26 {
    public static void main(String[] args) {
        int arr[]= {0,0,1,1,2,2,3,3,3,4};
        int n = arr.length;

        int[] nums = new int[n];

        int k =1;
        for (int i = 1; i < arr.length; i++) {
            if(arr[i] != arr[i-1]){
                nums[k]=arr[i];
                k=k+1;

            }
        }

        System.out.println(k);
        System.out.println(Arrays.toString(nums));
    }
}
