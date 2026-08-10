package ArraysPractice;

import java.util.Arrays;
import java.util.Scanner;

public class FindPairWithGivenSum {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of elements you want to enter : ");
        int n = sc.nextInt();
        int [] arr= new int[n];
        System.out.println("Enter the values and press enter : ");
        for (int i = 0; i < n; i++) {

            int x = sc.nextInt();
            arr[i]=x;
        }

        System.out.println("The array is "+ Arrays.toString(arr));

        System.out.println("Enter the TARGET value : ");
        int target= sc.nextInt();

        for (int i = 0; i < arr.length; i++) {
            for (int j = i+1; j < arr.length; j++) {
                if (arr[i]+arr[j]==target){
                    System.out.println("The pair is "+arr[i] +" " +arr[j]);

                }
            }

        }
    }
}
