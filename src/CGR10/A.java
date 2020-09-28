import java.util.Scanner;

public class A {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            Solve();
        }

    }

    private static void Solve() {
        int n = sc.nextInt();
        boolean flag = true;
        int last = sc.nextInt();
        for (int i = 1; i < n; i++) {
            int tmp = sc.nextInt();
            if (last != tmp) {
                flag = false;
            }
        }
        if (flag) {
            System.out.println(n);
        } else {
            System.out.println(1);
        }

    }
}


/****
 *
 *
 *
 *
 *
 *
 *     1 1 1 9 1 1 1 9 1 1 1
 *           9
 *
 *
 *
 *      1 2 1 2 1
 *
 *
 *
 *
 *
 * */