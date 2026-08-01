package Arrays;

import java.util.Arrays;
import java.util.Scanner;

public class PassingInFunctions {
    public static void main(String[] args) {
        int[] nums={1,2,3,4,5};
        System.out.println(Arrays.toString(nums));

        PassingInFunctions obj=new PassingInFunctions();
        obj.change(nums);

        System.out.println(Arrays.toString(nums));
    }

    void change(int[] arr){
        arr[0]=99;
    }
}
