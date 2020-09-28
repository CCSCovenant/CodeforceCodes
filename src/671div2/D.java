import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.TreeMap;

public class D {
    static Scanner sc = new Scanner(System.in);
    static TreeMap<Integer,Integer> c;
    static StringBuilder output = new StringBuilder();
    public static void main(String[] args) throws IOException {
        int n = sc.nextInt();
         c = new TreeMap<>();
        int[] ans = new int[n];
        for (int i=0;i<n;i++){
            int in = sc.nextInt();
            if (c.get(in)==null){
                c.put(in,1);
            }else {
                c.put(in,c.get(in)+1);
            }
        }
        for(int i=1;i<n;i+=2){
            ans[i] = getLowest();
        }
        for (int i=0;i<n;i+=2){
            if (i<n-1){
                ans[i] = getLowestPossible(ans[i+1]);
            }else {
                ans[i] = getLowest();
            }
        }


        int num = 0;
        for (int i=1;i<n-1;i+=2){
            if (ans[i]<ans[i+1]&&ans[i]<ans[i-1]){
                num++;
            }
        }
        output.append(num+"\n");
        for (int i=0;i<n;i++){
            output.append(ans[i]+" ");
        }
        System.out.println(output);
    }
    public static int getLowest(){
        int n = c.firstKey();
        if (c.get(n)>1){
            c.put(n,c.get(n)-1);
        }else {
            c.remove(n);
        }
        return n;
    }
    public static int getLowestPossible(int x){
        Integer n = c.higherKey(x);
        if (n==null){
            return getLowest();
        }else {
            if (c.get(n)>1){
                c.put(n,c.get(n)-1);
            }else {
                c.remove(n);
            }
        }
        return n;
    }

}

// 1 1 2 2 2 2 4

//     2 1 2 2 4 1 2
//     010101
      // 01010
// n-3
// 1