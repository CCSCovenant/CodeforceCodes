import java.util.Scanner;

public class B {
    static Scanner sc = new Scanner(System.in);
    static StringBuilder ans = new StringBuilder();
    public static void main(String[] args){
        int t = sc.nextInt();
        for (int i=0;i<t;i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            int x = sc.nextInt();
            int y = sc.nextInt();
            int n = sc.nextInt();
            long res = Math.min(minpossible(a,b,x,y,n),minpossible(b,a,y,x,n));
            ans.append(res+"\n");
        }
        System.out.println(ans);
    }
    public static long minpossible(long a,long b, long x, long y,long n){
        if (n>(a-x)){
            n -= a-x;
            if (b-y<n){
                return x*y;
            }else {
                return  x*(b-n);
            }
        }else {
            return (a-n)*b;
        }
    }
}
