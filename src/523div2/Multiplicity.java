package Div2_523;
import java.util.Scanner;
public class Multiplicity {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i=0;i<n;i++){
            a[i] = sc.nextInt();
        }
        long[] ans = new long[n];
        long[] prv = new long[n];
        prv[0]=1;
        ans[0]=1;
        for (int i=1;i<n;i++){
            ans[0] = prv[0]+1;
            for (int j=1;j<=Math.min(Math.sqrt(a[i]),i);j++){
                if (a[i]%(j+1)==0){
                    ans[j] += prv[j-1];
                    if (a[i]/(j+1) <=i) {
                        ans[a[i]/(j+1)-1] +=prv[a[i]/(j+1)-2];
                    }
                }
            }
            for (int j=0;j<=i;j++){
                prv[j]=ans[j];
            }



        }
        long res=0;
        for (int i=0;i<n;i++){
            res = (res+ans[i])%(1000000000+7);
        }
        System.out.println(res);
    }


}

/**
 * 1 2 3
 *  1
 *  [0][0] = 1
 **
 *   [1][0] = 2
 *    [1][1] = 1
 *
 *    [2][0] = 3
 *    [2][1] = 1
 *   [2][2] = 1
 *
 *   [3][0] = 4
 *    [3][1] = 4
 *    [3][2] = 1
 *    [3][3] = 1
 *
 *
 *
 *
 * */