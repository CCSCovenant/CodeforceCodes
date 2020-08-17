import java.util.ArrayList;
import java.util.Scanner;
/*
public class C {
    static Scanner sc;
    static Node[] Nodes ;
    public static void main(String[] arg){
        sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i=0;i<n;i++){
            /**   if (i==59){
             String c = "";
             int x = sc.nextInt();
             int y = sc.nextInt();
             c += x+"|"+y+"|a:";
             for (int j=0;j<x;j++){
             c+= sc.nextInt()+",";
             }
             c += "|b:";
             for (int j=0;j<x;j++){
             c+= sc.nextInt()+",";
             }
             for (int j=0;j<x-1;j++){
             c+= "e:"+sc.nextInt()+"|"+sc.nextInt()+",";
             }
             System.out.println(c);

             }
            Solve();

        }
    }
    public static void Solve(){
        int n = sc.nextInt()+1;
        int m = sc.nextInt();
        Nodes = new Node[n];
        for (int i=1;i<n;i++){
            Nodes[i] = new Node();
            Nodes[i].pop = sc.nextInt();
        }
        for (int i=1;i<n;i++){
            Nodes[i].happy = sc.nextInt();
        }
        for (int i=0;i<n-2;i++){
            addEdge(sc.nextInt(),sc.nextInt());
        }
        if (CheckNonLeaf(1,-1)&&!(Nodes[1].happy>m||Nodes[1].happy<-m)&&(m-Nodes[1].happy)%2==0){
            System.out.println("YES");
        }else {
            System.out.println("NO");
        }



    }
    public static boolean CheckNonLeaf(int node,int lastNode){
        int totalHappy = 0;
        boolean flag = true;
        Node subNode;
        ArrayList<Integer> uncheckedNonLeafNode = new ArrayList<>();
        for (int i=0;i<Nodes[node].Edge.size();i++){
            if (Nodes[node].Edge.get(i)!=lastNode) {
                subNode = Nodes[Nodes[node].Edge.get(i)];
              //  System.out.println("Checking:"+Nodes[node].Edge.get(i));
                totalHappy += subNode.happy;
                flag = CheckLeafNode(Nodes[node].Edge.get(i), node);
                if (!flag) {
                    return flag;
                }
                if (!subNode.isLeaf) {
                    uncheckedNonLeafNode.add(Nodes[node].Edge.get(i));
                }
                if (!flag) {
                    return flag;
                }
            }
        }
         // System.out.println("TotalHappy:"+totalHappy);
        if (totalHappy-Nodes[node].pop>Nodes[node].happy){
            return !flag;
        }
        for (int i=0;i<uncheckedNonLeafNode.size();i++){
            flag = CheckNonLeaf(uncheckedNonLeafNode.get(i),node);
            if (!flag){
                return flag;
            }
        }
        return flag;
    }
    public static boolean CheckLeafNode(int node,int lastnode){
        int localpop = getPop(node,lastnode);
        int localhappy = Nodes[node].happy;
        // System.out.println("Node:"+node+" Pop:"+localpop+"Happy:"+Nodes[node].happy);
        if (localhappy>localpop||localhappy<-localpop||(localpop-localhappy)%2!=0){
            return false;
        }else {
            return true;
        }
    }

    public static int getPop(int i, int lastnode){
        if (Nodes[i].isLeaf){
            return Nodes[i].pop;
        }else {
            int subPop = Nodes[i].pop;
            for (int j=0;j<Nodes[i].Edge.size();j++){
                if (Nodes[i].Edge.get(j)!=lastnode){
                    subPop += getPop(Nodes[i].Edge.get(j),i);
                }
            }
            return subPop;
        }
    }
    public static void addEdge(int i, int e){
        Nodes[i].addEdge(e);
        Nodes[e].addEdge(i);
    }
}

class Node{
    ArrayList<Integer> Edge = new ArrayList<>();
    int pop;
    int happy;
    boolean isLeaf;
    public Node(){
        this.isLeaf = true;

    }
    public void addEdge(int n){
        Edge.add(n);
        if (this.Edge.size()>1){
            isLeaf = false;
        }
    }
}
*/