package InfosysPrep.Day02;

import java.util.Scanner;

public class TheMissingNumber {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] arr= new int[n];
        for (int i = 0; i < n-1 ; i++) {
            arr[i]= sc.nextInt();
        }

        long sum=0;
        for (int i = 0; i < n-1 ; i++) {
            sum+=arr[i];
        }

        long real_sum=n*(n+1)/2;

        System.out.println(real_sum-sum);
    }
}
