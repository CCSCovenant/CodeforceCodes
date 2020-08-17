package Div2_639;

import java.util.Scanner;

public class CardConstructions {
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        int Case = sc.nextInt();
        for (int i=0;i<Case;i++){
            Solve(sc);
        }
    }
    private static void Solve(Scanner sc){
        long x = sc.nextInt();
        int counter = 0;
        while (true){
            long high = ReturnMaxHigh(x);
            //System.out.println("High is "+high);
            if (high>0){
                x = x-high*(3*high+1)/2;
              //  System.out.println("X is" + x);
                counter++;
            }else {
                break;
            }
        }
        System.out.println(counter);
    }
    private static long ReturnMaxHigh(long x){
        double n = (-1+Math.sqrt(1+4*2*x*3))/6;
      //  System.out.println("n is "+n);
        return (long)Math.floor(n);
    }
}
/***
 *  f(x)
 *  x=1, f(x)=2
 *  x=2, f(x)=2+2*2+1
 *  n(1+n)/2*2  +(n-1)(1+n-1) (n-1)(n)/2
 *  n+n^2 + n^2/2-n/2
 *  n^2+n^2/2+n-n/2
 *  9+4.5+3-1.5
 *  9+6
 *  15
 *
 *  4+2+2-1
 *
 *
 *
 *  n(n+n/2+1-1/2)
 *  x = 1/2 n(3n+1)
 *  x =
 *  2x = n(3n+1) - 2x =0
 *      3n^2 + n - 2x = 0
 *
 * 15
 *
 *
 * */