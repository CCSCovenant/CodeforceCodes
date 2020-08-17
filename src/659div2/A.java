import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class A {
    static Scanner sc;
    static byte counter;
    static  StringBuilder init;
    static  StringBuilder curr;
    public static void main(String[] args){
        sc = new Scanner(System.in);
        int Case = sc.nextInt();
        init = new StringBuilder();
        for (int i=0;i<100;i++){
            init.append('a');
        }
        for (int i=0;i<Case;i++){
            Solve();
        }
    }
    private static void Solve(){
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i=0;i<n;i++){
            a[i] = sc.nextInt();
        }
        System.out.println(init);
        curr = init;
        for (int i=0;i<n;i++){
            PrintString(a[i]);
        }
    }
    private static void PrintString(int n){
        int k = 100-n;
        StringBuilder tmp = new StringBuilder();
        tmp.append(curr.substring(0,n));
        for (int i=0;i<k;i++){
            tmp.append(cyclechar(curr.charAt(n)));
        }
        System.out.println(tmp);
        curr = tmp;
    }
    private static char cyclechar(char a){
        char n = (char) (a+1);
        if (n>'z'){
            n = 'a';
        }
        return n;
    }
}

/** axxxxxx 1
 *  aaxxxx  2
 *  aaaaxxx  4
 *  aaaaxxxx
 *  aaxxxxx 2
 *  aaaaaaaaa
 *
 *  a 1
 *  aa 2
 *  aaaa 4
 *  aaaa
 *       2
 *  aa
 *        4
 *  aaaa
 *
 *
 * */