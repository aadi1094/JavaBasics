package Arrays;

import java.util.Arrays;

public class IntroToArray {
    public static void main(String[] args) {
        int rollno1=21;
        int rollno2=10;

        // Array:  Collection of datatype
        //syntax of array
        //datatype[] arrayname = new datatype[size]
        int[] array                  =    new int[5];
        //this happens compile time       this happens runtime (dynamic memory allocation)

        // new is used to craete the object

        //datatype[] arrayname = {21,10} => For directly

        int[] arr  = {21,10,272};

        //1. int[]=> this datatype basically represent the what type of data stored in this array
        //2 . all the datatype in the array should be same

        int[] ros; //it is declaration, ros is getting defined in the stack
        ros=new int[5]; // initialization ,this is actually memory creation , here object is crreated in heap memory


        //1. array objects store in the heap
        //2. heap objects are not continuous
        //3. Dynamic memory allocation
        //4 . in java , may not be continuos (it depends on JVM)

        String[] str= new String[3];
        System.out.println(str[0]);

        int[] test = new int[5];

        test[0]=10;
        test[1]=20;
        test[0]=30;

        System.out.println(Arrays.toString(test));


        int[] arr1={10,20,30,40,50,60,70,80,90};

        for (int i = arr1.length-1; i >=0 ; i--) {
            System.out.println(arr1[i]);
        }

    }

}
