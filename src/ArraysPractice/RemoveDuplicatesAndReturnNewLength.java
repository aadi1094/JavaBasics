package ArraysPractice;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class RemoveDuplicatesAndReturnNewLength {
    public static void main(String[] args) {
        int[]arr={10,10,20,30,10,50};

        Set<Integer> numberSet = Arrays.stream(arr)
                .boxed() // Converts int to Integer
                .collect(Collectors.toSet());

        System.out.println(numberSet.stream().count());;
    }
}
