package ArraysPractice;

import java.util.Scanner;

public class SumAllValuesInAnArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int [] nums = new int[5];
        for (int i = 0; i < nums.length ; i++) {
            nums[i]=sc.nextInt();
        }
        int result =0;
        for (int i = 0; i < nums.length; i++) {
            result+=nums[i];
        }

        System.out.println(result);
    }
}
