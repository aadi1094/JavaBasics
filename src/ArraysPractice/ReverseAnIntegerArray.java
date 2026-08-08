package ArraysPractice;

import java.util.Arrays;
import java.util.Scanner;

public class ReverseAnIntegerArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] arr= new int[5];
        for (int i = 0; i < arr.length; i++) {
            arr[i]= sc.nextInt();
        }

        int n = arr.length;
        System.out.println("The array is "+ Arrays.toString(arr));

        int [] arr1=new int[5];
        for (int i = 0; i < n ; i++) {
            arr1[i]=arr[n-1-i];
        }

        System.out.println("Reverse array is "+Arrays.toString(arr1));
    }
}
