import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;

public class RemovingLeaves {
    static V[] graph;
    static ArrayList<V> subLeaf;
    public  static  void  main(String args[]){
        Scanner sc = new Scanner(System.in);
        int Case = sc.nextInt();
        for (int i=0;i<Case;i++){
            Solve(sc);
        }
    }
    public static void Solve(Scanner sc){
        int n = sc.nextInt();
        int k = sc.nextInt();
        int movement = 0;
        graph = new V[n];
        subLeaf = new ArrayList<>();
        boolean flag = true;
        for (int i=0;i<n;i++){
            if (graph[i]!=null){
                graph[i].addedge(sc.nextInt());
                graph[i].setleaf(false);
            }else {
                graph[i] = new V(i);
                graph[i].addedge(sc.nextInt());
                graph[i].setleaf(true);
            }
        }
        while (flag){
            update(n);
            int tmp = k;
            for (int i=0;i<subLeaf.size();i++){
                if (tmp>=subLeaf.get(i).getEdgecounter()-1){
                    tmp -= (subLeaf.get(i).getEdgecounter()-1);
                    for (int j=0;j<subLeaf.get(i).Edge.size();j++){
                        if (graph[subLeaf.get(i).Edge.get(j)].isleaf()){
                            subLeaf.get(i).removeedge(j);
                        }
                    };
                    subLeaf.get(i).setleaf(true);
                }else if (tmp==0){
                    break;
                }else {
                    tmp =0;
                    for (int j=0;j<tmp;j++){
                        if (graph[subLeaf.get(i).Edge.get(j)].isleaf()){
                            subLeaf.get(i).removeedge(j);
                        }
                    };
                }
            }
            if (tmp>0){
                break;
            }
            movement++;
        }
        System.out.println(movement);


    }
    public static void update(int n){
        for (int i=0;i<n;i++){
            if (!graph[i].isleaf){
                int counter = 0;
                for (int j=0;i<graph[i].Edge().size();j++){
                    if (!graph[graph[i].Edge.get(j)].isleaf){
                        counter++;
                    }
                }
                if (counter==1){
                    for (int j=0;i<subLeaf.size();j++){
                        if (subLeaf.get(i).getEdgecounter()>graph[i].getEdgecounter()){
                            subLeaf.add(i,graph[i]);
                            break;
                        }
                    }
                }
            }
        }
    }


}
class V implements Comparable{
    ArrayList<Integer> Edge;
    int edgecounter;
    int id;
    boolean isleaf;
    public V(int id){
        this.id = id;
        this.Edge = new ArrayList<>();
        this.isleaf =false;
    }
    public int getId(){
        return id;
    }
    public void addedge(int n){
        this.Edge.add(n);
        edgecounter++;
    }
    public void removeedge(int n){
        this.Edge.remove(n);
        edgecounter--;
    }
    public int getEdgecounter(){
        return this.edgecounter;
    }

    public void setleaf(boolean subroot) {
        isleaf = subroot;
    }
    public ArrayList Edge(){
        return this.Edge;
    }

    public boolean isleaf() {
        return isleaf;
    }

    @Override
    public int compareTo(Object o) {
        if (this.getEdgecounter()> ((V)(o)).getEdgecounter()){
            return 1;
        }else if (this.getEdgecounter()< ((V)(o)).getEdgecounter()){
            return -1;
        }else{
            return 0;
        }
    }
}
