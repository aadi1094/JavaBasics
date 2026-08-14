package ArraysPractice;

import java.util.Arrays;

public class MoveAllZerosToStart {
    public static void main(String[] args) {
        int [] arr={0,2,1,0,3,2,4,0,0,0,10,22};

        for (int i = 0; i < arr.length; i++) {
            if(arr[i]!=0){
                for (int j = i+1; j < arr.length; j++) {
                    if(arr[j] ==0){
                        int temp=arr[i];
                        arr[i]=arr[j];
                        arr[j]=temp;
                    }
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}
