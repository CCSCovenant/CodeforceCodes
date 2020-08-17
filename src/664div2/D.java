import java.util.Arrays;
import java.util.Scanner;

public class D {
    static Scanner sc = new Scanner(System.in);
    static int n;
    static int m;
    static int d;
    static long a[];
    static long Ans;
    static long presuffix[];
    static long surfix[];

    public static void main(String[] args){
       n = sc.nextInt();
       d = sc.nextInt();
       m = sc.nextInt();
       a = new long[n];
       Ans = 0;
       for (int i=0;i<n;i++){
           a[i] = sc.nextInt();
       }
       Solve();
    }
    private static void Solve(){
        Arrays.sort(a);
        int MaxP = findBound();
        presuffix = new long[n+1];
        surfix = new long[n+1];
        surfix[n] = 0;
        for (int i=n-1;i>=MaxP;i--){
            surfix[i] = surfix[i+1]+a[i];
        }
        presuffix[MaxP] = 0;
        for (int i=MaxP-1;i>=0;i--){
            presuffix[i] = presuffix[i+1]+a[i];
        }

        for (int i=0;i<=MaxP;i++){
            int suf = n-(n-i+d)/(d+1);
            long tmp = presuffix[MaxP-i]+surfix[suf];
            Ans = Math.max(tmp,Ans);
        }
        System.out.println(Ans);
    }
    private static int findBound(){
        int lb =-1;
        int ub =n;
        while (ub-lb>1){
            int mid = (ub+lb)/2;
            if (a[mid]>m){
                ub = mid;
            }else {
                lb = mid;
            }
        }
        return ub;
    }
}
/***
 *
 *
 *
 * max min1 min2 .. mind
 *
 * max1 max2 max3 maxd MAX
 *
 *
 * MAXG
 *
 * minSafe1 minSafed+i
 *
 * maxsafe1 + maxsafe d+i
 *
 *
 *
 *
 *
 *
 * */