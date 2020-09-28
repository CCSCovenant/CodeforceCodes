import java.lang.ref.PhantomReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class D {
    static Scanner sc = new Scanner(System.in);
    static ArrayList<Integer>[] G;
    static long[] k;
    static ArrayList<Long> E;
    static int n;
    static int mod = 1000000007;

    public static void main(String[] args){
        int n = sc.nextInt();
        for (int i=0;i<n;i++){
            Solve();
        }
    }
    private static void Solve(){
        n = sc.nextInt();
        G = new ArrayList[n+1];
        E = new ArrayList<>();
        for (int i=0;i<n-1;i++){
            int node1 = sc.nextInt();
            int node2 = sc.nextInt();
            add2(node1,node2);
            add2(node2,node1);
        }
        int p = sc.nextInt();
        k = new long[p];
        for (int i=0;i<p;i++){
            k[i] = sc.nextInt();
        }
        dfs(-1,1);
        Arrays.sort(k);
        Collections.sort(E);
        long ans = 0;
        long [] fac = new long[n-1];
        Arrays.fill(fac,1);
       // System.out.println(n);
       // System.out.println(p);
        //System.out.println();
        if (p<=n-1){
            for (int i=p-1,j=n-2;i>=0;i--,j--){
                fac[j] = k[i];
            }
        }else{
            for (int i=0;i<p;i++){
                int j = Math.min(i,n-2);
                fac[j] = fac[j]*k[i]%mod;
            }
        }

        for (int i=n-2;i>=0;i--){
            ans += fac[i]*E.get(i)%mod;
            ans %= mod;
        }
        System.out.println(ans);

    }

    private static void add2(int node1,int node2){
        if (G[node1]!=null){
            G[node1].add(node2);
        }else {
            G[node1] = new ArrayList();
            G[node1].add(node2);
        }
    }
    private static int dfs(int root, int node){
        int size = 1;
        for (int i=0;i<G[node].size();i++){
            if (G[node].get(i)!=root){
               int subsize = dfs(node,G[node].get(i));
                E.add((long)subsize*(long)(n-subsize));
                size += subsize;
            }
        }

        return size;
    }
}
/*
10
16
5 10
16 1
14 1
7 5
13 2
16 11
1 7
1 4
3 14
8 16
1 6
4 9
4 12
5 13
1 15
18
45893 9901 51229 15511 46559 28433 4231 30241 29837 34421 12953 6577 12143 52711 40493 89 34819 28571
*
*
* */