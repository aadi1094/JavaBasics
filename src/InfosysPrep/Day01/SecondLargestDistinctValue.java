package InfosysPrep.Day01;

import java.util.Arrays;
import java.util.Scanner;

public class SecondLargestDistinctValue {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n =sc.nextInt();

        int[] arr=new int[n];
        for (int i = 0; i < arr.length; i++) {
           arr[i]=sc.nextInt();
        }

        Arrays.sort(arr);
        int max=arr[n-1];
//        System.out.println(max);

        for (int i = 0; i < arr.length; i++) {
           if(arr[0]==max){
               System.out.println(-1);
               break;
           }
           if(arr[i]==max){
               System.out.println(arr[i-1]);
               break;
           }
        }
    }
}
