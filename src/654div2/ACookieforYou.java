import java.util.Scanner;

public class ACookieforYou {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int Case = sc.nextInt();
        for (int i=0;i<Case;i++){
            Solve(sc);
        }
    }
    private static void Solve(Scanner sc){
        long a = sc.nextLong();
        long b = sc.nextLong();
        long n = sc.nextLong();
        long m = sc.nextLong();
        boolean flag = true;
        if (a+b>=m+n){
            if (a>b){
                if (m>b){
                    flag=false;
                 //   System.out.println("C");
                }
            }else {

                if (m>a){
                    flag=false;
              //      System.out.println("D");
                }
            }
        }else {
            flag=false;
        }
        if (flag){
            System.out.println("YES");
        }else {
            System.out.println("NO");
        }
    }
}
/***
 *   a>b
 *   m<=b
 *   n<=(a+b-m)
 *
 *   4 4
 *   m=5
 *   n=1
 *
 *
 *   a<=b
 *
 *
 *
 *
 *
 *
 *     v c
 *
 *     if(a+b>=m+n)
 *    {
 *
 *    }else{
 *
 *    }
 *
 *   v>c
 *   1
 *
 *
 *
 *
 *  1          1
 *    1     1
 *       1
 *     1    1
 *  1            1
 *
 *
 *
 * */