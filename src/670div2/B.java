import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class B {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) throws IOException {
        int t = sc.nextInt();
        while (t-->0){
            int n = sc.nextInt();
            int[] a = new int[n];
            for (int i=0;i<n;i++){

                a[i] = sc.nextInt();
            }
            Arrays.sort(a);
            long Product1 = 1L;
            for (int i=n-1;i>n-6;i--){
                Product1 *= a[i];
            }

            long Product2 = ((long) a[0])*a[1]*a[2]*a[3]*a[n-1];
            long Product3 = ((long) a[0])*a[1]*a[n-3]*a[n-2]*a[n-1];

            System.out.println(Math.max(Math.max(Product1,Product2),Product3));

        }
    }


}


/****
 *
 *
 *  1.全是负数/0 最大的五个数
 *
 *  2.全是正数/0 最大的五个数
 *
 *  3.最大的三个正数 最小的四个负数
 *
 *
 *  + + + - -
 *  + - - - -
 *
 *
 *
 *
 *
 *  + + + + +
 *
 *  - - - - -
 *
 *  - - - - -
 *
 *
 *
 *
 */
