import java.util.Arrays;
import java.util.Scanner;

public class C {
    static Scanner sc = new Scanner(System.in);
    static StringBuilder out = new StringBuilder();
    public static void main(String[] args){
        int t = sc.nextInt();
        while (t-- >0){
            int n = sc.nextInt();
            int[] a = new int[n];
            int[] interval = new int[n+1];
            int[] lastindex = new int[n+1];
            Arrays.fill(lastindex,-1);
            for (int i=0;i<n;i++){
                a[i] = sc.nextInt();
                int tmp = a[i];
                interval[tmp] = Math.max(i-lastindex[tmp],interval[tmp]);
                lastindex[tmp] = i;
            }
            for (int i=0;i<n;i++){
                if (lastindex[i]!=-1){
                    interval[i] = Math.max(n-lastindex[i],interval[i]);
                }
            }
            int[] ans = new int[n];
            Arrays.fill(ans,-1);
            for (int i=1;i<n+1;i++){
                if (interval[i]!=0){
                    for (int j=interval[i]-1;j<n;j++){
                        if (ans[j]==-1){
                            ans[j] = i;
                        }else {
                            break;
                        }
                    }
                }
            }
            for (int i=0;i<n;i++){
                out.append(ans[i]+" ");
            }
            out.append("\n");
        }
        System.out.println(out);
    }
}
// 10001