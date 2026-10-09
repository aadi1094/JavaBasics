package CodingPractice;

public class CheckNumberisPalindromeOrNot {
    static void main(String[] args) {

        CheckNumberisPalindromeOrNot obj = new CheckNumberisPalindromeOrNot();
        System.out.println("isNumberPalindrome : "+obj.isPalindrome(121));

    }


    boolean isPalindrome(int number){
        int originalNumber = number;
        int rev=0;

        while(number>0){
            int digit = number%10;
            rev= rev*10 + digit;
            number/=10;
        }
        System.out.println(rev);
        if(originalNumber==rev){
            return true;
        }else{
            return false;
        }
    }
}
