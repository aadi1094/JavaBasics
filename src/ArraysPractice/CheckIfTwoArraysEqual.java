package ArraysPractice;

import java.util.Arrays;
import java.util.Scanner;

public class CheckIfTwoArraysEqual {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of values you want to enter in 1st array");
        int m = sc.nextInt();

        System.out.println("Enter the number of values you want to enter in 2nd array");
        int n = sc.nextInt();


        int[] arr1= new int[m];
        for (int i = 0; i < m; i++) {
            System.out.println("Enter the values of 1st array : ");
            int x = sc.nextInt();
            arr1[i]=x;
        }

        int[] arr2= new int[n];
        for (int i = 0; i < n; i++) {
            System.out.println("Enter the values of 2nd array : ");
            int y = sc.nextInt();
            arr2[i]=y;
        }

        System.out.println("1st array is "+Arrays.toString(arr1));
        System.out.println("2nd array is "+Arrays.toString(arr2));

        boolean result = true;

        for (int i = 0; i < arr1.length; i++) {
            if(m!=n){
            System.out.println("Arrays are not equal");
            result=false;
            break;

            }
            else if (arr1[i]!=arr2[i]){
                System.out.println("Arrays are not equal ");
                result= false;
                break;
            }

        }
        if(result){
            System.out.println("Equal");
        }

    }
}
