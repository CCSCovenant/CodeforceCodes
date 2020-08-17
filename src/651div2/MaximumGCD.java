import java.util.Scanner;

public class MaximumGCD {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int C = sc.nextInt();
        for (int i=0;i<C;i++) {
            Max(sc);
        }
    }
    private static void Max(Scanner sc){
        int n = sc.nextInt();
        if (n%2==1){
            System.out.println((n-1)/2);
        }else {
            System.out.println(n/2);
        }
    }
}
