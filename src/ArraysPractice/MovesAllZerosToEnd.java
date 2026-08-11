package ArraysPractice;

import java.util.Arrays;

public class MovesAllZerosToEnd {


    public static void main(String[] args) {
        int [] arr={0,2,1,0,3,2,4,0,0,0,10,22};

        int count =0;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] !=0){
                int temp=arr[i];
                arr[i]=arr[count];
                arr[count]=temp;
                count++;
            }

        }

        System.out.println(Arrays.toString(arr));
    }


}
