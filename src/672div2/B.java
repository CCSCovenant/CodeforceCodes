import java.util.Scanner;

public class B {
    static Scanner sc = new Scanner(System.in);
    static StringBuilder out = new StringBuilder();
    public static void main(String[] args){
        long[] bitnum;
        int t = sc.nextInt();
        while (t-- > 0){
            int n = sc.nextInt();
            int[] a = new int[n];
            bitnum = new long[30];
            for (int i=0;i<n;i++){
                a[i] = sc.nextInt();
            }
            for (int i=0;i<30;i++){
                int lb = 1<<i;
                int ub = 1<<i+1;
                for (int j=0;j<n;j++){
                    if (lb<=a[j]&&a[j]<ub){
                        bitnum[i]++;
                    }
                }
             }
            long ans = 0;
            for (int i=0;i<30;i++){
                long k = bitnum[i];
                ans += (k)*(k-1)/2;
            }
            out.append(ans+"\n");
        }
        System.out.println(out);


    }

}
//0+1+6+3
//            10100
//            00100