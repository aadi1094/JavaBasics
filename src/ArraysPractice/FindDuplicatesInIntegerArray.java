package ArraysPractice;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class FindDuplicatesInIntegerArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Input the number of elements you want to insert : ");
        int n= sc.nextInt();
        int[] arr=new int[n];

        for (int i = 0; i < n; i++) {
            arr[i]= sc.nextInt();
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i]<arr[j]){
                    int temp = arr[i];
                    arr[i]=arr[j];
                    arr[j]=temp;
                }
            }
        }

        System.out.println("Sorted array is "+Arrays.toString(arr));

        Set<Integer> duplicate_elements = new HashSet<>();

        for (int i = 0; i < n-1; i++) {
            if (arr[i]==arr[i+1]){
                duplicate_elements.add(arr[i]);
            }

        }
        System.out.println("Duplicates elements are "+duplicate_elements);
    }
}
