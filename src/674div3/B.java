import java.util.Scanner;

public class B {
    static Scanner sc = new Scanner(System.in);
    static StringBuilder out = new StringBuilder();
    public static void main(String[] args){
        int t = sc.nextInt();
        while (t-->0){
            int n = sc.nextInt();
            int m = sc.nextInt();
            boolean flag = false;
            for (int i=0;i<n;i++){
                int a = sc.nextInt();
                int b = sc.nextInt();
                int c = sc.nextInt();
                int d = sc.nextInt();
                if (b==c){
                    flag = true;
                }
            }
            if (m%2==1){
                out.append("NO"+"\n");
            }else {
                if (flag){
                    out.append("YES"+"\n");
                }else {
                    out.append("NO"+"\n");
                }

            }
        }
        System.out.println(out);
    }
}
