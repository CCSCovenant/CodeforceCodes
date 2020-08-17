import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class D {
    static Scanner sc = new Scanner(System.in);
    static long ans;
    static PriorityQueue <Integer> R = new PriorityQueue<Integer>((o1, o2) -> o2.compareTo(o1));
    static PriorityQueue <Integer> G = new PriorityQueue<Integer>((o1, o2) -> o2.compareTo(o1));
    static PriorityQueue <Integer> B = new PriorityQueue<Integer>((o1, o2) -> o2.compareTo(o1));
    public static void main(String[] args){
            Solve();
    }
    private static void Solve(){

        int lr = sc.nextInt();
        int lg = sc.nextInt();
        int lb = sc.nextInt();
        for (int i=0;i<lr;i++){
            R.add(sc.nextInt());
        }
        for (int i=0;i<lg;i++){
            G.add(sc.nextInt());
        }
        for (int i=0;i<lb;i++){
            B.add(sc.nextInt());
        }
        ans =0;
        while (BtoI(R.isEmpty())+BtoI(G.isEmpty())+BtoI(B.isEmpty())>1){
            ans+=getP();
        }
        System.out.println(ans);
    }
    private static int BtoI(boolean flag){
        if (flag){
            return 0;
        }else {
            return 1;
        }
    }
    private static long getP(){
        long res = 0;
        if (R.isEmpty()){
            res = G.poll()*B.poll();
            return res;
        }
        if (G.isEmpty()){
            res = R.poll()*B.poll();
            return res;
        }
        if (B.isEmpty()){
            res = G.poll()*R.poll();
            return res;
        }
        int min = Math.min(Math.min(R.peek(),G.peek()),B.peek());
        if (min==R.peek()){
            res = G.poll()*B.poll();
        }else if (min==G.peek()){
            res = R.poll()*B.poll();
        }else {
            res = G.poll()*R.poll();
        }
        return res;
    }

}
/*
*
* 2 2 2 3
* 3 3 3
* 2 2
*
*  3 3
*  3 3                3*1+*3*1+3*3
*                          3*3+3*3
*  1 1
*  3*3
*  3*3
*
*  3*2+3*2+3*3

  *
*
* */