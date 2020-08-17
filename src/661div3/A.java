import java.util.Arrays;
import java.util.Scanner;

public class A {
    static Scanner sc;
    static int[] a;
    public static void main(String[] args){
        sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i=0;i<n;i++){
            Solve();
        }
    }
    private static void Solve(){
        int n = sc.nextInt();
        a = new int[n];
        for (int i=0;i<n;i++){
            a[i] = sc.nextInt();
        }
        Arrays.sort(a);
        for (int i=1;i<n;i++){
            if ((a[i]-a[i-1])>1){
                System.out.println("NO");
                return;
            }
        }
        System.out.println("YES");
    }
}
