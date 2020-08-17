package Div2_639;


import java.util.Arrays;
import java.util.Scanner;

public class HilbertHotel {
    public static void main(String[] args){

    Scanner sc = new Scanner(System.in);
    int Case = sc.nextInt();
    for (int i=0;i<Case;i++){
        Solve(sc);
    }
}
    private static void Solve(Scanner sc) {
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i=0;i<n;i++){
            a[i] = (sc.nextInt()%n+i)%n;
            if (a[i]<0){
                a[i] = a[i]+n;
            }
            //System.out.print(a[i]+" ");
        }
        Arrays.sort(a);
        boolean flag = true;
        for (int i=1;i<n;i++){
            if (a[i]==a[i-1]){
                flag = false;
                break;
            }
        }
        if (flag){
            System.out.println("YES");
        }else {
            System.out.println("NO");
        }
    }
}



/*****
 *
 *
 *   a  b c d e f
 *   %n %n %n %n %n
 *
 *
 *   0 1 2 3 4 5
 *   +%n =>
 *   -3 -2 -1
 *
 *    0 1 2 3 4
 *    -1 = 4
 *    -2 = 3
 *    -3 = 2
 *    -4 = 1
 * */