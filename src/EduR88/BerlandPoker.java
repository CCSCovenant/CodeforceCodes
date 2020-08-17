package EduR88;

import java.util.Scanner;

public class BerlandPoker {
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
        int k = sc.nextInt();
        int point = 0;
        int cards = n/k;
        if (m<=cards){
            point = m;
        }else {
            point = cards - (int) Math.ceil((m-cards)/(double)(k-1));
        }
        System.out.println(point);
    }
}
