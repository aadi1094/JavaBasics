package InfosysPrep.Day05;

import java.util.HashMap;
import java.util.Scanner;

//You get N numbers. Print YES if some value appears more than once, else NO.
public class Duplicate {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] nums= new int[n];

        for (int i = 0; i < n; i++) {
            nums[i]=sc.nextInt();
        }

        HashMap <Integer,Integer> hash= new HashMap<>();

        for(int x:nums){
            if(hash.containsKey(x)){
                hash.put(x,hash.get(x)+1);
            }else{
                hash.put(x,1);
            }
        }

        for (int key : hash.keySet()) {
            if (hash.get(key) > 1) {
                System.out.println("YES");
                return;
            }
        }

        System.out.println("NO");
    }
}
