import java.util.IllegalFormatCodePointException;
import java.util.Scanner;

public class AccurateLee {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int C = sc.nextInt();
        for (int i=0;i<C;i++) {
            Solve(sc);
        }
    }
    private static void Solve(Scanner sc){
        int n =  sc.nextInt();
        String s = sc.next();
        int firstOne = -1;
        int lastZero = -1;
        String r = "";
        boolean flag = true;
        for (int i=0;i<s.length();i++){
            if (s.charAt(i)=='0'){
                lastZero = i;
            }else if (flag){
                firstOne = i;
                flag = false;
            }
        }
        if ((lastZero-firstOne)>0){
            r = "0";
        }
        String f;
        if (lastZero==-1||firstOne==-1){
            f = s;
        }else {
            f = s.substring(0,firstOne)+r+s.substring(lastZero+1,s.length());
        }
        System.out.println(f);
    }
}


/**
 *  对于string a
 *  我们可以分成三个部分
 *  a b c -> a== 0* c == 1*
 *  b=1(1,0)*
 *  b c  100000001  ==> 1
 *  a b
 *  a c  -> a c
 *  b ==> 1 01* 0 =>
 *  a ==> 00000000 => a
 *  c ==> 11111111 => c
 * */