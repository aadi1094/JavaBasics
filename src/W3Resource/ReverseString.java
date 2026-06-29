package W3Resource;

import java.util.Scanner;

public class ReverseString {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter any string");
        char[] characters = input.nextLine().toCharArray();

        for (int i=characters.length-1;i>=0;i--){
            System.out.print(characters[i]);
        }

    }
}
