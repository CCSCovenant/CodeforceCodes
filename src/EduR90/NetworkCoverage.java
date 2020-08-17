import java.util.Scanner;

public class NetworkCoverage {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int Case = sc.nextInt();
        for (int i = 0; i < Case; i++) {
            Solve(sc);
        }
    }
    private static void Solve(Scanner sc) {
        int n = sc.nextInt();
        int[] citys = new int[n];
        int[] stations = new int[n];
        for (int i=0;i<n;i++){
            citys[i] = sc.nextInt();
        }
        for (int i=0;i<n;i++){
            stations[i] = sc.nextInt();
        }

        for (int i=0;i<n;i++){
            citys[i] -= stations[i];
            citys[(i+1)%n] -=stations[i];
        }
        boolean flag = true;
        for (int i=0;i<n;i++){
           if (citys[i]>0){
               flag =false;
               break;
           }
        }
        if (flag){
            System.out.println("YES");
        }else {
            System.out.println("NO");
        }
    }
}

/**
 *
 *  case 1:
 *    5         1           4
 *        6            7
 *
 *
 *
 *
 *
 *
 *
 *
 *
 * */
