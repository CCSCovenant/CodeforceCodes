import java.util.Scanner;

public class C {
    static Scanner sc;
    static String a;
    static String b;
    static StringBuilder ABuilder;
    static StringBuilder BBuilder;
    static int[] diff;
    public static void main(String[] args){
        sc = new Scanner(System.in);
        int Case = sc.nextInt();
        for (int i=0;i<Case;i++){
            Solve();
        }
    }
    private static void Solve(){
        int n = sc.nextInt();
        a = sc.next();
        b = sc.next();
        ABuilder = new StringBuilder(a);
        BBuilder = new StringBuilder(b);
        diff = new int[n];
        for (int i=0;i<n;i++){
            diff[i] = b.charAt(i)-a.charAt(i);
            if (diff[i]<0){
                System.out.println(-1);
                return;
            }
        }
        int counter=0;
        int conticounter =0;
        char mintarget = 'z';
        for (int i=0;i<19;i++){
            for (int j=0;j<n;j++){
                if (ABuilder.charAt(j)==(char)('a'+i)&&ABuilder.charAt(j)!=BBuilder.charAt(j)){
                    mintarget = (char) Math.min(mintarget,BBuilder.charAt(j));
                    conticounter++;
                }
            }
            if (conticounter>0){
              //  System.out.println("j is "+n+" cc is "+conticounter+" i is "+ i);
               // System.out.println("min target is "+ mintarget);
                for (int j = 0;j<n;j++){
                   if (ABuilder.charAt(j)==(char)('a'+i)&&ABuilder.charAt(j)!=BBuilder.charAt(j)){
                       ABuilder.setCharAt(j,mintarget);
                   }
                }
                counter++;
                conticounter = 0;
                mintarget = 'z';
            }
          //  System.out.println(ABuilder.toString());
        }
        System.out.println(counter);
    }
}

/***
 *  a-t-1
 *
 *  aaaa aa aa
 *
 *  target  target target
 *
 *  bbb bbb
 *
 *
 *  ttt  tttt
 *     b
 *  aat
 *
 *
 *  bcdefg
 *  aaaaaaa
 *
 *  20*10^5
 *  aaaaaa
 *  tttttt
 *
 *  aabaa
 *
 *  1 2 1
 *
 *  2 2 1 0
 *
 * */

