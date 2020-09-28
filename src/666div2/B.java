import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class B {
    static Scanner sc = new Scanner(System.in);
    static StringBuilder ans = new StringBuilder();
    static long delta;
    static int n;
    static long[] a;
    public static void main(String[] args) throws IOException{
        n = sc.nextInt();
        a = new long[n];
        for (int i=0;i<n;i++){
            a[i] = sc.nextLong();
        }
        Arrays.sort(a);
        Solve();
        System.out.println(ans);
    }
    private static void Solve() throws IOException{
        int i =0;
        delta = findDelta(0);
        while (true){
            i++;
            long tmp = findDelta(i);
            if (tmp>delta){
                break;
            }else {
                delta = Math.min(delta,tmp);
            }
        }
        ans.append(delta);
    }
    private static long findDelta(int x){
        long tmpDelta=0;
        for (int i=0;i<n;i++){
            tmpDelta+= Math.abs(Math.pow(x,i)-a[i]);
        }
        return tmpDelta;
    }
}
