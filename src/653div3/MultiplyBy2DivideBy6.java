import java.util.Scanner;

public class MultiplyBy2DivideBy6 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int C = sc.nextInt();
        for (int i=0;i<C;i++){
            Solve(sc);
        }
    }
    private static void Solve(Scanner sc){
        int n = sc.nextInt();
        int ThreeCounter = 0;
        int TwoCounter = 0;
        boolean flag = true;

        while (flag){
             if (n%3==0){
                 n = n/3;
                 ThreeCounter ++;
             }else {
                 flag = false;
             }
         }
         for (int i=0;i<ThreeCounter;i++){
             if (n%2==0){
                 n = n/2;
                 TwoCounter++;
             }else {
                 break;
             }
         }
         if (n==1){
             System.out.println(ThreeCounter+(ThreeCounter-TwoCounter));
         }else {
             System.out.println(-1);
         }
    }
}
/**
 *
 *  n*2
 *  n/6
 *  2/3
 *  6^x/2^y
 *  x = 3
 *  y
 *  3*3 2*2
 *
 *
 * */
