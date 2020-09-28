import java.util.Scanner;

public class D {
    static Scanner sc = new Scanner(System.in);
    static StringBuilder ans = new StringBuilder();
    static int t;
    static int n;
    static int[] a;
    static int lastpick;
    static boolean PlayerA;
    public static void main(String[] args){
        t = sc.nextInt();
        for (int i=0;i<t;i++){
            Solve();
        }
        System.out.println(ans);
    }
    public static void Solve(){
        n = sc.nextInt();
        lastpick = -1;
        PlayerA = true;
        a = new int[n];
        for (int i=0;i<n;i++){
            a[i] = sc.nextInt();
        }
        while (true){
           // System.out.println("R"+ i++);
            if (!subMax()){
                if (PlayerA){
                    System.out.println("HL");
                    break;
                }else {
                    System.out.println("T");
                    break;
                }
            }
            PlayerA = !PlayerA;
        }
    }
    public static boolean subMax(){
        int maxi =0;
        for (int i=0;i<n;i++){
            if ((a[i]>a[maxi]&&i!=lastpick)||maxi==lastpick){
                maxi = i;
            }
        }
        if (a[maxi]!=0&&maxi!=lastpick){
            a[maxi]--;
            lastpick = maxi;
            return true;
        }else {
            return false;
        }
    }

}
