import java.util.Scanner;

public class B {
    static Scanner sc = new Scanner(System.in);
    static StringBuilder ans;
    public static void main(String[] args){
        int n = sc.nextInt();
        ans = new StringBuilder();
        for (int i=0;i<n;i++){
            Solve();
        }
        System.out.println(ans);
    }
    private static void Solve(){
        int n = sc.nextInt();
        int m = sc.nextInt();
        String in;
        int counter = 0;
        for (int i=0;i<n-1;i++){
            in =  sc.next();
            if (in.charAt(m-1)=='R'){
                counter++;
            }
        }
        in = sc.next();
        for (int i=0;i<m-1;i++){
            if (in.charAt(i)=='D'){
                counter++;
            }
        }
        ans.append(counter+"\n");
    }
}
