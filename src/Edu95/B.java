import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class B {
    static Scanner sc = new Scanner(System.in);
    static StringBuilder output = new StringBuilder();
    public static void main(String[] args){
        int t = sc.nextInt();
        while (t-- >0){
            int n = sc.nextInt();
            int[] a = new int[n];
            boolean[] lock = new boolean[n];
            for (int i=0;i<n;i++){
                a[i] = sc.nextInt();
            }
            for (int i=0;i<n;i++){
                int l = sc.nextInt();
                if (l==1){
                    lock[i] = true;
                }else {
                    lock[i] = false;
                }
            }
            ArrayList<Integer> unlocked = new ArrayList<>();
            for (int i=0;i<n;i++){
                if (!lock[i]){
                    unlocked.add(a[i]);
                }
            }
            Collections.sort(unlocked);
            int[] out = new int[n];
            for (int i = n-1;i>=0;i--){
                if (lock[i]){
                    out[i] = a[i];
                }else {
                    out[i] = unlocked.remove(0);
                }
            }
            int[] prefix = new int[n];
            prefix[0] = out[0];
            for (int i=1;i<n;i++){
                prefix[i] = prefix[i-1]+out[i];
            }
            for (int i=0;i<n;i++){
                output.append(out[i]+" ");
            }
            output.append("\n");
           /* output.append("TEST: ");
            for (int i=0;i<n;i++){
                output.append(prefix[i]+" ");
            }
            output.append("\n");

            */
        }
        System.out.println(output);
    }
}

//         sum of i - n element + sum of 0-i element =  sum
//         n -