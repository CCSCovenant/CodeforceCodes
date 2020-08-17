import java.util.Scanner;

public class A {
    static Scanner sc = new Scanner(System.in);
    static StringBuilder ans;
    public static void main(String[] args){
        int n = sc.nextInt();
        for (int i=0;i<n;i++){
            Solve();
        }
    }
    private static void Solve(){
        int n = sc.nextInt();
        ans = new StringBuilder();
        for (int i=0;i<n;i++){
            ans.append((i+1)+" ");
        }
        System.out.println(ans);
    }

}


/**
 *
 * 3
 *   1
 *  10
 * 100
 *1000
 * 1 2 3
 * 1 2 3 4
 *
 *
 *
 *
 *
 *
 * */
