import java.util.Scanner;

public class C {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args){
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] a = new int[n];
        int[] b = new int[m];
        int[] c = new int[n];
        for (int i=0;i<n;i++){
            a[i] =sc.nextInt();
        }
        for (int i=0;i<m;i++){
            b[i] =sc.nextInt();
        }
        int MaxCi=0;
        for (int i=0;i<n;i++){
            c[i] = a[i]&b[0];
            for (int j=1;j<m;j++){
                c[i] = Math.min(c[i],a[i]&b[j]);
            }
            MaxCi = Math.max(MaxCi,c[i]);
        }

        for (int i=0;i<n;i++){
            c[i] = (a[i]&b[0])|MaxCi;
            for (int j=1;j<m;j++){
                c[i] = Math.min(c[i],(a[i]&b[j])|MaxCi);
            }
        }

        int ans = c[0];
        for (int i=1;i<n;i++){
            ans = ans|c[i];
        }
        System.out.println(ans);
    }

}

/**
 *
 *  11001
 *
 *  100
 *   10
 *  100
 *  110
 *  101
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