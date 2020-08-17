import java.util.Scanner;

public class CommonSubsequence {
    static Scanner sc;
    static short[] counter;
    public static void main(String args[]){
        sc = new Scanner(System.in);
        int Case = sc.nextInt();
        for (int i=0;i<Case;i++){
            Solve();
        }
    }
    private static void Solve(){
        int n = sc.nextShort();
        int m = sc.nextShort();
        counter = new short[1001];
        for (int i=0;i<n;i++){
            short tmp = sc.nextShort();
            if (counter[tmp]==0){
                counter[tmp]=1;
            }
        }
        for (int i=0;i<m;i++){
            short tmp = sc.nextShort();
            if (counter[tmp]==1){
                counter[tmp]=2;
            }
        }
        boolean flag = true;
        for (int i=1;i<1001;i++){
            if (counter[i]==2){
                flag = false;
                System.out.println("YES");
                System.out.println(1+" "+i);
                break;
            }
        }
        if (flag){
            System.out.println("NO");
        }
    }
}
