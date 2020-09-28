import java.util.Scanner;

public class B {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args){
        int n = sc.nextInt();
        for (int i=0;i<n;i++){
            Solve();
        }
    }
    public static void Solve(){
        int p = sc.nextInt();
        int f = sc.nextInt();
        int cnts = sc.nextInt();
        int cnta = sc.nextInt();
        int ws = sc.nextInt();
        int wa = sc.nextInt();
        if (ws>wa){
            int tmp;
            tmp = cnta;
            cnta = cnts;
            cnts = tmp;
            tmp = ws;
            ws = wa;
            wa = tmp;
        }


    }

}
/***
 *
 *
 *
 *
 *
 *
 *
 * */