import java.util.Scanner;

public class A {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args){
        int n = sc.nextInt();
        for (int i=0;i<n;i++){
            Solve();
        }
    }
    public static void Solve(){
        int n = sc.nextInt();
        String s = sc.next();
        StringBuilder ans = new StringBuilder();
        for (int i=0;i<n;i++){
            ans.append(s.charAt(n-1));
        }
        System.out.println(ans);
    }
}
/***
 *
 *
 * 1111000
 * 1111
 *
 * 1110000
 *
 *
 *
 *
 *
 * */