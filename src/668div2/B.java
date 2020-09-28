import java.util.Scanner;

public class B {
    static Scanner sc = new Scanner(System.in);
    static int[] a;
    static StringBuilder ans = new StringBuilder();
    public static void main(String[] args){
        int t = sc.nextInt();
        for (int i = 0; i < t; i++){
            int n = sc.nextInt();
            long cur = 0;
            for (int j=0;j<n;j++){
                cur = Math.max(0L,cur+sc.nextInt());
            }
            ans.append(cur+"\n");
        }
        System.out.println(ans);
    }

}
