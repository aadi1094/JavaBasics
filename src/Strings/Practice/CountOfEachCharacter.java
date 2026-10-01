package Strings.Practice;

import java.util.Scanner;

public class CountOfEachCharacter {
    static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter any string : ");
        String input = sc.next();

        int[] arr= new int[256];

        for (int i = 0; i < input.length(); i++) {
            char c= input.charAt(i);
            arr[c]=arr[c]+1;

        }

        for (int i = 0; i < arr.length; i++) {
            if(arr[i]>0){
                System.out.println("'" + (char) i + "': " +arr[i]);
            }
        }


    }
}
