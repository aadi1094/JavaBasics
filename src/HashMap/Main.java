package HashMap;

//A HashMap in Java is a hash table-based data structure in the java.util package that stores data as key-value pairs.
// It implements the Map interface and provides average constant-time performance—O(1)—for basic operations like
// inserting, retrieving, and deleting elements

import java.util.HashMap;

public class Main {
    public static void main(String[] args){

        HashMap<String,Integer> map = new HashMap<>();

        // 1. Add key-value pairs using put()
        map.put("Aditya",90);
        map.put("Mayank",99);
        map.put("Yash",101);

//        System.out.println(map);
        // 3. Check if a key exists using containsKey()
        if(map.containsKey("Mayank")){
            map.replace("Mayank",102);
        }

        // 2. Access a value using get()
        System.out.println(map.get("Mayank"));

        // 4. Remove an entry using remove()
        map.remove("Aditya");
    }
}
