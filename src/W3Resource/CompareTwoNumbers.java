package W3Resource;

import java.util.Scanner;

public class CompareTwoNumbers {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the 1st number : ");
        int x= input.nextInt();
        System.out.println("Enter the 2ndt number : ");
        int y = input.nextInt();

        if (x==y){
            System.out.println(+x+"=="+y);
        }
        if (x!=y){
            System.out.println(+x+"!="+y);
        }
        if (x>=y){
            System.out.println(+x+">="+y);
        }
        if (x<=y){
            System.out.println(+x+"<="+y);
        }
        if (x<y){
            System.out.println(+x+"<"+y);
        }
        if (x>y){
            System.out.println(+x+">"+y);
        }





    }
}
