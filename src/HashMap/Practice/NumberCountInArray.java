package HashMap.Practice;

import java.util.HashMap;

public class NumberCountInArray {
    public static void main(String[] args){
        int[] arr={1,2,3,2,1,3,2,1,3,2,1};

        HashMap<Integer,Integer> map = new HashMap<>();

        for(int x: arr){
            map.put(x,map.getOrDefault(x,0)+1);
        }

        System.out.println(map);
    }
}
