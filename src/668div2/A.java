import java.util.Scanner;

public class A {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args){
        int t = sc.nextInt();
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < t; i++){
            int n = sc.nextInt();
            int a[] = new int[n];
            for (int j=0;j<n;j++){
                a[j] = sc.nextInt();
            }
            for (int j=n-1;j>=0;j--){
                ans.append(a[j]+" ");
            }
            ans.append("\n");
        }
        System.out.println(ans);
    }
}


/**
 *
 *
 * a b c d e f
 *
 * 2 1 6 5
 *
 *
 *
 *
 *
 *
 * */