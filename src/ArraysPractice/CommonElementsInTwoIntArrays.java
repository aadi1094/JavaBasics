package ArraysPractice;

import java.util.HashSet;
import java.util.Set;

public class CommonElementsInTwoIntArrays {
    public static void main(String[] args) {
        int[] arr1={1,2,3,4,5,6,6,7};
        int[] arr2={2,43,2,4,5,6,75,4,3,4};


        Set <Integer> inte = new HashSet<>();
        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr2.length ; j++) {
                if(arr1[i]==arr2[j]){
                   inte.add(arr1[i]);
                }
            }

        }

        System.out.println("Common elements are "+inte);
    }
}
