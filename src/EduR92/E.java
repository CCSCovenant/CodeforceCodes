import java.util.Scanner;

public class E {
    static Scanner sc;
    static long m;
    static long d;
    static long w;
    static long counter;
    public static void main(String[] args){
        sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i=0;i<n;i++){
            Solve();
        }
    }
    private static void Solve(){
        m = sc.nextInt();
        d = sc.nextInt();
        w = sc.nextInt();
        long gcd = findgcd(Math.max(w,d-1),Math.min(w,d-1));

        long u = w/gcd;
        counter = 0;
        long t =Math.min(m,d);
      //  System.out.println("u:"+u+" t:"+t+" ");
        long r =(t%u)*(t/u);
        counter = (1+(t/u)-1)*(t/u-1)*u/2+r;
        System.out.println(counter);
    }
    private static long findgcd(long g,long l){
        if (l==0){
            return g;
        }
        long R = g%l;
        if (R!=0){
            return findgcd(Math.max(l,R),Math.min(l,R));
        }else {
            return l;
        }
    }
}

/****
 *
 *
 * 1 2 3 4 5 6
 *   1 1 2 2 3
 * 2 2 1 1
 * 1 2 3 4 5 6 7
 * 3 2 2 1 1
 *
 *
 *
 *
 *
 *
 * */