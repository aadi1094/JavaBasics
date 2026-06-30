package W3Resource;

public class UniqueThreeDigitNumbers {
    public static void main(String[] args) {
        int count=0;
        for (int i=1;i<=4;i++){
            for (int j =1;j<=4;j++){
                for (int k=1;k<=4;k++){
                    if (i!=j && i!=k && j!=k){
                        count+=1;
                        System.out.println(i+""+j+""+k);
                    }
                }
            }
        }
        System.out.println(count);
    }
}
