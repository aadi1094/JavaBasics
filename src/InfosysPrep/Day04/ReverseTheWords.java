
package InfosysPrep.Day04;

import java.util.Scanner;

public class ReverseTheWords {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] w = sc.nextLine().trim().split("\\s+");
        StringBuilder s = new StringBuilder();

        for (int i = w.length - 1; i >= 0; i--) {
            s.append(w[i]).append(" ");
        }

        System.out.println(s.toString().trim());
        sc.close();
    }
}
