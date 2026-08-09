package ArraysPractice;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class FindSecondLargestElementInArray {
    public static void main(String[] args) {
        int arr[]= {21,22,32,43,53,21,67,86,35,101,106};

//        Arrays.sort(arr);
//        System.out.println(Arrays.toString(arr));

        Set<Integer> arrset= new HashSet<>();

        for (int i = 0; i < arr.length; i++) {
            arrset.add(arr[i]);
        }

        System.out.println(arrset);

        int[] newarr=arrset.stream().mapToInt(Integer::intValue).toArray();

        Arrays.sort(newarr);
        System.out.println(Arrays.toString(newarr));
        int n = newarr.length;
        System.out.println("Largest second ele is "+newarr[n-2]);

    }
}
