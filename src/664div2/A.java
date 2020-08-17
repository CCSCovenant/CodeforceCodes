import java.util.Scanner;
import java.util.SortedMap;

public class A {
     static Scanner sc = new Scanner(System.in);
    public static void main(String[] args){
        int c = sc.nextInt();
        for (int i=0;i<c;i++){
            Solve();
        }
    }
    private static void Solve(){
        int r =sc.nextInt();
        int g =sc.nextInt();
        int b = sc.nextInt();
        int w = sc.nextInt();
        boolean flag1 = r%2==0;
        boolean flag2 = g%2==0;
        boolean flag3 = b%2==0;
        boolean flag4 = w%2==0;
        if (flag1&flag2&flag3&flag4){
            System.out.println("YES");
            return;
        }else {
            if (toInt(flag1)+toInt(flag2)+toInt(flag3)+toInt(flag4)==3){
                System.out.println("YES");
                return;
            }else if (toInt(flag1)+toInt(flag2)+toInt(flag3)+toInt(flag4)==1&&r>0&&g>0&&b>0){
                System.out.println("YES");
                return;
            }else if (toInt(flag1)+toInt(flag2)+toInt(flag3)+toInt(flag4)==0){
                System.out.println("YES");
                return;
            }

        }
        System.out.println("NO");

    }
    private static int toInt(boolean b){
        if (b){
            return 1;
        }else {
            return 0;
        }
    }
}

/***
 *
 *
 *
 * 2 2 2         1 1 1 0
 *               0 0 0 1
 *               1 1 0 0
 *               0 0 1 1
 * 1 0 1 1
 * 1 1 0 1
 * 0 0 1 0
 * 1 1 1 0
 * 0 0 0 1
 * 1 0 0 1
 * 0 1 1 0
 * 1 0 0 0
 * 0 1 1 1
 * */