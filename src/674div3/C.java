import java.util.Scanner;

public class C {
    static Scanner sc = new Scanner(System.in);
    static StringBuilder out = new StringBuilder();
    public static void main(String[] args){
        int t = sc.nextInt();
        while (t-->0){
            int n = sc.nextInt();
            int sqn = (int)Math.ceil(Math.sqrt(n));
            int copy = n/sqn;
            if (n%sqn!=0){
                copy++;
            }
            out.append((sqn-2+copy)+"\n");
        }
        System.out.println(out);
    }
}
