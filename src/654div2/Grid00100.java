import java.util.Scanner;

public class Grid00100 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int Case = sc.nextInt();
        for (int i=0;i<Case;i++){
            Solve(sc);
        }
    }
    private static void Solve(Scanner sc){
        int n = sc.nextInt();
        int k = sc.nextInt();
        int c = 0;
        int[][] A= new int[n][n];
        int j=0;
        int max =0;
        int min =0;
        boolean flag = true;
        int x;
        int y;
        if (k!=0){
             while (flag){
             j++;
             x=j;
             y=0;
            for (int i=0;i<n;i++){
                max = j;
                if (x>=n){
                    x=0;
                }
                if (y>=n){
                    y=0;
                }
                A[x][y]=1;
                x++;
                y++;

                c++;
                if (c==k){
                    flag=false;
                    if (i==(n-1)){
                        min = j;
                    }else {
                        min = j-1;
                    }
                    break;
                }

            }


            }
        }else {
            max=0;
            min=0;
        }
        int D = max-min;
        System.out.println(D+D);
        for (int i=0;i<n;i++){
            for (int z=0;z<n;z++){
                System.out.print(A[i][z]);
            }
            System.out.println();
        }
    }
}
/***
 *
 *   [1][1][1][]]
 *   [][1][1][1][]
 *   [][][1][1][1]
 *   [1][][][1][1]
 *   [1][1][][][1]
 *
 *
 *
 *
 *
 *
 *
 *
 *
 * */