package HashMap.Practice;

import java.util.HashMap;
import java.util.Scanner;

public class CharCount {
    public static void main(String[] args){
        Scanner sc= new Scanner(System.in);
        String x= sc.next();

        HashMap<Character,Integer> map= new HashMap<>();

        for(char c : x.toCharArray()){
            map.put(c, map.getOrDefault(c,0)+1);
        }

        System.out.println(map);
    }
}
