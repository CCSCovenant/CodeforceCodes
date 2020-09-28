import java.io.IOException;
import java.util.Scanner;

public class DN2 {
    static Scanner sc = new Scanner(System.in);
    static StringBuilder ans = new StringBuilder();
    static long[] a;
    static long[] tag;
    static long[] seg;
    public static void main(String[] args) throws IOException {
        int n = sc.nextInt();
        a = new long[n];
        seg = new long[4*n];
        tag = new long[4*n];
        for (int i=0;i<n;i++){
            a[i] = sc.nextInt();
        }

        long delta = a[0];
        for (int i=1;i<n;i++){
            if (a[i]-a[i-1]>0){
                delta+=a[i]-a[i-1];
            }
        }
        ans.append((int)Math.ceil(((double)delta)/2)+"\n");
        int q = sc.nextInt();
        for (int i=0;i<q;i++){
            int l = sc.nextInt();
            int r = sc.nextInt();
            int c = sc.nextInt();
            for (int j = l-1;j<r;j++){
                a[j] += c;
            }
            delta = a[0];
            for (int j=1;j<n;j++){
                if (a[j]-a[j-1]>0){
                    delta += a[j]-a[j-1];
                }
            }
            ans.append((int)Math.ceil(((double)delta)/2)+"\n");
        }
        System.out.println(ans);

    }
}
