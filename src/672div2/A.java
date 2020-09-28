import java.util.Scanner;

public class A {
    static Scanner sc = new Scanner(System.in);
    static StringBuilder out = new StringBuilder();
    static int[] a;
    static boolean ans;
    public static void main(String[] args){
        int t = sc.nextInt();
        while (t-- > 0){
            int n = sc.nextInt();
            ans = false;
            a = new int[n];
            for (int i=0;i<n;i++){
                a[i] = sc.nextInt();
            }
            for (int i=1;i<n;i++){
                if (a[i]>=a[i-1]){
                    ans = true;
                    break;
                }
            }

            if (ans){
                out.append("YES\n");
            }else {
                out.append("NO\n");
            }
        }
        System.out.println(out);
    }


}
