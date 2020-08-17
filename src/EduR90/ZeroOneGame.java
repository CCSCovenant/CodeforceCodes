import java.util.Scanner;

public class ZeroOneGame {
    public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    int Case = sc.nextInt();
    for (int i=0;i<Case;i++){
        Solve(sc);
    }
}
    private static void Solve(Scanner sc) {
        String binary = sc.next();
        int zerocounter = 0;
        int onecounter = 0;
        for (int i=0;i<binary.length();i++){
            if (binary.charAt(i)=='0') {
                zerocounter++;
            }else {
                onecounter++;
            }
        }
        if (Math.min(zerocounter,onecounter)%2==0){
            System.out.println("NET");
        }else {
            System.out.println("DA");
        }
    }
}



/**
 *  A B
 *  111111111 => B
 *  000000000 => B
 *  1100
 *  010011
 *  000010000
 *
 * */