import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class B {
    static Scanner sc = new Scanner(System.in);
    static StringBuilder ans = new StringBuilder();
    public static void main(String[] args){
        int t = sc.nextInt();
        for (int i = 0 ; i < t ; i++){
            int n = sc.nextInt();
            ArrayList<Integer> a = new ArrayList<>();
            ArrayList<Integer> b = new ArrayList<>();
            int max = 0;
            for (int x = 0 ; x < n ; x++){
                int next = sc.nextInt();
                max = Math.max(max,next);
                a.add(next);
            }
            b.add(max);
            a.remove((Integer)max);
            for (int x = 1; x < n ; x++){
                int MaxGCD = 0;
                int localMax = 0;
                for (int y = 0; y < a.size() ; y++){
                    int localGCD = GCD(max,a.get(y));
                    if (localGCD > MaxGCD){
                        MaxGCD = localGCD;
                        localMax = a.get(y);
                    }
                }
                max = MaxGCD;
                b.add(localMax);
                a.remove((Integer)localMax);

            }
            for (int x = 0 ; x < b.size() ; x++){
                ans.append(b.get(x)+" ");
            }
            ans.append("\n");

        }
        System.out.println(ans);
    }
    public static int GCD(int a,int b){
        if (b==0){
            return a;
        }else {
            return GCD(b,a%b);
        }
    }
}

// 55 10 35
// 5*11 2*5 5*7
// a b d
// a c d