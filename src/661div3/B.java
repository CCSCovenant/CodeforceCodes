import java.util.Arrays;
import java.util.Scanner;

public class B {
    static Scanner sc;
    static int[] a;
    static int[] b;
    static long move;
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
        b = new int[n];

        move = 0;
        for (int i=0;i<n;i++){
            a[i] = sc.nextInt();
        }
        for (int i=0;i<n;i++){
            b[i] = sc.nextInt();
        }
        int amin = a[0];
        int bmin = b[0];
        for (int i=0;i<n;i++){
            amin = Math.min(amin,a[i]);
            bmin = Math.min(bmin,b[i]);
        }
        for (int i=0;i<n;i++){
            b[i] = b[i]-bmin;
            a[i] = a[i]-amin;
            move += Math.max(a[i],b[i]);
        }
        System.out.println(move);
    }
}
