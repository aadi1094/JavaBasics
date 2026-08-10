package ArraysPractice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class ConvertArraylistToArray {
    public static void main(String[] args) {
        ArrayList<Integer> arrayList=new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter how many elements you want to insert ; ");
        int n = sc.nextInt();
        for (int i = 0; i < n ; i++) {
            int x=sc.nextInt();
            arrayList.add(x);
        }
        System.out.println("arraylist is "+arrayList);


        int[] array= arrayList.stream().mapToInt(Integer::intValue).toArray();

        System.out.println(Arrays.toString(array));
    }
}
