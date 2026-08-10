package ArraysPractice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ConvertArrayToArrayList {
    public static void main(String[] args) {
        int arr[]={1,2,3,4,5,5,5,67,0};

        System.out.println(Arrays.toString(arr));
        List<Integer> arraylist= new ArrayList<>(arr.length);

        for (int num : arr){
            arraylist.add(num);
        }

        System.out.println("Array to arraylist is"+arraylist);


    }
}
