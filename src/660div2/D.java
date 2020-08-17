import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class D {
    static Scanner sc;
    static boolean[] used ;
    static long[] a;
    static int[] b;
    static long ans;
    static Map<Integer, ArrayList<Integer>> KeyMap = new HashMap<>();
    static StringBuilder mainStep;
    public static void main(String[] arg){
        sc = new Scanner(System.in);
        int n = sc.nextInt();
        used = new boolean[n+1];
        mainStep = new StringBuilder();
        a = new long[n+1];
        b = new int[n+1];
        ans = 0;
        for (int i=1;i<n+1;i++){
            a[i] = sc.nextInt();
        }
        for (int i=1;i<n+1;i++){
            b[i] = sc.nextInt();
        }

        for (int i=1;i<n+1;i++){
            if (b[i]!=-1){
                if (KeyMap.get(b[i])==null){
                    KeyMap.put(b[i],new ArrayList<>());
                    KeyMap.get(b[i]).add(i);
                }else {
                    KeyMap.get(b[i]).add(i);
                }
            }
        }
       // System.out.println(KeyMap.keySet().toString());
        for (int i=1;i<n+1;i++){
                if (b[i]==-1&&KeyMap.containsKey(i)){
                  //  System.out.println("init search:"+i);
                    Search(i);
                    mainStep.append(" "+i);
                    AppendNegative(i);
                    used[i] = true;
                }

        }
        for (int i=1;i<n+1;i++){
            if (!used[i]){
                mainStep.append(" "+i);
            }
        }
        for (int i=1;i<n+1;i++){
            ans += a[i];
        }
        System.out.println(ans);
        System.out.println(mainStep);
    }
    private static void Search(int i){
      //  System.out.println("searching:"+i);
        if (KeyMap.containsKey(i)){
            ArrayList<Integer> tmp = KeyMap.get(i);
            for (int j=0;j<tmp.size();j++){
                int node = tmp.get(j);
              //  System.out.println("Node:"+node);
                Search(node);
                if (a[node]>=0){
                    a[i]+=a[node];
                    mainStep.append(" "+node);
                    used[node] = true;
                }
            }
        }
    }
    private static void AppendNegative(int i){
        if (KeyMap.containsKey(i)){
            ArrayList<Integer> tmp = KeyMap.get(i);
            for (int j=0;j<tmp.size();j++){
                if (a[tmp.get(j)]<0){
                    mainStep.append(" "+tmp.get(j));
                    used[tmp.get(j)] = true;
                }
                AppendNegative(tmp.get(j));

            }
        }


    }

}

/**
 *
 * 1+3+6
 *
 *  1 2 3               1 2 3 4
 *  2 3 -1              2 3 4 5
 *  1 1+2 1+2 3
 *                  ans +=    search 4
 *                  ans +=    3+search3
 *                  ans +=   2+search2
 *                  ans +=   1+search1
 *  search 3
 *         2 +1
 *  search 2
 *         1
 *
 *  1
 *  3
 *
 *  1+1+2+3
 *
 *   2 1 3
 *
 *
 *
 *
 *
 * */