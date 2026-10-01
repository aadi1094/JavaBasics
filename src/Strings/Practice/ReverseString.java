package Strings.Practice;

import java.util.Scanner;

public class ReverseString {

    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the any String : ");
        String original = sc.next();

        String reverse = "";

        for (int i = original.length()-1; i >=0 ; i--) {
            reverse += original.charAt(i);
        }

        System.out.println("Original String : "+original);
        System.out.println("Reverse String : "+reverse);
    }
}

//Enter the any String :
//Aditya
//Original String : Aditya
//Reverse String : aytidA