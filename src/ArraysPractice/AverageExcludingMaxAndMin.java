package ArraysPractice;

import java.util.ArrayList;
import java.util.Arrays;

public class AverageExcludingMaxAndMin {
    public static void main(String[] args) {
        int[] arr = {1,1,2,3,5,10,10};
        Arrays.sort(arr);

        ArrayList<Integer> list= new ArrayList<>();

        int min=arr[0];
        int max= arr[arr.length-1];
        int n=arr.length;

        for (int i = 0; i < arr.length ; i++) {
            if (arr[i]!= min && arr[i]!=max){
                list.add(arr[i]);
            }
        }

        System.out.println(list);
        int array[]=list.stream().mapToInt(Integer::intValue).toArray();


        double count =0;
        for (int i = 0; i < array.length; i++) {

            count = count + array[i];
        }

//        System.out.println(Arrays.toString(array));
        System.out.println(count);

        double result = (count/ array.length);
        System.out.println("Average is "+result);

    }
}
