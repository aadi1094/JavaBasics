
package InfosysPrep.Day03;

import java.util.Scanner;

public class LongestRunOfEqualNeighbour {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        if (n == 0) {
            System.out.println(0);
            return;
        }

        int count = 1;
        int max = 1;

        for (int i = 1; i < n; i++) {
            if (arr[i] == arr[i - 1]) {
                count++;
            } else {
                count = 1;
            }

            max = Math.max(max, count);
        }

        System.out.println(max);
        sc.close();
    }
}
