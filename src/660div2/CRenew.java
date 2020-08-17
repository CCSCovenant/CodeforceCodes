import java.util.ArrayList;
import java.util.Scanner;

public class CRenew {
    static Scanner sc;
    static City[] Citys;
    static int[] vPop;
    static boolean Flag;
    public static void main(String[] arg){
        sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i=0;i<n;i++){
            Solve();
        }
    }
    private static void Solve(){
        int n = sc.nextInt()+1;
        int m = sc.nextInt();
        Citys = new City[n];
        vPop = new int[n];
        Flag = true;
        for (int i=1;i<n;i++){
            Citys[i] = new City();
            Citys[i].pop = sc.nextInt();
        }
        for (int i=1;i<n;i++){
            Citys[i].happy = sc.nextInt();
        }
        for (int i=0;i<n-2;i++){
            addEdge(sc.nextInt(),sc.nextInt());
        }
        DFS(1,-1);
        if (Flag){
            System.out.println("YES");
        }else {
            System.out.println("NO");
        }

    }
    private static void DFS(int c, int root){
        vPop[c] = Citys[c].pop;
        int sumh = 0;
        for (int i=0;i<Citys[c].Edge.size();i++){
            int leaf = Citys[c].Edge.get(i);
            if (leaf!=root){
               // System.out.println("Leaf:"+leaf+"|Root:"+root);
                DFS(leaf,c);
                sumh += Citys[leaf].happy;
                vPop[c] += vPop[leaf];
            }
        }
        if ((vPop[c]+Citys[c].happy)%2!=0){
            Flag = false;
        }
        if (Citys[c].happy>vPop[c]||Citys[c].happy<-vPop[c]){
            Flag = false;
        }
        if (sumh-Citys[c].pop>Citys[c].happy){
            Flag = false;
        }
    }
    public static void addEdge(int i, int e){
        Citys[i].addEdge(e);
        Citys[e].addEdge(i);
    }

}
class City{
    ArrayList<Integer> Edge = new ArrayList<>();
    int pop;
    int happy;
    public City(){

    }
    public void addEdge(int n){
        Edge.add(n);
    }

}
