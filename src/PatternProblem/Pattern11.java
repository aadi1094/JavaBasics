package PatternProblem;

public class Pattern11 {
    public static void main(String[] args) {
        int n =5;

        for (int row = 1; row <= 2*n; row++) {

            int totalcol=0;
            if(row>n){
                totalcol=row-n;
            }else{
                totalcol=n-row+1;
            }

            int totalspace=0;
            if (row>n) {
                totalspace=2*n-row;
            }else{
                totalspace=row-1;
            }

            for (int col = 1; col <=totalspace ; col++) {
                System.out.print(" ");
            }

            for (int col =0 ; col <totalcol ; col++) {
                System.out.print(" *");
            }

            System.out.println();
        }
    }
}

// * * * * *
//  * * * *
//   * * *
//    * *
//     *
//     *
//    * *
//   * * *
//  * * * *
// * * * * *