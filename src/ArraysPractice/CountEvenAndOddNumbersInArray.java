package ArraysPractice;

public class CountEvenAndOddNumbersInArray {

    public static void main(String[] args) {

        int [] arr={1,2,3,4,5,6,67,4,3};
        int even=0;
        int odd=0;

        for (int i = 0; i < arr.length ; i++) {
            if(arr[i]%2==0){
                even+=1;
            }else{
                odd+=1;
            }
        }

        System.out.println("Even count in array is "+even);
        System.out.println("Odd count in array is "+odd);
    }
}
