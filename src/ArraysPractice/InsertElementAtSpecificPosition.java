package ArraysPractice;

import java.util.Arrays;
import java.util.Scanner;

public class InsertElementAtSpecificPosition {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int [] arr= new int[10];

        for (int i = 0; i < arr.length; i++) {
            arr[i]=sc.nextInt();
        }

        System.out.println("The array is "+ Arrays.toString(arr));

        System.out.println("Enter the specific position : ");
        int n=sc.nextInt();
        System.out.println("Enter the specific element : ");
        int p =sc.nextInt();

        arr[n]=p;

        System.out.println("After specific element the array is "+Arrays.toString(arr));
    }
}
