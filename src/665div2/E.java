import java.util.Arrays;
import java.util.Scanner;

public class E {
    static Scanner sc = new Scanner(System.in);
    static  Segment[] H;
    static  Segment[] V;
    static long[] tag;
    static long[] seg;
    public static void main(String[] args){
        int numH = sc.nextInt();
        int numV = sc.nextInt();
        seg = new long[4*numH];
        tag = new long[4*numH];
        H = new Segment[numH];
        V = new Segment[numV];
        for (int i=0;i<numH;i++){
            H[i] = new Segment(sc.nextInt(),sc.nextInt(),sc.nextInt());
        }
        for (int i=0;i<numV;i++){
            V[i] = new Segment(sc.nextInt(),sc.nextInt(),sc.nextInt());
        }
        Arrays.sort(H);
        Arrays.sort(V);
    }
    private static void build(int s,int t,int i){
        if (s == t){
            seg[i] = a[s-1];
            return;
        }
        int m = (s+t)/2;
        build(s,m,i*2);
        build(m+1,t,i*2+1);
        seg[i] = seg[i*2]+seg[i*2+1];
    }
    private static void Update(int l,int r,int c,int s,int t,int i){
        if (l <=s &&r >= t){
            seg[i] += (t-s+1)*c;
            tag[i] += c;
            return;
        }
        if (tag[i]>0){
            seg[i*2] += tag[i]*(m-s+1);
            seg[i*2+1] += tag[i]*(t-m);

            tag[i*2] += tag[i];
            tag[i*2+1] += tag[i];
            tag[i] = 0;
        }
        int m = (s+t)>>1;
        if (l<=m)
            Update(l,r,c,s,m,i*2);
        if (r>m)
            Update(l,r,c,m+1,t,i*2+1);
        seg[i] = seg[i*2]+seg[i*2+1];
    }
    private static long getSum(int l,int r,int s,int t,int i){
        if (l <=s &&r >= t)
            return seg[i];
        int m = (s+t)>>1;
        long sum = 0;
        if (tag[i]>0){
            seg[i*2] += tag[i]*(m-s+1);
            seg[i*2+1] += tag[i]*(t-m);
            tag[i*2] += tag[i];
            tag[i*2+1] += tag[i];
            tag[i] = 0;
        }
        if (l<=m)
            sum += getSum(l,r,s,m,2*i);
        if (r>m)
            sum += getSum(l,r,m+1,t,2*i+1);
        return sum;
    }
}

class Segment implements Comparable{
    int d;
    int n;
    int f;
    public Segment(int d,int n,int f){
        this.d = d;
        this.n = n;
        this.f = f;
    }

    @Override
    public int compareTo(Object o) {
        if (this.d>((Segment)o).d){
            return 1;
        }else if (this.d<((Segment)o).d) {
            return -1;
        }else {
            return 0;
        }
    }
}

/***
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 * */