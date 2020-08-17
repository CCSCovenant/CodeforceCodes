import java.util.Scanner;

public class B {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            Solve();
        }

    }private static void Solve(){
        int n = sc.nextInt();
        long k = sc.nextLong();
        long[]a = new long[n];
        long min = sc.nextInt();
        long max = min;
        StringBuilder ans = new StringBuilder();
        a[0] = min;
        for (int i=1;i<n;i++){
            a[i] = sc.nextInt();
            min = Math.min(min,a[i]);
            max = Math.max(max,a[i]);
        }
        if (k%2==1){
            for (int i=0;i<n;i++){
               ans.append((max-a[i])+" ");
            }
        }else {
            for (int i=0;i<n;i++){
                ans.append((a[i]-min)+" ");
            }
        }
        System.out.println(ans);
    }
}



/***
 *
 *  5 -1 4 2 0
 *  0 6 1 3 5             k%2=1       d-ai
 *  6 0 5 3 1             k%2=0       ai-s
 *  0 6 1 3 5
 *
 *
 *
 *
 *
 *
 *
 *
 * */