import java.util.ArrayList;
import java.util.IllegalFormatCodePointException;
import java.util.Scanner;

public class PrefixFlipE {
    static Scanner sc;
    static  String a;
    static  String b;
    static  int finalbit;
    static  int step;
    static int n;
    static ArrayList ans;
    public static void main(String args[]){
        sc = new Scanner(System.in);
        int Case = sc.nextInt();
        for (int i=0;i<Case;i++){
            Solve();
        }
    }
    private static void Solve(){
        n = sc.nextInt();
        a = sc.next();
        b = sc.next();
        step = 0;
        ans = new ArrayList();
        flipa();
        recoverb();
        System.out.print(step);
        for (int i=0;i<ans.size();i++){
            System.out.print(" "+ans.get(i));
        }
        System.out.println();
    }
    private static void flipa(){
        finalbit = a.charAt(0);
        for (int i=0;i<n-1;i++){
            if (a.charAt(i)!=a.charAt(i+1)){
                ans.add(i+1);
                step++;
                finalbit = a.charAt(i+1);
            }
        }
    }
    private static void recoverb(){
        for (int i=n-1;i>=0;i--){
            if (b.charAt(i)!=finalbit){
                ans.add(i+1);
                step++;
                finalbit =b.charAt(i);
            }
        }
    }
}

/**
 *
 * 11
 * 00
 * 10
 *
 * n
 * 0001101010
 * n
 *
 *
 * */