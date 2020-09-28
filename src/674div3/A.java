import java.util.Scanner;

public class A {
    static Scanner sc = new Scanner(System.in);
    static StringBuilder out = new StringBuilder();
    public static void main(String[] args){
        int t = sc.nextInt();
        while (t-->0){
            int n = sc.nextInt();
            int x = sc.nextInt();
            if (n<=2){
                out.append(1+"\n");
            }else {
                int f = ((n-2)/x)+1;
                if ((n-2)%x!=0){
                    f++;
                }
                out.append(f+"\n");
            }
        }
        System.out.println(out);
    }
}
