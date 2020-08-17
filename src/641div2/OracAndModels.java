package Div2_641;

import java.util.ArrayList;
import java.util.Scanner;

public class OracAndModels {
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        int Case = sc.nextInt();
        for (int i=0;i<Case;i++){
            Solve(sc);
        }
    }
    private static void Solve(Scanner sc){
        int n = sc.nextInt();
        int[] s = new int[n];
        int[] ans = new int[n];
        int max = 1;
        for (int i=0;i<n;i++){
            s[i] = sc.nextInt();
        }
        for (int i=1;i<n;i++){
            ArrayList factor = findFactors(n);
            for (int j=0;j<factor.size();j++){
                if ((int)factor.get(j)!=1||(int)factor.get(j)!=i){
                    if (s[i]>s[j]){
                        max = Math.max(max,ans[j]+1);
                        ans[i]=ans[j]+1;
                    }
                }
            }

        }

    }
    private static ArrayList findFactors(int n){
        ArrayList<Integer> factor = new ArrayList<Integer>();
        boolean conti = true;
        int ans;
        while (conti){
            ans = n;
            conti = false;
            for(int i=2;i*i<=n;i++){
                if (n%i==0){
                    ans = i;
                    conti = true;
                    break;
                }
            }
            factor.add(ans);
             n = n/ans;

        }
        return factor;
    }

}

/***      1 4 5 6 2 3
 *  i 2i 3i 4i 5i 6i 7i 8i
 *
 *  i i+1 i+2 i+3
 *
 *
 *  i = a*b
 *  ans[a] ans[b]
 *  a1*b1
 *  => a2*b2*  ==
 *
 *  i 2i 3i 4i
 *
 *
 *
 *
 *
 *
 * */
