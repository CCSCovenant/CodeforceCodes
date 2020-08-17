package Div2_641;

import java.util.Scanner;

public class OracAndFactors {
    public static void main(String[] args){

    Scanner sc = new Scanner(System.in);
    int Case = sc.nextInt();
    for (int i=0;i<Case;i++){
        Solve(sc);
    }
}
    private static void Solve(Scanner sc){
        int n = sc.nextInt();
        int k = sc.nextInt();
        int s =FindSmallestdivisor(n);
            n= n+FindSmallestdivisor(n)+2*(k-1);
        System.out.println(n);
    }
    private static int FindSmallestdivisor(int n){
        int ans =n;
        for(int i=2;i*i<=n;i++){
            if (n%i==0){
                ans = i;
                break;
            }
        }
        return ans;
    }
}
/***
 *  n= a*b
 *  n+a = a*(b+1) = a*(b+k)
 *
 *  n+n - 2 *
 *  n+a*k
 *  for(i=0;i<k;i++)
 *  {
 *      n+a
 *  }
 *  3*5
 *  15 + 3 + 3 + 3 + 3
 *
 *  n%2==0
 *  n%2==1
 *
 *  2
 *
 * */