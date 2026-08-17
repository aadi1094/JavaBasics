package PatternProblem;

public class Pattern10 {
    public static void main(String[] args) {
        int n =5;

        for (int row = 0; row < 2*n; row++) {

            int totalcol= 0;
            if(row>n){
                totalcol=2*n-row;
            }else{
                totalcol=row;
            }
            for (int col = 0; col < totalcol ; col++) {
                System.out.print("* ");
            }
            System.out.println();
        }

    }
}

//*
//* *
//* * *
//* * * *
//* * * * *
//* * * *
//* * *
//* *
//*