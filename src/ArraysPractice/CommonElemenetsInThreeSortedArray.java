package ArraysPractice;

import java.util.ArrayList;

public class CommonElemenetsInThreeSortedArray {

    public static void main(String[] args) {
        int[] arr1= {1,2,3,4,5,6,7,8};
        int[] arr2={2,4,6,8,10};
        int[] arr3= {5,6,7,8,9};

        ArrayList <Integer> list= new ArrayList<>();

        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr2.length; j++) {

                if(arr1[i]==arr2[j]){
                    for (int k = 0; k < arr3.length; k++) {
                        if(arr2[j]==arr3[k]){
                            list.add(arr3[k]);
                        }
                    }
                }

            }
        }

        System.out.println(list);
    }
}
