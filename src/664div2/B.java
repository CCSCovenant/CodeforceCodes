import java.util.Scanner;

public class B {
    static Scanner sc = new Scanner(System.in);
    static StringBuilder ans;
    static boolean[] visited;
    static int n;
    static int m;
    public static void main(String[] args){
        Solve();
    }
    private static void Solve(){
         m = sc.nextInt();
         n = sc.nextInt();
         ans = new StringBuilder();
        int s1 = sc.nextInt();
        int s2 = sc.nextInt();
        int x=s1;
        int y=s2;
        visited = new boolean[m];
        for (int i=0;i<m;i++){
            y = Path(x,y);
            x++;
            if (x>m){
                x=1;
            }
        }
        System.out.println(ans);

    }
    private static int Path(int x,int y){
        int start = y;
        for (int i=0;i<n;i++){

            ans.append(x+" "+start+"\n");
            start++;
            if (start>n){
                start=1;
            }

        }
        if (start==1){
            return n;
        }else {
            return start-1;
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
 *
 *
 * */
