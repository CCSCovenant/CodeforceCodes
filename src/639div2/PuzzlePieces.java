package Div2_639;

import java.util.Scanner;

public class PuzzlePieces {
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        int Case = sc.nextInt();
        for (int i=0;i<Case;i++){
            Solve(sc);
        }
    }
    private static void Solve(Scanner sc){
        int n = sc.nextInt();
        int m = sc.nextInt();
        if (n==1||m==1||(n==2&&m==2)){
            System.out.println("YES");
        }else {
            System.out.println("NO");
        }
    }

}
/**
 *
 *  1xn => yes
 *  nx1 => yes
 *
 *  2x2
 *
 *
 *
 *
 * */