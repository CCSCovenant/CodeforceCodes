import java.util.Scanner;

public class DonutShops {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int Case = sc.nextInt();
        for (int i=0;i<Case;i++){
            Solve(sc);
        }
    }
    private static void Solve(Scanner sc){
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();

        int first = 0;
        int second = 0;

        if (a>=c){
            first = -1;
        }else {
            first = 1;
        }
        if (a<=((double)c/b)){
            second = -1;
        }else {
            second = b;
        }
        System.out.println(first+" "+second);


    }
}
