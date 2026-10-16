package InfosysPrep.Day01;

import java.util.Scanner;

public class SumAndMaximum {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] arr= new int[n];
        for(int i=0;i<arr.length;i++){
            arr[i]=sc.nextInt();
        }

        long sum=0;
        for (int i = 0; i < arr.length; i++) {
            sum+=arr[i];
        }

        int max=Integer.MIN_VALUE;
            for (int i = 0; i < arr.length; i++) {
                if(max<arr[i]){
                    max=arr[i];
                }
            }

        System.out.println(sum+" "+max);
    }
}
