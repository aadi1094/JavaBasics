package CodingPractice;

public class CountVowelsInString {
    static void main(String[] args) {

        String s= "programming";

        int count=0;
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i)=='a' || s.charAt(i)=='e' || s.charAt(i)=='i' || s.charAt(i)=='o' || s.charAt(i)=='u'){
                count+=1;
            }
        }

        System.out.println("The vowel count in given string is : "+count);
    }
}
