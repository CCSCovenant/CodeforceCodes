import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Unmerge {
    static Scanner sc;
    static int[] a;
    static ArrayList<Integer> Parts;
    static int counter;
    static int Max;
    static boolean dp[][];
    public static void main(String args[]){
        sc = new Scanner(System.in);
        int Case = sc.nextInt();
        for (int i=0;i<Case;i++){
            Solve();
        }
    }
    private static void Solve(){
        int n = sc.nextInt()*2;
       a = new int[n];
       for (int i=0;i<n;i++){
            a[i] = sc.nextInt();
       }
       Parts = new ArrayList<>();
       counter = 1;
       Max = a[0];

        for (int i=1;i<n;i++){
          if (a[i]>Max){
              Parts.add(i);
              Max=a[i];

          }
       }
        if (Parts.size()>0){
        Parts.add(n-Parts.get(Parts.size()-1));
       for (int i = Parts.size()-2;i>0;i--){
           Parts.set(i,Parts.get(i)-Parts.get(i-1));
       }}else {
            Parts.add(n);
        }

        dp = new boolean[Parts.size()+1][n/2+1];
        for (int i=0;i<Parts.size();i++){
           dp[i][0]=true;
        }
        for (int i=1;i<=Parts.size();i++){
           for (int j=1;j<=n/2;j++){
                if (dp[i-1][j]==true){
                    dp[i][j]=true;
                }else {
                    if (Parts.get(i-1)>j){
                        dp[i][j]=false;
                    }else {
                        dp[i][j]=dp[i-1][j-Parts.get(i-1)];
                    }
                }
           }
       }
        if (dp[Parts.size()][n/2]==true){
            System.out.println("YES");
        }else {
            System.out.println("NO");
        }
    }


}

/***
 *
 *
 *
 *  a b c d e f g
 *
 *
 *  a b      c
 *  6 1 8 4  3 2 5 7
 *
 *  3 1 2 4
 *
 *   [4 1] [3 2]
 *
 *   3 2 4 1
 *  1 4 6    2 3 5
 *
 *
 *
 *
 *   6 1 3
 *   7 4 5
 *   8 2
 *   4 3 2
 *   5 1
 *   11 9
 *   12 8 6
 *   10 7
 *
 *   3 2
 *   6 1 5
 *   7
 *   8 4
 *
 *   1 2 3 4 5 6
 *
 *   1+2  3 4 5 6
 *
 *   [n-a-b-c-d-f] == 0
 *
 *
 *
 *     6
 *
 *   2
 *   3
 *   4
 *   5
 *   6
 *
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