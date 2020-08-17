import java.util.ArrayList;
import java.util.Scanner;

public class B {
    static Scanner sc;
    static boolean flag;
    static int[] depth;
    static int[] high;
    static ArrayList<Integer> safe;
    static int n;
    static int k;
    static int l;
    public static void main(String[] args){
        sc = new Scanner(System.in);
        int Case = sc.nextInt();
        for (int i=0;i<Case;i++){
            Solve();
        }
    }
    private static void Solve(){
         n = sc.nextInt(); // number of meter of sesa
         k = sc.nextInt(); // cycle of tide
         l = sc.nextInt(); // max depth
        depth = new int[n];
        high = new int[n];
        safe = new ArrayList<>();
        safe.add(-1);
        for (int i=0;i<n;i++){
            depth[i] = sc.nextInt();
            if (depth[i]+k<=l){
                safe.add(i);
                //System.out.println(" add "+i);
            }
        }
        safe.add(n);
        flag = true;
       System.out.println("pairs: ");
        for (int i=1;i<safe.size();i++){
            System.out.print(safe.get(i)+" "+safe.get(i-1)+"|");
            if (safe.get(i)-safe.get(i-1)>1){
               if (!VerifyMax(safe.get(i-1),safe.get(i))&&!VerifyCenter(safe.get(i-1),safe.get(i))){
                 //  System.out.println("Return False");
                   flag = false;
                   break;
               }
            }
        }
        if (flag){
            System.out.println("YES");
        }else {
            System.out.println("NO");
        }


    }
    private static boolean VerifyMax(int start,int end){
        boolean localflag = true;
        int M = localMax(start,end);
        for (int i=M;i<end;i++)
        {
            high[i] = depth[i]+change(i-M);
        }
        for (int i=M;i>start;i--){
            high[i] = depth[i]+change(Math.abs(i-M));
        }
         //System.out.print("High:");
        for (int i=start+1;i<end;i++){
            //System.out.print("|"+i+":"+high[i]+" ");
            if (high[i]>l){
                localflag = false;
            }
        }
        return localflag;
    }
    private static boolean VerifyCenter(int start,int end){
        boolean localflag = true;
        int M = (start+end)/2;
        for (int i=M;i<end;i++)
        {
            high[i] = depth[i]+change(i-M);
        }
        for (int i=M;i>start;i--){
            high[i] = depth[i]+change(Math.abs(i-M));
        }
          System.out.print("High:");
        for (int i=start+1;i<end;i++){
             System.out.print("|"+i+":"+high[i]+" ");
            if (high[i]>l){
                localflag = false;
            }
        }
        return localflag;
    }
    private static int LocalCenter(int start,int end){
        int center = start+1;
        for (int i=start+2;i<end;i++){
            if (depth[i]>depth[max]){
                max=i;
            }
        }
        return max;
    }
    private static int change(int offset){
        int r = offset%(2*k);
        if (r>k) {
            r = k - (r - k);
        }else {
        }
        return r;
    }
}



/**
 *  2 3 4 5 6
 *  0 1 2 3 2 1
 *  k*2-1
 *  %2k
 *   >k
 *   <k +
 *   k+(r-k)
 *   k-(r-k)

 *  1 2 1
 * 1 0
 * 0 1 0
 *
 *
 *
 *  1 2 3 2 2
 *      0
 *      1
 *      2
 *      3
 *      2
 *      1
 *      2 2 2 2 2
 *      1 0 1 2
 *      0 1 0
 *
 *      2 1 0 1
 *
 *
 *   3 2 1 0 1 2 3
 *
 */