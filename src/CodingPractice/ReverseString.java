package CodingPractice;

public class ReverseString {
    static void main(String[] args) {
        String s = "Hello";
        String reversedString = "";

        for (int i = s.length()-1; i >=0; i--) {
            reversedString+=s.charAt(i);
        }

        System.out.println("Reverse String is : "+reversedString);
    }
}
