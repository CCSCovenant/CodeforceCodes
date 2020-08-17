import java.util.Scanner;

public class MakeItGood {
    public  static  void  main(String args[]){
        Scanner sc = new Scanner(System.in);
        int Case = sc.nextInt();
        for (int i=0;i<Case;i++){
            Solve(sc);
        }
    }
    public static void Solve(Scanner sc){
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i=0;i<n;i++){
            a[i] = sc.nextInt();
        }
        boolean flag = true;
        int index = 0;
        for (int i=n-1;i>0;i--){
            if (a[i-1]<a[i]&&flag){
                flag=false;
            }
            if (a[i-1]>a[i]&&!flag){
                index=i;
                break;
            }
        }
        System.out.println(index);

    }
}
/*
*
*
*   1100011001111100000
*
*
*
* */