import java.util.Scanner;

public class OmkarandCompletion {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int c = sc.nextInt();
        for (int j =0;j<c;j++){
            int n = sc.nextInt();
            for (int i=0;i<n;i++){
                System.out.print(1+" ");
            }
            System.out.println();
        }
    }
}
