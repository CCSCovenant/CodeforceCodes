import java.util.Arrays;
import java.util.Scanner;

public class RationalLee {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int C = sc.nextInt();
        for (int i=0;i<C;i++) {
            Solve(sc);
        }
    }
    private static void Solve(Scanner sc){
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] a = new int[n];
        int[] w = new int[k];
        for (int i=0;i<n;i++){
            a[i] = sc.nextInt();
        }
        for (int i=0;i<k;i++){
            w[i] = sc.nextInt();
        }
        Arrays.sort(a);
        Arrays.sort(w);
        long sum =0;
        int last = a.length-1;
        int first = 0;
        for(int i=0;i<w.length;i++){
            if (w[i]==1){
                sum += 2*a[last];
                last--;
            }else{
                break;
            }
        }
        for (int i=w.length-1;i>=0;i--){
            if (w[i]==1){
                break;
            }
            sum += a[first]+a[last];
            first += w[i]-1;
            last--;

        }
        System.out.println(sum);
    }
}


/**
 *  a b c d e f g
 *
 *  w1 w2 w3 w4 w5
 *
 *  w =1 a*2 <
 *  w =2 a + b <
 *  w >2 a + b -(...)
 *
 *  w = 1 n*2
 *  w > 1 n1 + n2
 *

 1+3 4+10 5+11 6+12
 1+3 10+50 11+51 12+52

 10+1 50+2 51+3 52+10
 1 2 3 4 5 6 7 8 9 10 11 12

 3 3 3 3

 * */
