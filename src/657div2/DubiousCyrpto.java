import java.util.Scanner;

public class DubiousCyrpto {
    static Scanner sc;
    static long l;
    static long r;
    static long m;
    static long diff;
    static long a;
    static long b;
    static long c;
    public static void main(String args[]){
        sc = new Scanner(System.in);
        int Case = sc.nextInt();
        for (int i=0;i<Case;i++){
            Solve();
        }
    }
    private static void Solve() {
         l = sc.nextInt();
         r = sc.nextInt();
         m = sc.nextLong();
            diff = r-l;
        for (long i=l;i<r+1;i++){
            if (checka(i)){
                a = i;
                break;
            }
        }
        // n*a+b-c = m%a
        long re = m%a;
         if ((a-re)<=diff) {
            // System.out.println("Fork1");
            c=r;
            b=r-(a-re);
        }else if (re<=diff){
           //  System.out.println("Fork2");
             b=r;
             c=r-re;
         }
        System.out.println(a+" "+b+" "+c);
    }
    private static boolean checka(long i){
        long re = m%i;
        if (i>m){
            if ((i-re)<=diff){
                return true;
            }else {
                return false;
            }
        }else {

            if (re<=diff||(i-re)<=diff){
                return true;
            }else {
                return false;
            }

        }

    }

}
