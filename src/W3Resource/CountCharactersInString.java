package W3Resource;

import java.util.Scanner;

public class CountCharactersInString {
    public static void main(String[] args) {
        Scanner input= new Scanner(System.in);
        System.out.println("Enter the string : ");
        char[] characters= input.nextLine().toCharArray();
        int letter =0;
        int space=0;
        int number=0;

        for(int i=0 ; i<characters.length;i++){
            if ((characters[i] >= 65 && characters[i] <= 90) ||
                    (characters[i] >= 97 && characters[i] <= 122))  {
                    letter +=1;
            }
            if (characters[i] == ' '){
                space+=1;
            }

            if (characters[i]>=48 && characters[i]<=57){
                number+=1;
            }
        }
        System.out.println("Letters : "+letter);
        System.out.println("Space : "+space);
        System.out.println("Number : "+number);
        System.out.println("Others : "+(characters.length-(letter+space+number)));
    }
}
