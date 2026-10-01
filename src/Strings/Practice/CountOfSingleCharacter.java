package Strings.Practice;

import java.util.Scanner;

public class CountOfSingleCharacter {
    static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter any string : ");
        String input = sc.next();

        System.out.println("Enter the target character : ");
        char c= sc.next().charAt(0);

        int count=0;
        for (int i = 0; i < input.length() ; i++) {
            if(input.charAt(i) == c){
                count+=1;
            }
        }

        if(count>0){
            System.out.println("The character "+c+" appears "+count+" times.");
        }else{
            System.out.println("Character not found in String");
        }
    }
}
