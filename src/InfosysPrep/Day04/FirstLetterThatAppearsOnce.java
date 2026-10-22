
package InfosysPrep.Day04;

import java.util.Scanner;

public class FirstLetterThatAppearsOnce {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.next();
        int result = -1;

        for (int i = 0; i < s.length(); i++) {
            boolean unique = true;

            for (int j = 0; j < s.length(); j++) {
                if (i != j && s.charAt(i) == s.charAt(j)) {
                    unique = false;
                    break;
                }
            }

            if (unique) {
                result = i;
                break;
            }
        }

        System.out.println(result);
        sc.close();
    }
}
