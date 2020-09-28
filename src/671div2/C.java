import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class C {
    static Scanner sc = new Scanner(System.in);
    static StringBuilder output = new StringBuilder();
    public static void main(String[] args) throws IOException {
        int t = sc.nextInt();
        while (t-- >0){
            int ans = 0;
            boolean inif = false;
            boolean allinf = true;
            int n = sc.nextInt();
            int x = sc.nextInt();
            int[] a = new int[n];
            long sum = 0;
            for (int i=0;i<n;i++){
                a[i] = sc.nextInt();
                sum += a[i];
                if (a[i]!=x){
                    ans = 1;
                    allinf = false;
                }else {
                    inif = true;
                }
            }
            if (allinf){
                output.append(0+"\n");
            }else {
                ans = 2;
                if (inif){
                    ans = 1;
                }
                if (sum%n==0){
                    if (sum==n*x){
                        ans = 1;
                    }
                }
                output.append(ans+"\n");
            }
        }
        System.out.println(output);
    }
}
// r1 = x;
// r1 = avg
//
/****
 *
 *  x = avg            1
 *  x = !avg           2
 *
 *  (int) avg != avg
 *
 *
 *
 *
 *
 * */