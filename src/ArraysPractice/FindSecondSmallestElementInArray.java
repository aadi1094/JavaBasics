package ArraysPractice;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class FindSecondSmallestElementInArray {
    public static void main(String[] args) {
        int [] arr={1,2,3,2,1,3,2,1,3};

        Set <Integer> arrset= new HashSet<>();

        for (int i = 0; i < arr.length; i++) {
            arrset.add(arr[i]);
        }

        int [] newarr= arrset.stream().mapToInt(Integer::intValue).toArray();
        Arrays.sort(newarr);

        System.out.println("2nd smallest element is "+newarr[1]);
    }
}
