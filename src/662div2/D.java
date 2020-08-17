import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class D {
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
            maxsize[i][0]=1;
            maxsize[i][m-1]=1;
        }
        for (int i=0;i<m;i++){
            maxsize[0][i]=1;
            maxsize[n-1][i]=1;
        }
        if (n==1){
            ans = m;
        }else if (m==1){
            ans = n;
        }else {
            ans = 2*(m+n)-4;
        }
        for (int x=1;x<n-1;x++){
            for (int y=1;y<m-1;y++){
                if (a[x-1][y]!=a[x][y]||a[x][y-1]!=a[x][y]){
                    maxsize[x][y]=1;
                }else {
                    if (maxsize[x-1][y]>maxsize[x][y-1]){
                        maxsize[x][y] = findMaxsize(x,y,a[x][y], maxsize[x][y-1],maxsize[x-1][y]-1);
                    }else {
                        maxsize[x][y] = findMaxsize(x,y,a[x][y], maxsize[x-1][y],maxsize[x][y-1]-1);
                    }
                }
                ans += maxsize[x][y];
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
    private static int findMaxsize(int x, int y, char c, int upbound,int lowbound){
        int dx;
        int dy;
        for (int i=lowbound;i<=upbound;i++){
            dx = i;
            dy = 0;
            if (x+i>=n||y+i>=m){
                return i;
            }
            while (dx>=0){
                if (a[x+dx][y+dy]!=c){
                    return i;
                }
                else {
                    dx--;
                    dy++;
                }
            }
        }
        return upbound;
    }


}
