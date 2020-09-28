import java.util.Scanner;

public class E {
    static Scanner sc = new Scanner(System.in);
    static StringBuilder out = new StringBuilder();
    public static void main(String[] args){
        int n = sc.nextInt();
        int aR = sc.nextInt();
        int aS = sc.nextInt();
        int aP = sc.nextInt();
        int bR = sc.nextInt();
        int bS = sc.nextInt();
        int bP = sc.nextInt();
        int MaxWin = Math.min(aR,bS)+Math.min(aP,bR)+Math.min(aS,bP);
        int Rw = aR-(bR+bP);
        int Sw = aS-(bS+bR);
        int Pw = aP-(bP+bS);
        if (Rw<0){
            Rw = 0;
        }
        if (Sw<0){
            Sw = 0;
        }
        if (Pw<0){
            Pw = 0;
        }
        int MinWin = Pw+Sw+Rw;
        System.out.println(MinWin+" "+MaxWin);
    }
}

///  R S P
///  R S P