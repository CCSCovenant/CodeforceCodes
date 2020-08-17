import java.util.Scanner;

public class A {
    static Scanner sc = new Scanner(System.in);
    static int[] a;
    public static void main(String[] args){
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
        if (a[0]+a[1]>a[n-1]){
            System.out.println(-1);
        }else {
            System.out.println(1+" "+2+" "+(n));
        }
    }

}

/**
 * A+B<=C
 *
 *
 * */