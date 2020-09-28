import java.util.Scanner;

public class F {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        long[] a = new long[n];
        StringBuilder ans = new StringBuilder();
        long sum = 0;
        for (int i = 0; i < n; i++) {
            sum += s.nextLong();
            a[i] = i + 1;
        }
        long diff = sum - (((long) n) * ((long) n + 1L)) / 2L;
        long base = diff / n;
        long extra = diff % n;
        for (int i = 0; i < n; i++) {
            a[i] += base;
            if (i < extra) {
                a[i] += 1;
            }
            ans.append(a[i] + " ");
        }
        System.out.print(ans);
    }
}
