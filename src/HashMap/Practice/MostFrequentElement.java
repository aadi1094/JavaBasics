package HashMap.Practice;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MostFrequentElement {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i]=sc.nextInt();
        }

        HashMap<Integer,Integer> count = new HashMap<>();

        for(int x: arr){
            count.put(x,count.getOrDefault(x,0)+1);
        }

        int freq=0;
        for(Map.Entry<Integer,Integer> e: count.entrySet()){
            freq++;
        }

        System.out.println(freq);
    }
}
