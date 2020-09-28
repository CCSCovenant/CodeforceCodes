import java.util.Scanner;
public class C {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            Solve();
        }
    }
    private static void Solve() {
        int n = sc.nextInt();
        int[] a = new int[n];
        long ans = 0;
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        for (int i = 0; i < n - 1; i++) {
            if (a[i] > a[i + 1]) {
                ans += a[i] - a[i + 1];
            }
        }
        System.out.println(ans);
    }
}
/***
 *
 *
 *
 * 1 2 3 4 5 2 3 2 3 6 7 2 3
 *           2 3 3 4
 *
 *
 * 5 5
 *           2 3 4 5 2 3 4 5 6 7 2 3 4
 *
 *           5 2 2 2 5
 *
 *
 *
 *  1 2 3 4 5
 *
 *
 *
 * */