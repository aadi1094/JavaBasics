package InfosysPrep.Day02;

import java.util.Scanner;

public class ReverseTheArray {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] arr= new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i]=sc.nextInt();
        }

        int[] rev_arr=new int[n];
        for (int i = 0; i <arr.length; i++) {
            rev_arr[i]=arr[n-i-1];
        }

        for (int i = 0; i < rev_arr.length; i++) {
            System.out.print(rev_arr[i]+" ");
        }
    }
}
