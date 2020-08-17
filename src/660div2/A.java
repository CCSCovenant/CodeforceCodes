
import java.util.Scanner;

public class A {
    static Scanner sc;
    public static void main(String[] args){
        sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i=0;i<n;i++){
            Solve();
        }
    }
    private static void Solve(){
        int n = sc.nextInt();
        if (n<31){
            System.out.println("NO");
        }else {
            System.out.println("YES");
           switch (n) {
               case 36:
                   System.out.println("6 10 15 5");
                   break;
               case 40:
                   System.out.println("6 10 15 9");
                   break;
               case 44:
                   System.out.println("6 10 15 13");
                   break;
               default:
                   System.out.println("6 10 14 "+(n-30));
           }
        }
    }


}

/*
*
* 6 10 14
* > 44
* 2 3 5 7
*
* 6 10 14
*
*
*  31 <  <45
*
*  36 40 44
*
* 6 10 15 5
*
* 6 10 15 9
*
* 6 10 15 13
*
* */
