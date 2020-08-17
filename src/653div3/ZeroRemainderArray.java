import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ZeroRemainderArray {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int C = sc.nextInt();
        for (int i=0;i<C;i++){
            Solve(sc);
        }
    }
    private static void Solve(Scanner sc){
        int n = sc.nextInt();
        int k = sc.nextInt();
        Map<Integer,Integer> ModMap = new HashMap<>();
        int amax =0;
        int minIndex = 0;
        int mod;
        for (int i=0;i<n;i++){
             mod = sc.nextInt()%k;
             if (ModMap.containsKey(mod)){
                 ModMap.put(mod,ModMap.get(mod)+1);
             }else {
                 ModMap.put(mod,1);
             }
            if (mod!=0){
                if (amax==ModMap.get(mod)){
                    amax = ModMap.get(mod);
                    minIndex = Math.min(minIndex,mod);
                }else if (ModMap.get(mod)>amax){
                    amax = ModMap.get(mod);
                    minIndex = mod;
                }
            }
        }

        long ans =0;
        if (amax!=0){
             ans = (long)k*(amax-1)+k-minIndex+1;
        }
        System.out.println(ans);
    }
}
/**
 *
 *     1 2 3 4 k 1 2 3 4 k
 *
 *     1+2+3+4+5+6+7+8
 *    a b c d e f
 *    % % % % % %
 *    r1 r2 r3 r4 r5
 *    ==0
 *    1 2 3 4 5 6
 *    1..k-1
 *    K=7
 *    1 2 3 4 5 6
 *    => 6
 *    1 1 => 7
 *
 *    x=1
 *    a+x , x+1
 *    kn+1
 *
 *
 *    5 10
 *                             0+1 X=1
 *    9 9 9 9 9                9+1 X=2
 *                             9+2 X=3
 *    1 - 11                   9+3 X=4
 *    2 9 =>11                 9+4 X=5
 *    3 8 => 11                9+5 X=6
 *    4 7 => 11                14+6 X=7
 *
 *    1..(k-1)
 *
 *    1  1
 *    2 24
 *    +1
 *    +2
 *    +3
 *
 *
 *
 *  1
 *   10 6
 *     8 7 1 8 3 7 5 10 8 9
 *     2 1 1 2 3 1 5 4 2 3
 *
 *
 *
 *
 *
 *
 *
 *
 * */