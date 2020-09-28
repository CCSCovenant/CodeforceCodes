import java.util.Scanner;

public class F {
    static Scanner sc = new Scanner(System.in);
    static StringBuilder out = new StringBuilder();
    static long modulo = 1000000000+7;

    public static void main(String[] args){
        int n = sc.nextInt();

        long a=0;
        long ab=0;
        long abc=0;
        long question = 1;
        String s = sc.next();
        for (int i=0;i<n;i++){
            if (s.charAt(i)=='a'){
                a += question;
                a %= modulo;
            }else if (s.charAt(i)=='b'){
                ab += a;
                ab %= modulo;
            }else if (s.charAt(i)=='c'){
                abc += ab;
                abc %= modulo;
            }else {
                abc *= 3;
                abc %= modulo;
                abc += ab;
                abc %= modulo;
                ab *= 3;
                ab %= modulo;
                ab += a;
                ab %= modulo;
                a *=3;
                a %= modulo;
                a += question;
                a %= modulo;
                question *=3;
                question %= modulo;
            }
        }

        System.out.println(abc);
    }
}
