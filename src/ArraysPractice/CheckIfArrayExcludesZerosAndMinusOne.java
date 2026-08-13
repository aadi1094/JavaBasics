package ArraysPractice;

public class CheckIfArrayExcludesZerosAndMinusOne {
    public static void main(String[] args) {
        int [] arr1 = {1,2,3,2,1,4,0,-1};
        int [] arr2 = {2,4,3,2,3,2,2};

        boolean result=false;

        for (int i = 0; i < arr2.length; i++) {
            if(arr2[i]==0 || arr1[i]==-1) {
                result = true;
            }
        }

        if(result){
            System.out.println("Array contains 0 or -1");
        }else{
            System.out.println("Array not contains 0 or -1");
        }
    }
}
