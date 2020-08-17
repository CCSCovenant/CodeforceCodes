import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class ReadingBooksE2 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();
        PriorityQueue <book> libA = new PriorityQueue();
        PriorityQueue <book> libB = new PriorityQueue();
        PriorityQueue <book> libAB = new PriorityQueue();
        PriorityQueue <book> libC = new PriorityQueue();

        for (int i=0;i<n;i++){
            short book = sc.nextShort();
            int A = sc.nextInt();
            int B = sc.nextInt();
            if (A==1&&B==1){
                libAB.add(new book(book,i));
            }else if (A==1){
                libA.add(new book(book,i));
            }else if (B==1){
                libB.add(new book(book,i));
            }else {
                libC.add(new book(book,i));
            }
        }
        String res = "";
        long Tsum = 0;
        if (libAB.size()+Math.min(libA.size(),libB.size())<k){
            System.out.println(-1);
        }else {
            for (int i = 0; i < k; i++) {
                short minAB = libAB.peek().getT();
                short minA = libA.peek().getT();
                short minB = libB.peek().getT();
                if (libA.isEmpty() || libA.isEmpty()) {
                    Tsum += minAB;
                    res += libAB.poll().getI()+" ";
                } else {
                    if (libAB.isEmpty()) {
                        Tsum += minA + minB;
                        res += libA.poll().getI()+" ";
                        res += libB.poll().getI()+" ";
                    } else if (minA + minB < minAB) {
                        Tsum += minA + minB;
                        res += libA.poll().getI()+" ";
                        res += libB.poll().getI()+" ";
                    } else {
                        Tsum += minAB;
                        res += libAB.poll().getI()+" ";
                    }
                }
            }
            book end;
            for (int i=k+1; i<m;i++){
                end = PoolMin(libA,libAB,libB,libC);
                Tsum += end.getT();
                res += end.getI()+" ";
            }
            System.out.println(Tsum);
            System.out.println(res);
        }
    }
    public static book PoolMin(PriorityQueue A,PriorityQueue B,PriorityQueue C,PriorityQueue D){
        short A1 = 10001;
        short B1 = 10001;
        short C1 = 10001;
        short D1 = 10001;
        if (!A.isEmpty()){
            A1 = ((book)A.peek()).T;
        }
        if (!B.isEmpty()){
            B1 = ((book)B.peek()).T;
        }
        if (!C.isEmpty()){
            C1 = ((book)C.peek()).T;
        }
        if (!D.isEmpty()){
            D1 = ((book)D.peek()).T;
        }
        switch (findmin(A1,B1,C1,D1)){
            case 0: return (book) A.poll();
            case 1: return (book) B.poll();
            case 2: return (book) C.poll();
            case 3: return (book) D.poll();
            default: return null;
        }
    }
    public static byte findmin(short A, short B, short C,short D){
        int min = Math.min(Math.min(A,B),Math.min(C,D));
        if (min==A){
            return 0;
        }else if (min==B){
            return 1;
        }else if (min==C){
            return 2;
        }else {
            return 3;
        }
    }


}
class book implements Comparable{
    short T;
    int i;
    public book(short T,int i){
        this.T = T;
        this.i = i;
    }
    public int getI() {
        return i+1;
    }
    public short getT() {
        return T;
    }

    @Override
    public int compareTo(Object o) {
        if (T>((book)o).getT()){
            return 1;
        }else if (T<((book)o).getT()){
            return -1;
        }else {
            return 0;
        }
    }
}
