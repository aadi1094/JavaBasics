package ArraysPractice;

import java.util.Arrays;

public class FindLengthOfLongestConsecutiveSequence {
    public static void main(String[] args) {
        int arr[]= {49,50,51,10,52,53,54,55, 1, 3, 200, 2, 4, 70, 5};

        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));

        //[1, 2, 3, 4, 5,10, 49, 50, 51, 52, 53, 54, 55, 70, 200]
        int currentLength = 1;
        int maxLength = 1;

        for (int i = 1; i < arr.length; i++) {

            if (arr[i] == arr[i - 1] + 1) {
                currentLength++;
            } else {
                currentLength = 1;
            }

            maxLength = Math.max(maxLength, currentLength);
        }

        System.out.println("Longest consecutive sequence length: " + maxLength);




        //[1,2,3,4,5] [10] [49,50,51,52,53,54,55] [70] [200]



    }
}
