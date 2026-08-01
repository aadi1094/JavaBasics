package Arrays;

import java.util.Arrays;
import java.util.Scanner;

public class MultiDimension2DArray {

    /*
    {
       {1,2,3},
       {4,5,6},
       {6,7,8}
    }
     */

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int [][] nums= new int[3][3];
        System.out.println(nums.length);


        for(int row=0 ; row<nums.length; row++){
            for (int col=0 ; col<nums[row].length; col++){
                nums[row][col]=in.nextInt();
            }
        }

        for(int row=0 ; row<nums.length; row++){
            for (int col=0 ; col<nums[row].length; col++){
                System.out.print(nums[row][col] + " ");
            }
            System.out.println();
        }

        for (int[] num : nums) {
            System.out.println(Arrays.toString(num));
        }

    }
}
