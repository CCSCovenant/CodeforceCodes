package EduR86;

import java.math.BigDecimal;
import java.util.Scanner;

public class RoadToZero {
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        int Case = sc.nextInt();
        for (int i=0;i<Case;i++){
            Solve(sc);
        }
    }
    private static void Solve(Scanner sc){
        long x = sc.nextInt();
        long y = sc.nextInt();
        long a = sc.nextInt();
        long b = sc.nextInt();
        long res;
        if (2*a<=b){
            res = a*(Math.abs(x)+Math.abs(y));
        }else {
            if (Math.abs(x)+Math.abs(y)==Math.abs(x+y)){
             //   System.out.println(Math.abs(x-y));
             //   System.out.println(Math.abs(Math.min(Math.abs(x),Math.abs(y))));
                res = Math.abs(x-y)*a+b*Math.abs(Math.min(Math.abs(x),Math.abs(y)));
            }else {
                res = a*(Math.abs(x)+Math.abs(y));
            }
        }
        System.out.println(res);
    }
}
