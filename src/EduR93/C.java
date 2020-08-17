import java.util.Scanner;

public class C {
    static Scanner sc = new Scanner(System.in);
    static String a;
    static long[] prefixsum;
    static int l;
    static long sum;
    static long counter;
    static long ans;
    static long[] Next;
    public static void main(String[] args){
        int n = sc.nextInt();
        for (int i=0;i<n;i++){
            Solve();
        }
    }
    private static void Solve(){
        l = sc.nextInt();
        a = sc.next();
        Next = new long[10];
        sum = 0;
        ans = 0;
        for (int i=0;i<l;i++){
            sum = sum+Character.getNumericValue(a.charAt(i));
            if (Character.getNumericValue(a.charAt(i))==1){
                ans++;
            }
            if (sum==i+1){
                ans+=counter;
                counter++;
            }


        }

        System.out.println(ans);
    }

}
/**
 *
 * n+n-1+n-2+n-3
 *  1
 * 920202
 *
 *  11111
 *
 *  1 2 0 1 1 2
 *
 *  1 1 1 1 1 2 0
 *  1 1 1
 *  1          1
 *  1+1+1      2
 *  1+2+3
 *
 *
 *  5
 *  6
 *
 *  +2
 *  +3 +1
 *
 *
 *         6
 *         0
 * 0 5 4 3 2
 * 6 0 0 0 0 5
 *
 * 1 1 0 1 1
 *
 * 1
 * 1
 *
 * 1 1
 * 1 1
 *
 * 2 2 2
 * 1 1 0
 *
 * 2 2 2 1
 * 1 1 0 1
 *
 * 2 2 2 1 1
 * 1 1 0 1 1
 *
 *
 *
 * -6
 * 6
 * */


/***
 *
 *
 * 111111
 * 020202
 * 003003
 *
 *
 *
 *
 *
 *
 *
 * */