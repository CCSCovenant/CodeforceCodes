import java.util.Scanner;

public class E {
    static Scanner sc = new Scanner(System.in);
    static long[][] A;
    static boolean[][] B;
    static int n;

    public static void main(String[] args) {
        n = sc.nextInt();
        A = new long[n][n];
        B = new boolean[n][n];
        StringBuilder R1 = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                B[i][j] = i % 2 == 0;
                if (B[i][j]) {
                    A[i][j] = 1L << (i + j);
                } else {
                    A[i][j] = 0;
                }
                R1.append(A[i][j] + " ");
            }
            R1.append("\n");
        }
        System.out.println(R1);
        System.out.flush();
        int q = sc.nextInt();
        for (int i = 0; i < q; i++) {
            Solve();
        }
    }

    private static void Solve() {
        long ans = sc.nextLong();
        StringBuilder RQ = new StringBuilder();
        int xi = 0;
        int yi = 0;

        RQ.append((xi+1)+" "+(yi+1)+"\n");
        for (int i=0;i<2*(n-1);i++){
            if (xi<n-1&&yi<n-1){
                if (getBit(ans,i)==B[xi][yi+1]){
                    yi++;
                }else {
                    xi++;
                }
                RQ.append((xi+1)+" "+(yi+1)+"\n");
            }else {
                if (xi<n-1){
                    xi++;
                    RQ.append((xi+1)+" "+(yi+1)+"\n");
                }else {
                    yi++;
                    RQ.append((xi+1)+" "+(yi+1)+"\n");
                }
            }
        }
        System.out.println(RQ);
        System.out.flush();
    }
    private static boolean getBit(long n,long bit){
        return ((n>>(bit+1))&1)==1;
    }
}