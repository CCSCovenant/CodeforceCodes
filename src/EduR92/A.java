import java.util.Scanner;

public class A {
    static Scanner sc;
    static int l;
    static int y;
    public static void main(String[] args){
        sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i=0;i<n;i++){
            Solve();
        }
    }
    private static void Solve(){
        int l = sc.nextInt();
        int r = sc.nextInt();
        int y = l*2;
        if (y>r){
            System.out.println(-1+" "+-1);
            return;
        }else {
            System.out.println(l+" "+y);
        }
    }
}
