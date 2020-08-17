import java.util.Scanner;

public class Fashionablee {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int C = sc.nextInt();
        for (int i=0;i<C;i++) {
            Solve(sc);
        }
    }
    private static void Solve(Scanner sc){
        int n = sc.nextInt();
        if ((n%4)==0){
            System.out.println("YES");
        }else {
            System.out.println("NO");
        }
    }
}
