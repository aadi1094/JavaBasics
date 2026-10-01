package Strings.Practice;

import java.util.Scanner;

public class WordCountParagraphProgram {

    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter any paragraph: ");
        String input = sc.nextLine();

        String[] words = input.split(" ");

        System.out.println("Enter the target word : ");
        String word = sc.next();

        int count=0;

        for (int i = 0; i < words.length; i++) {
            if(words[i].equalsIgnoreCase(word)){
                count+=1;
            }
        }

        if(count>0){
            System.out.println("The word "+word+" appears "+count+" times.");
        }else{
            System.out.println("Word not found in Paragraph");
        }
    }
}

//Enter any paragraph:
//I m happy guy , also called happy prince.
//Enter the target word :
//happy
//The word happy appears 2 times.