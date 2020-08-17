import java.math.BigInteger;
import java.util.*;

public class Choosingflowers {
    static Scanner sc;
    static flower[] a;
    static BigInteger[] prefixsum;
    static int n;
    static int type;
    static BigInteger happy;
    public static void main(String args[]){
        sc = new Scanner(System.in);
        int Case = sc.nextInt();
        for (int i=0;i<Case;i++){
            Solve();
        }
    }
    private static void Solve(){
        n = sc.nextInt();
        type = sc.nextInt();
        a = new flower[type];
        prefixsum = new BigInteger[type+1];
        for (int i=0;i<type;i++){
            a[i] = new flower(sc.nextInt(),sc.nextInt());
        }
        Arrays.sort(a);
        prefixsum[type] = BigInteger.valueOf(0);
        prefixsum[type-1] = BigInteger.valueOf(a[type-1].getA());
        for (int i=type-2;i>=0;i--){
            prefixsum[i]=BigInteger.valueOf(a[i].getA()).add(prefixsum[i+1]);
        }
        happy = BigInteger.valueOf(0);
        for (int i=0;i<type;i++){
            int aindex = findindex(a[i].getB());
            int bnum;
            BigInteger tmp;
            if (a[i].getA()<a[i].getB()){
                bnum = (n-(type-aindex)-1);
                if (bnum<=0){
                    tmp = prefixsum[type-n];
                }else {
                    tmp = BigInteger.valueOf(a[i].getB()).multiply(BigInteger.valueOf(bnum)).add(prefixsum[aindex]).add(BigInteger.valueOf(a[i].getA()));
                }

            }else {
                bnum = (n-(type-aindex));
                if (bnum<=0){
                    tmp = prefixsum[type-n];
                }else {
                    tmp = BigInteger.valueOf(a[i].getB()).multiply(BigInteger.valueOf(bnum)).add(prefixsum[aindex]);
                }
            }
            if (tmp.compareTo(happy)>0){
                happy=tmp;
            }

        }
        if (n==1){
            System.out.println(a[type-1].getA());
        }else {
            System.out.println(happy);
        }

    }
    private static int findindex(int B){
        int lb = -1;
        int ub = type;
        while (ub-lb>1){
            int mid = (lb+ub)/2;
            if (a[mid].getA()>=B){
                ub = mid;
            }else {
                lb = mid;
            }
        }
        return ub;
    }

}

class flower implements Comparable{

    int a;
    int b;
    public flower(int a, int b){
        this.a = a;
        this.b = b;
    }

    public int getA() {
        return a;
    }
    public int getB(){
        return b;
    }

    @Override
    public int compareTo(Object o) {
        if (this.a>((flower)(o)).a){
            return 1;
        }else if (this.a<((flower)(o)).a){
            return -1;
        }else {
            return 0;
        }
    }
}

