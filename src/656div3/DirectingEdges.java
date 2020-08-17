import java.util.ArrayList;
import java.util.Scanner;

public class DirectingEdges {
    static int[] a;
    static int[] b;
    static int[] count;
    static boolean[] filped;
    static ArrayList<Integer> repeated;
    static  Scanner sc;
    public  static  void  main(String args[]){
        sc = new Scanner(System.in);
        int Case = sc.nextInt();
        for (int i=0;i<Case;i++){
            Solve();
        }
    }
    public static void Solve(){
        int n = sc.nextInt();
        a = new int[n];
        b = new int[n];
        filped = new boolean[n];
        count = new int[n];
        repeated = new ArrayList<>();
        init(n);
        for (int i=0;i<n;i++){

        }

    }
    private static void init(int n){
        for (int i=0;i<n;i++){
            a[i] = sc.nextInt();
        }
        for (int i=0;i<n;i++){
            count[a[i]]++;
        }
        for (int i=0;i<n;i++){
            if (count[i]==2){
                repeated.add(i);
                count[i]=0;
            }else if (count[i]>2){
                System.out.println(-1);
                return;
            }else {
                count[i]=0;
            }
        }
        for (int i=0;i<n;i++){
            b[i] = sc.nextInt();
        }
        for (int i=0;i<n;i++){
            count[b[i]]++;
        }
        for (int i=0;i<n;i++){
            if (count[i]==2){
                repeated.add(i);
                count[i]=0;
            }else if (count[i]>2){
                System.out.println(-1);
                return;
            }else {
                count[i]=0;
            }
        }
    }
}
/**
 *  10 2 9 4 7 6 5 8 9 10
 *  6  3 1 7 1 5 4 3 2 8
 *
 *
 *
 *  x->2->
 *
 *
 * **/