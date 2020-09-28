import java.util.Scanner;
import java.util.TreeSet;

public class D {
    static Scanner sc = new Scanner(System.in);
    static StringBuilder out = new StringBuilder();
    public static void main(String[] args){
        int n = sc.nextInt();
        int[] a = new int[n];
        long[] prefix = new long[n];
        int ans = 0;
        for (int i=0;i<n;i++){
            a[i] = sc.nextInt();
        }
        TreeSet<Long> check = new TreeSet<>();
        prefix[0] = a[0];
        check.add(prefix[0]);
        for (int i=1;i<n;i++){
            prefix[i] = prefix[i-1]+a[i];
            if (prefix[i]==0||!check.add(prefix[i])){
                prefix[i]=a[i];
                check.clear();
                check.add(prefix[i]);
                ans++;
            }
        }
        System.out.println(ans);




    }
}

// 1 -7 3 2