package ArraysPractice;

public class MinNumberInArray {
    public static void main(String[] args) {
        int arr[]={223,32,42,212,422};

        MinNumberInArray obj = new MinNumberInArray();
        System.out.println("Min Number is "+obj.minNumber(arr));
    }

    int minNumber(int arr[]) {
        int min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
        }
        return min;
    }
}
