import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class C {
    static Scanner sc = new Scanner(System.in);
    static V[] graph;
    static int[] MaxEdge;
    static int[] MaxEdgeIndex;
    public static void main(String[] args) throws IOException {
        int t = sc.nextInt();
        while (t-- > 0){
            int n = sc.nextInt();
            graph = new V[n+1];
            MaxEdge = new int[n+1];
            MaxEdgeIndex = new int[n+1];
            for (int i=0;i<n+1;i++){
                graph[i] = new V();
            }
            for (int i=0;i<n-1;i++){
                addEdge(sc.nextInt(),sc.nextInt());
            }
            dfs(1,-1);
            int min = Integer.MAX_VALUE;
            int index = 0;

            for (int i=1;i<n+1;i++){
              //  System.out.println("i");
                if (MaxEdge[i]<min){
                    min = MaxEdge[i];
                    index = i;
                }
            }
       //     System.out.println("?");
            if (min==1){
                int invokeIndex = MaxEdgeIndex[index];
                System.out.println(index+" "+invokeIndex);
                System.out.println(index+" "+invokeIndex);
            }else {
                int invokeIndex = MaxEdgeIndex[index];
                int invokeIndex2 = 0;
                for (int i = 0; i < graph[invokeIndex].Edges.size(); i++) {
                    if (graph[invokeIndex].Edges.get(i) != index) {
                        invokeIndex2 = graph[invokeIndex].Edges.get(i);
                    }
                }
                System.out.println(invokeIndex+" "+invokeIndex2);
                System.out.println(index+" "+invokeIndex2);
            }
        }
    }
    public static int dfs(int node,int lastNode){
        int nodeCounter = 0;
        int MaxNode = -1;
        int MaxNodeIndex = -1;
        for (int i=0;i<graph[node].Edges.size();i++){
           if (graph[node].Edges.get(i)!=lastNode){
               int Nodes = dfs(graph[node].Edges.get(i),node)+1;
               if (Nodes>MaxNode){
                   MaxNode = Nodes;
                   MaxNodeIndex = graph[node].Edges.get(i);
               }
               nodeCounter += Nodes;
           }
        }
        int fatherNodeCounter = graph.length-2-nodeCounter;
        if (fatherNodeCounter>MaxNode){
            MaxNode = fatherNodeCounter;
            MaxNodeIndex = lastNode;
        }
        MaxEdge[node] = MaxNode;
        MaxEdgeIndex[node] = MaxNodeIndex;
        return nodeCounter;
    }
    public static void addEdge(int i,int j){
        graph[i].add(j);
        graph[j].add(i);
    }
}

class  V{
    public ArrayList<Integer> Edges;
    public V(){
        this.Edges = new ArrayList<>();
    }
    public void add(int v){
        this.Edges.add(v);
    }
}
