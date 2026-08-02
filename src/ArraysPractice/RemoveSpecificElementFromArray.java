package ArraysPractice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RemoveSpecificElementFromArray {
    public static void main(String[] args) {
        String[] array = {"Apple", "Banana", "Cherry"};

        List<String> list = new ArrayList<>(Arrays.asList(array));


        list.remove("Banana"); // Removes by value
        // list.remove(1);     // Alternatively, removes by index


        array = list.toArray(new String[0]);

        System.out.println(Arrays.toString(array)); // [Apple, Cherry]
    }
}

