package ArraysPractice;

public class MaxNumberInArray {
    public static void main(String[] args) {
        int arr[]={-2,421,2,3,7,2,31};

        MaxNumberInArray obj= new MaxNumberInArray();
        System.out.println(obj.maxNumber(arr));


    }

    int maxNumber(int arr[]){
        int max=0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i]>max){
                max=arr[i];
            }
        }
        return max;
    }
}
