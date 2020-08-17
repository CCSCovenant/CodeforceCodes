import java.util.Scanner;

public class SumOfDigits {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int Case = sc.nextInt();
        for (int i = 0; i < Case; i++) {
            Solve(sc);
        }
    }
    private static void Solve(Scanner sc) {

    }
}
/***
 *
 *  x x+1 x+2 x+3 x+4 x+5 x+6 x+7 x+8 x+9
 *  99 +1 == 100 +1 + 2+ 3 + 4 + 5 + 6
 *
 *
 * */