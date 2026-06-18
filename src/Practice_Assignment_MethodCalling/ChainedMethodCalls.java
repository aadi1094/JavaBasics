package Practice_Assignment_MethodCalling;

public class ChainedMethodCalls {
    int add(int x,int y){
        return x+y;
    }
    int square(int x){
        return x*x;
    }
    boolean isEven(int x){
        if (x%2==0){
            return true;
        }else{
            return false;
        }
    }

    public static void main(String[] args) {
        ChainedMethodCalls obj = new ChainedMethodCalls();
        int result=obj.add(3,5);
        int res=obj.square(result);
        boolean final_res=obj.isEven(res);
        System.out.println(final_res);
    }
}
