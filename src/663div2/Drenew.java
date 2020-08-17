import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Drenew {
    static Scanner sc = new Scanner(System.in);
    static int m;
    static int n;
    static char[][] a;
    static int[][] maxsize;
    static long ans = 0;

    public static void main(String args[]) throws IOException {
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(f.readLine());
        n = Integer.parseInt(tokenizer.nextToken());
        m = Integer.parseInt(tokenizer.nextToken());
        a = new char[n][m];
        maxsize = new int[n][m];
        for (int i=0;i<n;i++){
            a[i] = f.readLine().toCharArray();
        }
        for (int i=0;i<n;i++){
            for (int j=0;j<m;j++){
                maxsize[i][j] = 1;
            }
        }

        for (int x=2;x<n;x++){
            for (int y=1;y<m-1;y++ ){
                char c = a[x][y];
                if (c == a[x-1][y]&&c==a[x-1][y-1]&&c==a[x-1][y+1]&&c==a[x-2][y]){
                    maxsize[x][y]=Math.min(Math.min(maxsize[x-1][y-1],maxsize[x-1][y+1]),maxsize[x-2][y])+1;
                }
            }
        }
        for (int i=0;i<n;i++){
            for (int j=0;j<m;j++){
                ans += maxsize[i][j];
            }
        }
        /**
         *   for (int x=0;x<n;x++){
         *             for (int y=0;y<m;y++){
         *                 System.out.print(maxsize[x][y]+" ");
         *             }
         *             System.out.println();
         *         }
         **/
        System.out.println(ans);
    }
}