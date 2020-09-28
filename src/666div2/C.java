import java.util.Scanner;

public class C {
    static Scanner sc = new Scanner(System.in);
    static StringBuilder ans = new StringBuilder();
    static int n;
    static long[] a;
    static long[] delta1;
    static long[] delta2;
    public static void main(String[] args){
        n = sc.nextInt();
        a = new long[n];
        delta1 = new long[n];
        delta2 = new long[n];
        for (int i=0;i<n;i++){
            a[i] = sc.nextInt();
        }
        delta1[0] = 0;
        for (int i=1;i<n;i++){

                delta1[i] = -a[i]*n;

        }
        for (int i=1;i<n;i++){

                delta2[i] = a[i]*(n-1);

        }
        ans.append("1 1"+"\n");
        ans.append(-a[0]+"\n");
        ans.append("1 "+n+"\n");
        for (int i=0;i<n;i++){
            ans.append(delta1[i]+" ");
        }
        ans.append("\n");
       if (n!=1){
           ans.append("2 "+n+"\n");
           for (int i=1;i<n;i++){
               ans.append(delta2[i]+" ");
           }
       }else {
           ans.append("1 "+n+"\n");
           ans.append(0);
       }
        System.out.println(ans);
    }
}
