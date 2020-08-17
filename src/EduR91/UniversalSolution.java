import java.util.Scanner;

public class UniversalSolution {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int Case = sc.nextInt();
        for (int i=0;i<Case;i++){
            Solve(sc);
        }

    }
    private static void Solve(Scanner sc){
        String str = sc.next();
        int Scounter =0;
        int Rcounter =0;
        int Pcounter =0;
        for (int i=0;i<str.length();i++){
            switch (str.charAt(i)){
                case 'S':Scounter++;
                    break;
                case 'R':Rcounter++;
                    break;
                case 'P':Pcounter++;
                    break;
                default:
                    break;
            }
        }
        if (Scounter>=Rcounter&&Scounter>=Pcounter){
            for (int i=0;i<str.length();i++){
                System.out.print('R');
            }
        }else if (Rcounter>=Scounter&&Rcounter>=Pcounter){
            for (int i=0;i<str.length();i++){
                System.out.print('P');
            }
        }else {
            for (int i=0;i<str.length();i++){
                System.out.print('S');
            }
        }
        System.out.println();
    }
}
