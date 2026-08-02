package ArraysPractice;

import java.util.Scanner;

public class CheckIfArrayContainsSpecificValue {
    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        int [] arr={21,352,321,612,123};

        System.out.println("Enter the specifc value ");
        int spec_value= sc.nextInt();;

        boolean found = false;
        for(int j = 0; j < arr.length; j++){
            if(arr[j]==spec_value){
                System.out.println("Contains the spec value at index : "+j);
                found=true;
                break;
            }
        }
        if(!found){
            System.out.println("Not contains");
        }
    }
}
