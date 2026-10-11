package CodingPractice;

public class CountVowelsInString {
    static void main(String[] args) {

        String s= "prOgramming";

        int count=0;

        for (int i = 0; i < s.length(); i++) {
            char ch = Character.toLowerCase(s.charAt(i));
            if(ch=='a' || ch=='e' || ch=='i' ||ch=='o' || ch=='u'){
                count+=1;
            }
        }

        System.out.println("The vowel count in given string is : "+count);
    }
}
