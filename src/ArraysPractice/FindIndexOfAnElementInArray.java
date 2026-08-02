package ArraysPractice;

import java.util.Scanner;

public class FindIndexOfAnElementInArray {
    public static void main(String[] args) {

        Scanner sc=  new Scanner(System.in);
        System.out.println("Enter the element");
        int ele=sc.nextInt();
        int [] arr={1,2,34,32,21};

        boolean found = false;
        for(int j = 0; j < arr.length; j++){
            if(arr[j]==ele){
                System.out.println("find the elem at index : "+j);
                found=true;
                break;
            }
        }
        if(!found){
            System.out.println("Not contains given elements");
        }
    }
}
