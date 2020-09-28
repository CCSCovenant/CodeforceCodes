import java.io.*;
import java.util.Scanner;
import java.lang.StringBuilder;
import java.util.StringTokenizer;

public class C {
    static BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st= new StringTokenizer(br.readLine());
    static OutputStream Output = new BufferedOutputStream (System.out);
    public static void main(String[] args) throws IOException {
        int n = sc.nextInt();
        if (n==1){
            System.out.println("! "+1);
            return;
        }
        long[] a = new long[n+1];
        int LastUnknow;
        Output.write(("? "+1+" "+2+"\n").getBytes());
        Output.flush();
        int c1 = sc.nextInt();
        Output.write(("? "+2+" "+1+"\n").getBytes());
        Output.flush();
        int c2 = sc.nextInt();
        if (c1 > c2){
            LastUnknow = 2;
            a[1] = c1;
        }else {
            LastUnknow = 1;
            a[2] = c2;
        }

        for (int i=3;i<n+1;i++){
            Output.write(("? "+LastUnknow+" "+i+"\n").getBytes());
            Output.flush();
             c1 = sc.nextInt();
            Output.write(("? "+i+" "+LastUnknow+"\n").getBytes());
            Output.flush();
            c2 = sc.nextInt();
            if (c1 > c2){
                a[LastUnknow] = c1;
                LastUnknow = i;
            }else {
                a[i] = c2;
            }
        }

        a[LastUnknow] = n;
        StringBuilder ans = new StringBuilder();
        ans.append("! ");
        for (int i=1;i<n+1;i++){
            ans.append(a[i]+" ");
        }
        System.out.println(ans);

    }
}
/**
 *
 *  i % j
 *  i
 *  = 0  i > j
 *
 *               a%b
 *               b%a
 *
 *
 *  4%5
 *
 *  4%2                 4%5
 *      4%2
 *
 *      2%4
 *                      5%4
 *                      1
 *      0<1                1
 *        1>2
 *
 *     0 1 2  3 4
 *     l   l
 *
 *           1 2 3 4 5
 *           l
 *               l l l
 *  2%4
 *
 *  4
 *
 *  5%4
 *
 *  1
 *
 *
 *  = i  i < j
 *
 *
 *      1 4 5 2 3
 *
 *
 *
 *
 * */