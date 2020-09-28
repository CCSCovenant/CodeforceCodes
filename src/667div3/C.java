import java.util.Scanner;

public class C {
    static Scanner sc = new Scanner(System.in);
    static StringBuilder ans = new StringBuilder();
    static int[] possdiff;
    public static void main(String[] args){
        int t = sc.nextInt();
        for (int i=0;i<t;i++){
            int n = sc.nextInt();
            int a = sc.nextInt();
            int b = sc.nextInt();
            int diff = b-a;
            possdiff = new int[diff+1];
            int min = 1000000000;
            int minindex = 0;
            for (int x=1;x<=diff;x++){
                if (diff%x==0&&diff/x<n){
                    int first;
                   if (b-x*(n-1)>0){
                       first = b-x*(n-1);
                   }else {
                       first = b-(b-1)/x*x;
                   }
                   possdiff[x] = first+x*(n-1);
                   if (possdiff[x]<min){
                       min = possdiff[x];
                       minindex = x;
                   }
                }

            }
            int first;
            if (b-minindex*(n-1)>0){
                first = b-minindex*(n-1);
            }else {
                first = b-(b-1)/minindex*minindex;
            }
            for (int x=0;x<n;x++){
                ans.append(first+x*minindex+" ");
            }

            ans.append("\n");
        }
        System.out.println(ans);
    }
}
