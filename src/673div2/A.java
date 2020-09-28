import java.util.Scanner;

public class A {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args){
        int t = sc.nextInt();
        while (t-- >0){
            int n = sc.nextInt();
            int k = sc.nextInt();

            int[] a = new int[n];
            int min = Integer.MAX_VALUE;
            int minIndex = 0;
            for (int i=0;i<n;i++){
                a[i] = sc.nextInt();
                if (a[i]<min){
                    min = a[i];
                    minIndex = i;
                }
            }
            int ans = 0;
            int subMin = Integer.MAX_VALUE;
            int subMinIndex = -1;
            for (int i=0;i<n;i++){
                if (i!=minIndex){
                    ans+= (k-a[i])/min;
                    int tmp = a[i]+((k-a[i])/min)*min;
                    if (tmp<subMin){
                        subMin = tmp;
                        subMinIndex = i;
                    }
                }
            }
            if (k-min>subMin){
                ans++;
            }
            System.out.println(ans);
        }
    }
}
