import java.util.Scanner;

public class C {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args){
        int n = sc.nextInt();
        for (int i=0;i<n;i++){
            Solve();
        }
    }
    public static void Solve(){
        String s = sc.next();
        int n = sc.nextInt();
        int l = s.length();
        StringBuilder ans = new StringBuilder();
        boolean flag = true;
            for (int i=0;i<l;i++) {
                ans.append('1');
            }
            for (int i=0;i<l;i++){
              if (s.charAt(i)=='0'){
                  if (i>=n){
                      ans.setCharAt(i-n,'0');
                  }
                  if (i+n<l){
                      ans.setCharAt(i+n,'0');
                  }
              }
            }
        for (int i=0;i<l;i++){
            boolean tmp1 = false;
            boolean tmp2 = false;
            if (s.charAt(i)=='1'){
                if (i>=n){
                    tmp1 = ans.charAt(i-n)=='1';
                   // System.out.println("i-n: "+i+""+ans.charAt(i-n));
                   // System.out.println("tmp1: "+tmp1);
                }
                if (i+n<l){
                    tmp2 = ans.charAt(i+n)=='1';
                 //   System.out.println("i+n: "+i+""+ans.charAt(i+n));
                  //  System.out.println("tmp2: "+tmp2);
                }
            }
            if (s.charAt(i)=='0'){
                tmp1 = true;
            }

            flag = (tmp1||tmp2);
            if (!flag){
                break;
            }
        }
    //    System.out.println("---end---");
            if (flag){
                System.out.println(ans);
            }else {
                System.out.println(-1);
            }


    }
}
/****
 *     01
 *     10
 *         110
 *          11
 *         10
 *
 *         101
 *
 *          10
 *         01
 *         010
 *
 *
 * i>x wi-x==1
 * si = 1
 *
 *
 * 011 111
 * 101 110
 * 111 011
 * 123 416
 *
 * 11 1 01 1                  101110
 *
 *                            2
 * 0+(n-x-x)
 *                            111011
 **   1..n-x
 *  * x..n
 *  *
 *  * x+1..n           x+1---n-x
 *  * 1...n-x
 *    n-x-x+1
 *    n-x-x-1
 *
 *   6-4+1
 *   3
 *                            1..4        1110
 *                            2..6          1110       n-x+1 n
 *                                                     1..x
 *
 *                            3..6          1011
 *                            1..4        1011
 *
 *                                          1110
 *                                         1011
 *                   3.4
 *                 1110
 *                   1011
 *
 *                   110
 *
 *                   10
 *                    11
 *
 *
 *
 *                   110
 *                                        101110          11
 *                                                       10
 *    10
 *     1
 *    0
 *
 *                                                       01
 *                                                        0
 *                                                       1
 *                           1..2    10
 *                           2..3     10
 *
 *                           2..3     11
 *                           1..2    11
 *
 *
 *                           x+1..n-x
 *
 *                           1.1
 *                           2.2
 *
 *                           2.2
 *                           1.1
 *
 *
 *
 *
 *

 *
 * 3
 * 1..2  10
 * 2..3  10
 *
 * 2..3  11
 * 1..2  11
 *
 *
 * 101 110
 *
 *
 * 10
 * */