package EduR88;

import java.util.Scanner;

public class NewTheatreSquare {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int Case = sc.nextInt();
        for (int i=0;i<Case;i++){
            Solve(sc);
        }
    }
    private static void Solve(Scanner sc){
        int sizeN = sc.nextInt();
        int sizeM = sc.nextInt();
        int Price1x1 = sc.nextInt();
        int Price1x2 = sc.nextInt();
        int whitecount = 0;
        int FPrice = 0;
        int[][] Theatre = new int[sizeN][sizeM];
        for (int i=0;i<sizeN;i++){
            String line = sc.next();
            for (int j=0;j<sizeM;j++){
                if (line.charAt(j)=='.'){
                    Theatre[i][j]=0;
                    whitecount++;
                }else {
                    Theatre[i][j]=1;
                }
            }
        }
        if (Price1x1<(Price1x2/2.0)){
            FPrice = Price1x1*whitecount;
        }else {
            int OneByOneCount =0;
            int OneByTwoCount =0;
            int wc = 0;
            for (int i=0;i<sizeN;i++){

                for (int j=0;j<sizeM;j++){
                    if (Theatre[i][j]==0){
                        wc++;
                    }else {
                        OneByTwoCount += wc/2;
                        OneByOneCount += wc%2;
                        wc =0;
                    }
                }
                OneByTwoCount += wc/2;
                OneByOneCount += wc%2;
                wc = 0;
            }
            FPrice = OneByOneCount*Price1x1+OneByTwoCount*Price1x2;
        }
        System.out.println(FPrice);
    }
}
