import java.util.Scanner;

public class SequentialNim {
    static Scanner sc;
    public static void main(String args[]){
        sc = new Scanner(System.in);
        int Case = sc.nextInt();
        for (int i=0;i<Case;i++){
            Solve();
        }
    }
    private static void Solve(){
        int n = sc.nextInt();
        int number1 = 0;
        boolean flag = false;
        int winner = 0;
        for (int i=0;i<n;i++){
            int tmp = sc.nextInt();
                if (flag){

                }else {
                    if (tmp==1){
                        number1++;
                    }else if (tmp>1){
                        flag = true;
                        winner=(number1+1)%2;
                    }
                }
        }
        if (!flag){
            winner = number1%2;
        }
        if (winner==0){
            System.out.println("Second");
        }else {
            System.out.println("First");
        }
    }
}
/***
 *
 *
 *
 *
 *   >1 == 1
 *   |1|%2 = 0 2
 *      %2 = 1 1
 *
 *     3 1 1 1 1 1
 *   1 3 1 1 1 1
 *   1> 1 0
 *
 *   1 2 2 1 1
 *     3 3 1 1 3 3 1 1
 *
 *
 *
 *
 *
 * */