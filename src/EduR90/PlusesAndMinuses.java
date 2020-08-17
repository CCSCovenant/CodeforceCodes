import java.util.Scanner;

public class PlusesAndMinuses {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int Case = sc.nextInt();
        for (int i=0;i<Case;i++){
            Solve(sc);
        }
    }
    private static void Solve(Scanner sc) {
        long res = 0;
        int cur = 0;
        String s = sc.next();
        for (int i =0;i<s.length();i++){
            res++;
            if (s.charAt(i)=='+'){
                cur++;
            }else{
                cur--;
            }
            if (cur<0){
                res += (i+1);
                cur ++;
            }
        }
        System.out.println(res);
    }

}

/**
 *
 *  "+" "-" = init
 *  break
 *
 *
 *
 *
 * */