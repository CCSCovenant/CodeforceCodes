import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class C {
    static Scanner sc;
    static int[] a;
    static boolean[] used;
    static int[] res;
    public static void main(String[] args){
        sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i=0;i<n;i++){
            Solve();
        }
    }
    private static void Solve(){
        int n = sc.nextInt();
        a = new int[n];
        for (int i=0;i<n;i++){
            a[i] = sc.nextInt();
        }
        used = new boolean[n];
        Arrays.sort(a);
        int Maxsum;
        if (n>1){
             Maxsum = a[n-1]+a[n-2];
        }else {
             Maxsum = a[n-1];
        }
        res = new int[Maxsum+1];
        for (int i=1;i<=Maxsum;i++){
            clearused();
            for (int j=0;j<n;j++){
                if (used[j]==false){
                            used[j] = true;
                        if (find(i-a[j])==-1){
                            used[j] = false;
                        }else {
                            res[i]++;
                    }
                }
           }
        }
        int Max = res[0];
       // System.out.println("Res");
        for (int i=0;i<res.length;i++){
            Max = Math.max(res[i],Max);
        }
        //System.out.println();
        System.out.println(Max);
    }
    private static int find(int target){
        for (int i=0;i<a.length;i++){
            if (a[i]==target&&used[i]==false){
                used[i] = true;
                return a[i];
            }
        }
        return -1;
    }
    private static void clearused(){
        for (int i=0;i<used.length;i++){
            used[i]=false;
        }
    }
}
/***
 *
 *  111111111111111111
 *  12345678
 *  11112222
 *  50*250*1000
 *
 *
 *
 *
 *
 * */