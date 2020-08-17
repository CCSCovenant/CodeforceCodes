import java.util.Scanner;

public class RequiredRemainder {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int C = sc.nextInt();
        for (int i=0;i<C;i++){
            Solve(sc);
        }
    }
    private static void Solve(Scanner sc){
        int x = sc.nextInt();
        int y = sc.nextInt();
        int n = sc.nextInt();
        int ans = 0;
        n = n-y;
        ans = n-n%x+y;
        System.out.println(ans);

    }
}
/****
 *
 *
 *  k%x = y
 *  (k-y)%x ==0
 *
 *
 *
 * */