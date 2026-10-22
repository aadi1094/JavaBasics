
package InfosysPrep.Day03;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Leaders {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int leader = arr[n - 1];
        ArrayList<Integer> new_arr = new ArrayList<>();
        new_arr.add(leader);

        for (int i = n - 2; i >= 0; i--) {
            if (arr[i] >= leader) {
                leader = arr[i];
                new_arr.add(leader);
            }
        }

        Collections.reverse(new_arr);

        for (int i = 0; i < new_arr.size(); i++) {
            System.out.print(new_arr.get(i) + " ");
        }

        sc.close();
    }
}
