import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class ReadingBooksE1 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        ArrayList<Integer> libA = new ArrayList();
        ArrayList<Integer> libB = new ArrayList();
        ArrayList<Integer> libAB = new ArrayList();



        for (int i=0;i<n;i++){
            int book = sc.nextInt();
            int A = sc.nextInt();
            int B = sc.nextInt();
            if (A==1&&B==1){
                libAB.add(book);
            }else if (A==1){
                libA.add(book);
            }else if (B==1){
                libB.add(book);
            }
        }
        Collections.sort(libA);
        Collections.sort(libB);
        Collections.sort(libAB);

        if (libAB.size()+Math.min(libA.size(),libB.size())<k){
            System.out.println(-1);
        }else {
            int ans = 0;
            int a =0;
            int b =0;
            int c =0;

            for (int i=0;i<k;i++){
                if (a<libA.size()&&b<libB.size()){
                        if (c>=libAB.size()){
                            ans += libA.get(a)+libB.get(b);
                            a++;
                            b++;
                        }else if (libA.get(a)+libB.get(b)<libAB.get(c)){
                            ans += libA.get(a)+libB.get(b);
                            a++;
                            b++;
                        }else {
                            ans += libAB.get(c);
                            c++;
                        }
                }else {
                    ans += libAB.get(c);
                    c++;
                }
            }
            System.out.println(ans);
        }
    }

}

/***
 *
 *  [1] == [2] == 1
 *  [1] == 1
 *  [2] == 1
 *
 *
 *    a1 a2 a3 a4 a5 a6
 *    b1 b2 b3 b4 b5 b6
 *    c1 c2 c3 c4 c5 c6
 *
 *    a b = size  + a b
 *    c = size  + c
 *
 *
 *
 * */
