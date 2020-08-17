import java.util.Scanner;

public class C {
    static Scanner sc = new Scanner(System.in);
    static long mod = 1000000007;
    public static void main(String[] args){
      Solve();
    }
    private static void Solve(){
        int n = sc.nextInt();
        long ans = fac(n);
        long bad = pow2(n-1);
        ans -= bad;
        if (ans<0){
            ans+=mod;
        }
        System.out.println(ans);
    }
    private static long fac(int i){
        long f = 1;
        for (long j=1;j<=i;j++){
            f = j*f%mod;
        }
        return f;
    }
    private static long pow2(int n){
        if (n==0){
            return 1;
        }
        if (n%2==1){
            return pow2(n-1)*2%mod;
        }else {
            long tmp = pow2(n/2);
            return tmp*tmp%mod;
        }

    }
}

/***
 *
 *
 *
 *
 *
 *
 *
 * 3 1 4 2
 *
 * 3 - 4
 * 1 - 3
 * 1 - 2
 * 2 - 3
 *
 * 1 2 3 4
 * 1-2
 * 2-3
 * 3-4
 *
 * 1 3 2 4
 *
 * 1-3
 * 3-4
 * 2-3
 * 2-4
 *
 * 4 3 2 1
 *
 * 1 4 3 2
 * 1-2
 * 3-2
 * 3-4
 * 2-4
 * 1 2 3 4
 *
 *
 *
 * 1 2 4 3
 * 1-2
 *
 * 1
 *
 *
 *
 *
 *
 * */