import java.util.Scanner;

public class D {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            Solve();
        }

    }

    private static void Solve() {
        int n = sc.nextInt();
        String S = sc.next();
        int counter = 0;
        int ans = 0;
        int j = 0;
        boolean flag = true;
        for (int i = 0; i < n - 1; i++) {
            if (S.charAt(i) != S.charAt(i + 1)) {
                j = i + 1;
                break;
            }
        }
        char last = S.charAt(j);
        for (int i = 0; i < n; i++) {
            if (S.charAt(j) != last){
                ans += counter / 3;
                flag = false;
                counter = 1;
                last = S.charAt(j);
             //   System.out.print("|"+S.charAt(j)+":"+counter);

            }else if (i==n-1){
                if (S.charAt(j)==last){
                    counter++;
                }else {
                    flag = false;
                }
                if (flag){
                    ans += (counter-1)/3+1;
                }else {
                    ans += counter/3;
                }
              //  System.out.print("|"+S.charAt(j)+":"+counter);
            }
            else {
                counter++;
               // System.out.print("|"+S.charAt(j)+":"+ counter);
            }
            j++;
            if (j==n){
                j=0;
            }
        }
        System.out.println(ans);
    }
}


/****
 *
 *
 *
 * LRRLRR
 * LRRLRRL
 *
 * */