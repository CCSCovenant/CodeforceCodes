import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeSet;

public class C {
    static Scanner sc = new Scanner(System.in);
    static StringBuilder out = new StringBuilder();
    static long[] a;
    static boolean[] top;
    static boolean[] floor;
    static long ans;
    static int t;
    static TreeSet<Integer> change = new TreeSet<>();

    public static void main(String[] args){
         t = sc.nextInt();
        while (t-- >0){
            int n = sc.nextInt();
            int q = sc.nextInt();
            change.clear();
            a = new long[n];
            top = new boolean[n];
            floor = new boolean[n];
            for (int i=0;i<n;i++){
                a[i] = sc.nextInt();
            }
            ans = 0;
            if (n==1){
                ans = a[0];
            }else {
                for (int i=0;i<n;i++){
                    top[i] = checkTop(i);
                    floor[i] = checkfloor(i);
                }
            }
            for (int i=0;i<n;i++){
                if (top[i]){
                    ans += a[i];
                }
                if (floor[i]){
                    ans -= a[i];
                }
            }
            out.append(ans+"\n");

            while (q-- > 0){
                int l = sc.nextInt();
                int r = sc.nextInt();
                if (n==1){
                    ans = a[0];
                    out.append(ans + "\n");
                }else {

                    change.clear();
                    tryRollBack(l - 1);
                    tryRollBack(r - 1);
                    rollBack();
                    long tmp = a[l - 1];
                    a[l - 1] = a[r - 1];
                    a[r - 1] = tmp;
                    update();
                    redo();
                    out.append(ans + "\n");
                }
            }


        }
        System.out.println(out);
    }
    public static boolean checkTop(int n){
        if (n==0){
            if (a[n]>a[n+1]){
                return true;
            }
        }else if (n==a.length-1){
            if (a[n]>a[n-1]){
                return true;
            }
        }else {
            if (a[n]>a[n-1]&&a[n]>a[n+1]){
                return true;
            }
        }
        return false;

    }
    public static boolean checkfloor(int n){
        if (n==0){
            return false;
        }else if (n==a.length-1){
            return false;
        }else {
            if (a[n]<a[n-1]&&a[n]<a[n+1]){
                return true;
            }
        }
        return false;
    }
    public static void tryRollBack(int n){
        change.add(n);
        if (n>0){
          change.add(n-1);
        }
        if (n<a.length-1) {
           change.add(n+1);
        }
    }
    public static void rollBack(){
        for (int n:change){
            if (top[n]){
                ans -= a[n];
            }
            if (floor[n]){
                ans += a[n];
            }
        }
    }
    public static void redo(){
        for (int n:change){
            if (top[n]){
                ans += a[n];
            }
            if (floor[n]){
                ans -= a[n];
            }
        }
    }
    public static void update(){
        for (int n:change){
            top[n] = checkTop(n);
            floor[n] = checkfloor(n);
        }
    }


}
// 1 2 4 5 6 7