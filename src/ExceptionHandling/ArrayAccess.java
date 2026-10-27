package ExceptionHandling;

public class ArrayAccess {
    public static void main(String[] args){
        int[] arr={1,3,4};

        try{
            int result=arr[-1];
            System.out.println("Result is"+result);
        }catch(ArrayIndexOutOfBoundsException e){
            System.out.println(e.getMessage());
        }
    }
}
