import java.util.Arrays;
import java.util.Scanner;

public class C {
    static Scanner sc;
    static int[] a;
    static int max;
    static int maxf;
    static StringBuilder ANS = new StringBuilder();
    public static void main(String args[]){
        sc = new Scanner(System.in);
        int n = sc.nextInt();

        for (int i=0;i<n;i++){
            Solve();
        }
        System.out.println(ANS);
    }
    private static void Solve(){
        int n = sc.nextInt();
        a = new int[n+1];
        max =0;
        maxf = 0;
        for (int i=0;i<n;i++){
            int k = sc.nextInt();
            a[k]++;
            max = Math.max(max,a[k]);
        }
        for (int i=0;i<=n;i++){
          if (a[i]==max){
              maxf++;
          }
        }
        int ans = (n-maxf)/(max-1)-1;
        ANS.append(ans+"\n");

    }


   /* private static boolean  Try(int interval){
        int tracker = a.length-1;
        for (int j=0;j<c.length;j += interval+1){
                c[j] = tracker;
                a[tracker]--;
                if (a[tracker]==0){
                    tracker --;
                }
            }
        for (int j=0;j<c.length;j += interval+1){
            int r = c[j];
            if (j+interval+1<c.length){
                r =  Math.min(c[j+interval+1],r);
            }
            for (int i=j+1;i<j+interval+1&&i<c.length;i++){

            }
        }

    }*/





}
/**
 *
 *
 *   ---456-456-45--46--
 *
 *    4   4   4
 *
 * */