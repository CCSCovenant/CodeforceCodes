import java.util.Scanner;

public class MagicalSticks {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int Case = sc.nextInt();
        for (int i=0;i<Case;i++){
            Solve(sc);
        }
    }
    private static void Solve(Scanner sc){
        int n = sc.nextInt();
        if (n%2==0){
            System.out.println(n/2);
        }else {
            System.out.println((n+1)/2);
        }
    }
}

/****
 *
 *
 *
 *  1 2 3
 *  1 2 3 4
 *
 *  1 2 3 4 5
 *
 *  1+4
 *  2+3
 *  5
 *
 *  1 2 3 4 5 6
 *  6   =>
 *  1+5  =>
 *  2+4   = >
 *
 *
 *
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