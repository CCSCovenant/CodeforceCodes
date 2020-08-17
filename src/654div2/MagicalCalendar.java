import java.util.Scanner;

public class MagicalCalendar {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int Case = sc.nextInt();
        for (int i=0;i<Case;i++){
            Solve(sc);
        }
    }
    private static void Solve(Scanner sc){
        long n = sc.nextInt();
        long r = sc.nextInt();
        long ans = 0;
        if (r==0){

        }else {
            if (r<n){
                ans = (r*r+r)/2;
            }else {
                ans = (n*n-n)/2+1;
            }
        }
        System.out.println(ans);
    }
}

/*     49-7 = 42/2 = 21
 *          x=1,y=n
 *   if(r>=n){
 *    shape = 2
 *   }
 *    n n-1
 *    n-1
 *    [1+(n-1)]* (n-1)/2
 *    n*(n-1)/2 +1
 *
 *     7
 *     6
 *     5
 *     4
 *     3
 *     2
 *     1
 *
 *
 *
 */
