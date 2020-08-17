import java.util.Scanner;

public class B {
    static Scanner sc;
    public static void main(String[] args){
        sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i=0;i<n;i++){
            Solve();
        }
    }
    private static void Solve(){
        int n = sc.nextInt();
        for (int i=0;i<n;i++){
            if (i>(n-((n-1)/4+1)-1)){
                System.out.print(8);
            }else {
                System.out.print(9);
            }
        }
        System.out.println();
    }
}
