import java.util.Arrays;
import java.util.Scanner;

public class F {
    static Scanner sc;
    static Seg[] Seg;
    public static void main(String[] args){
        sc = new Scanner(System.in);
        int n = sc.nextInt();
        Seg = new Seg[n];
        for (int i=0;i<n;i++){
            Seg[i] = new Seg(sc.nextInt(),sc.nextInt(),sc.nextByte());
        }
        Arrays.sort(Seg);

    }
}
class Seg implements Comparable{
    int l;
    int r;
    byte color;
    public Seg(int l,int r, byte c){
        this.l = l;
        this.r = r;
        this.color = c;
    }

    public byte getColor() {
        return color;
    }

    public int getL() {
        return l;
    }

    public int getR() {
        return r;
    }

    @Override
    public int compareTo(Object o) {
        if (this.r>((Seg)o).r){
            return 1;
        }else if (this.r<((Seg)o).r){
            return -1;
        }else {
            return 0;
        }
    }
}

/****
 *
 *
 * Min(li) - Max(li)
 *
 *
 *  [ ]
 * [][][][][]
 *
 *
 *
 *
 * */
