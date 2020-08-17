import java.util.Scanner;

public class NumberGame {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int C = sc.nextInt();
        for (int i=0;i<C;i++) {
            FindWinner(sc);
        }
    }
    private static void FindWinner(Scanner sc){
        int n = sc.nextInt();
        if (n==1){
            System.out.println("FastestFinger");

        }else if (n%2==1||n==2 ) {
            System.out.println("Ashishgup");

        }else {
            if ((n/2)%2==1){
                if (!checkP(n/2)){
                    System.out.println("Ashishgup");
                }else {
                    System.out.println("FastestFinger");
                }
            }else if ((Math.log10(n)/Math.log10(2))%1==0){
                System.out.println("FastestFinger");
            }else {
                System.out.println("Ashishgup");
            }
        }
    }
    private static boolean checkP (int n){
        boolean isP = true;
        for (int i =2;i<Math.ceil(Math.sqrt(n))+1;i++){
            if ((n/i)*i==n){
                isP=false;
            }
        }
        return isP;
    }
}

/*
*  1.奇数 -> "Ashishgup"
*  2.偶数 -> 没有奇数因子 ->             "FastestFinger"
 *  3.偶数 -> 有奇数因子
*         Ashishgup  除以奇数因子
*          -> 偶数（没有奇数因子) ->(1. =2 2. >2)
*                   1.=2 FastestFinger
*                   2. >2 Ashishgup
*
*  18 / 3
*
*
* */