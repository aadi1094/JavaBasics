package ArraysPractice;

import java.util.Arrays;
import java.util.Scanner;

public class SortNumericAndStringArrays {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int [] arr= new int[5];
        for (int i = 0; i < arr.length; i++) {
            arr[i]=sc.nextInt();
        }

        System.out.println(Arrays.toString(arr));

        Arrays.sort(arr);

        System.out.println(Arrays.toString(arr));

        String [] arr1= new String[5];
        for (int i = 0; i < arr1.length; i++) {
            arr1[i]=sc.next();
        }
        Arrays.sort(arr1);

        System.out.println(Arrays.toString(arr1));
    }
}
