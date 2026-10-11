package CodingPractice;

public class ReverseString {
    static void main(String[] args) {
        String s = "Hello";
        StringBuilder sb = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--) {
            sb.append(s.charAt(i));
        }
        System.out.println(sb.toString());

    }
}
