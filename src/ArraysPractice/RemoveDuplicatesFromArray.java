package ArraysPractice;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class RemoveDuplicatesFromArray {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the elements");
        int[] arr=new int[10];
        for (int i = 0; i < arr.length; i++) {
            arr[i]= sc.nextInt();
        }

        System.out.println("The array is "+Arrays.toString(arr));

        Set<Integer> set = new HashSet<>();

        for (int num : arr) {
            set.add(num);
        }

        Integer[] uniqueNumbers = set.toArray(new Integer[0]);

        System.out.println(Arrays.toString(uniqueNumbers));
    }
}
