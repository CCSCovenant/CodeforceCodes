import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class MaximumSumOnEvenPositions {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int Case = sc.nextInt();
        for (int i=0;i<Case;i++){
            Solve(sc);
        }
    }
    private static void Solve(Scanner sc) {
        int size = sc.nextInt();
        int[] a = new int[size];
        int diffsize = size;
        int[] diffeven = new int[diffsize];
        int[] diffodd  = new int[diffsize];
        for (int i=0;i<size;i++){
            a[i] = sc.nextInt();
        }
        for (int i=1;i<size;i++){
            if (i%2==1){
                diffeven[(i-1)/2] = a[i]-a[i-1];
            }else {
                diffodd[(i-2)/2] = a[i-1]-a[i];
            }
        }
        long diff1 = FindMaxSumOfSubarray(diffeven);
        long diff2 = FindMaxSumOfSubarray(diffodd);
        long evensum = 0;
        for (int i=0;i<size;i += 2){
            evensum += a[i];
        }
        if (Math.max(diff1,diff2)<=0){
            System.out.println(evensum);
        }else {
            long res = evensum+Math.max(diff1,diff2);
            System.out.println(res);
        }

    }
    private static long FindMaxSumOfSubarray(int[] target){
        long b = target[0];
        long m = target[0];
        for (int i=1;i<target.length;i++){
            if (b+target[i]>=target[i]){
                b+=target[i];
            }else {
                b = target[i];
            }
            if (m<b){
                m = b;
            }
        }
        return m;
    }

}



/**
 *
 *   1 2 -2 3 4 2 -5 2 4 5 6 7 -9 10
 *
 *
 *
 *
 *  l r
 *  l%2 = 0
 *  l%2 = 1
 *  (r-l)%2 = 0
 *
 *  r = size-(size%2)
 *
 *  1-0 3-2 5-3
 *   0   1   2   r/2
 *  2-1 4-3 6-4
 *   0   1   2   r/2
 *
 *  a b c d e f g
 *        g f e d
 *      g f e d c
 *      c d e f
 *      f c d e
 *        g + e - f - d = g -f + e-d
 *        f - e + d - c
 *
 *
 * */
