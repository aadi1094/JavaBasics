package ArraysPractice;

public class CheckIfTotalOfTensEqualsThirty {
    public static void main(String[] args) {
        int [] arr = {10,10,2,3,4,10,21};

        int count=0;

        for (int i = 0; i < arr.length; i++) {
            if(arr[i]==10 && count<31){
                count+=10;
            }
        }


        boolean res=false;
        if(count==30){
            res=true;
        }

        System.out.println(res);
    }
}
