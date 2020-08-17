import java.util.Scanner;

public class ThreePairwiseMaximums {
    public  static  void  main(String args[]){
        Scanner sc = new Scanner(System.in);
        int Case = sc.nextInt();
        for (int i=0;i<Case;i++){
            Solve(sc);
        }
    }
    public static void Solve(Scanner sc){
        int x  = sc.nextInt();
        int y = sc.nextInt();
        int z = sc.nextInt();
        int a;
        int b;
        int c;
        if (x==y&&y==z){
            a=x;
            b=x;
            c=x;
        }else {
            if (x==y&&x>z){
                a = x;
                b = z;
                c = z;
            }else if(x==z&&x>y) {
                a = z;
                b = y;
                c = y;
            }else if (y==z&&y>x){
                a = y;
                b = x;
                c = x;
            }else {
                System.out.println("NO");
                return;
            }
        }
        System.out.println("YES");
        System.out.println(a+" "+b+" "+c);
    }
}


// a   x = y = a
// b>c
// c>b
// b   x = z = b
// a>c
// c>a
// c    y = z = c
// b>a
// a>b