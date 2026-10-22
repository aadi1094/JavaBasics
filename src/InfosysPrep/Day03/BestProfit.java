package InfosysPrep.Day03;

import java.util.Arrays;
import java.util.Scanner;

import static java.util.Collections.min;

public class BestProfit {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] arr=new int[n];
        for (int i = 0; i < n; i++) {
            arr[i]= sc.nextInt();
        }

        int minSoFar = arr[0], profit = 0;
        for (int i = 1; i < n; i++) {
            profit = Math.max(profit, arr[i] - minSoFar);
            minSoFar = Math.min(minSoFar, arr[i]);
        }

        System.out.println(profit);
    }
}
