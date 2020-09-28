import java.util.Arrays;
import java.util.Scanner;

public class C {
    static Scanner sc = new Scanner(System.in);
    static int[] a;
    static int[] r;
    public static void main(String[] args){
        int n = sc.nextInt();
        for (int i=0;i<n;i++){
           Solve();
        }
    }
    private static void Solve(){
        int n = sc.nextInt();
        a = new int[n];
        a[0] = sc.nextInt();
        r = new int[n];
        boolean flag = true;
        int min = a[0];
        r[0] = a[0];
        for (int i=1;i<n;i++){
            a[i] = sc.nextInt();
            r[i] = a[i];
            min = Math.min(min,a[i]);
        }
        Arrays.sort(r);
        for (int i=0;i<n;i++){
            if (a[i]%min!=0){
                if (a[i]!=r[i]){
                    flag = false;
                    break;
                }
            }
        }
        if (flag){
            System.out.println("YES");
        }else {
            System.out.println("NO");
        }
    }

}
/****
 *
 *
 *
 * 2 4 6 8 10
 *
 *
 *
 *
 * 6 4
 *  4 2 8
 *
 *
 *
 *
 * */