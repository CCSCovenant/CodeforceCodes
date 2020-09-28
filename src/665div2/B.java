import java.util.Scanner;

public class B {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args){
        int n = sc.nextInt();

        for (int i=0;i<n;i++){
            int a0 = sc.nextInt();
            int a1 = sc.nextInt();
            int a2 = sc.nextInt();
            int b0 = sc.nextInt();
            int b1 = sc.nextInt();
            int b2 = sc.nextInt();
            int ans = 0;
            int sum2 = Math.min(a2,b1);
            if (a2>b1){
                a2 = a2-b1;
            }else {
                a2 = 0;
            }
            int neg2 = b2-(a0+a2);
            if (neg2<0){
                neg2 = 0;
            }
            ans = sum2*2-neg2*2;
            System.out.println(ans);
        }
    }
}

/*****
 *
 *
 *
 *
 * 0-2
 * 0-1
 * 0-0
 *
 * 1-0
 * 1-1
 *
 * 2-1
 *
 * 2-1
 * 1-0
 *
 * 2-2 0
 * 2-1 2
 * 2-0 0
 *
 * 1-2 -2
 * 1-1 0
 * 1-0 0
 *
 *
 *
 *
 *
 *
 *
 *
 * */