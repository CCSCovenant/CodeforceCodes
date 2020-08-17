import java.util.Scanner;

public class MoveBrackets {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int C = sc.nextInt();
        for (int i=0;i<C;i++){
            Solve(sc);
        }
    }
    private static void Solve(Scanner sc){
        int n = sc.nextInt();
        String Brackets = sc.next();
        int counter = 0;
        for (int i=n-1;i>=0;i--){
            if (Brackets.charAt(i)==')'){
                counter++;
            }else {
                if (counter>0){
                    counter--;
                }
            }
        }
        System.out.println(counter);
    }
}
/**
 *
 *  (())
 *  ()()
 *  ())(((()))
 *
 *
 * */