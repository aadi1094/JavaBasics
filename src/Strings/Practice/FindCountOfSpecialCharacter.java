package Strings.Practice;

public class FindCountOfSpecialCharacter {
    static void main(String[] args) {

        String s = "abc%$javaPROGRAMMING123#@";

        int lowercaseCount=0;
        int uppercaseCount=0;
        int numberCount=0;
        int SpecialCount=0;

        for (int i = 0; i < s.length() ; i++) {
            if (s.charAt(i)== '%'){
                System.out.println("% found at index "+i);
            }
        }

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) >= 65 && s.charAt(i) <=90){
                uppercaseCount = uppercaseCount+1;
            } else if (s.charAt(i) >= 97 && s.charAt(i) <=122) {
                lowercaseCount = lowercaseCount+1;
            } else if(s.charAt(i) >= 48 && s.charAt(i) <=57){
                numberCount=numberCount+1;
            }else{
                SpecialCount=SpecialCount+1;
            }
        }

        System.out.println("Upper Case Count in String is "+uppercaseCount);
        System.out.println("Lower Case Count in String is "+lowercaseCount);
        System.out.println("Number Case Count in String is "+numberCount);
        System.out.println("Special Case Count in String is "+SpecialCount);
    }
}
