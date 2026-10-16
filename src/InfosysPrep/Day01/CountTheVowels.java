package InfosysPrep.Day01;

import java.util.Scanner;

public class CountTheVowels {
    public static void main(String[] args){
        Scanner sc= new Scanner(System.in);
        String s= sc.next();

        int count=0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c=='a' || c=='e' || c=='i' || c=='o' || c=='u'){
                count+=1;
            }
        }
        System.out.println(count);
    }
}
