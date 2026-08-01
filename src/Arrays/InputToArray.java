package Arrays;

import java.util.Arrays;
import java.util.Scanner;

public class InputToArray {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int[] rollno= new int[4];
        rollno[0]=1;
        rollno[1]=2;
        rollno[2]=3;
        rollno[3]=4;

        //internally stored as [1,2,3,4]

        //input using the for loop :
        for(int i=0;i<rollno.length;i++){
            rollno[i]= sc.nextInt();
        }

        for(int i=0;i<rollno.length;i++){
            System.out.print(rollno[i] + " ") ;
        }

        for (int j : rollno) {
            System.out.print(j + " ");
        }

        System.out.println(Arrays.toString(rollno));

        //System.out.println(rollno[4]); => index out of bound error

        //Array of objects
        String[] str = new String[3];
        for (int i=0;i<str.length;i++){
            str[i]=sc.next();
        }

        System.out.println(Arrays.toString(str));
    }
}
