import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.spi.AbstractResourceBundleProvider;

public class E1 {
    static Scanner sc;
    static int[] RootEdgew;
    static long S;
    static int n;
    static V[] V;
    static int[] RootEdgew2;
    static PriorityQueue<W> MaxWHeap;
    public static void main(String[] args){
        sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i=0;i<n;i++){
            Solve();
        }
    }
    private static void Solve(){
        n = sc.nextInt();
        S = sc.nextLong();
        RootEdgew = new int[n+1];
        RootEdgew2 = new int[n+1];
        V = new V[n+1];
        for (int i=0;i<n;i++){
            V[i] = new V();
        }
        long sumw =0;
        for (int i=0;i<n;i++){
            int v = sc.nextInt();
            int u = sc.nextInt();
            int w = sc.nextInt();
            sumw += w;
            addEdge(v,u,w);
        }
        RootEdgew[1] = 0;
        dfs(1,-1);
        MaxWHeap = new PriorityQueue<>();
        int counter = 0;
        System.out.println(sumw);
        System.out.println(counter);
    }
    private static void dfs(int v,int root){
        int w = 1;
        for (int i=0;i<V[v].Edge.size();i++){
            int Leaf = V[v].Edge.get(i).V;
            if (Leaf!=root){
                dfs(Leaf,v);
                RootEdgew[Leaf] = V[v].Edge.get(i).w;
            }
            w += RootEdgew2[Leaf];
        }
        RootEdgew2[v] = w;
        MaxWHeap.add(new W(RootEdgew[v],w));
    }
    private static void addEdge(int a,int b,int w){
        V[a].addEdge(new E(b,w));
        V[b].addEdge(new E(a,w));
    }
    private static void UpdateWb(){
        MaxWHeap.peek().Update();
    }

}
class V{
    ArrayList<E> Edge;
    public V(){
        Edge = new ArrayList<>();
    }
    public void addEdge(E e){
        Edge.add(e);
    }

}
class E{
    int V;
    int w;
    public E(int V,int w)
    {
        this.V = V;
        this.w = w;
    }

}
class W implements Comparable {
    int b;
    int w1;
    int w2;
    public W(int w1,int w2){
        this.w1 = w1;
        this.w2 = w2;
    }
    public void Update(){
        b = (w1/2)*w2;
    }

    @Override
    public int compareTo(Object o) {
        if (b>((W)o).b){
            return -1;
        }else if (b<((W)o).b){
            return 1;
        }else {
            return 0;
        }
    }
}


/***
 *
 *
 *
 *
 *  4*4 16/8 = 8
 *  3*5 15
 *
 *
 *
 *
 *
 *
 *
 * */