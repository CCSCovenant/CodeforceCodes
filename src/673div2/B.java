import java.util.Scanner;

public class B {
    static Scanner sc = new Scanner(System.in);
    static StringBuilder out = new StringBuilder();
    public static void main(String[] args){
        int t = sc.nextInt();
        while (t-->0) {
            int n = sc.nextInt();
            int T = sc.nextInt();
            int[] a = new int[n];
            for (int i=0;i<n;i++){
                a[i] = sc.nextInt();
            }
            if (T % 2 == 0) {
                int p = T/2;
                boolean flag = true;
                for (int i=0;i<n;i++){
                    if (a[i]==p){
                        if (flag){
                            out.append(1+" ");
                        }else {
                            out.append(0+" ");
                        }
                        flag = !flag;
                    }else if (a[i]>p){
                        out.append(1+" ");
                    }else {
                        out.append(0+" ");
                    }
                }
                out.append("\n");
            }else {
                int p = T/2;
                for (int i=0;i<n;i++) {
                    if (a[i] > p) {
                        out.append(1 + " ");
                    } else {
                        out.append(0 + " ");
                    }
                }
                out.append("\n");
            }
        }
        System.out.println(out);
    }
}
//  T= 8 ,  4 3 3