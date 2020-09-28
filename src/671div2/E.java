import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class E {
    static Scanner sc = new Scanner(System.in);
    static StringBuilder output = new StringBuilder();
    public static void main(String[] args) throws IOException {
        int t = sc.nextInt();
        while (t-- >0) {
            int k = sc.nextInt();
            ArrayList<Integer> Pfactors = findPfactors(k);
            int counter = 0;
            boolean flag = false;
            for (int i = 0; i < Pfactors.size(); i++) {
                int GCD = 0;
                if (i < Pfactors.size() - 1) {
                    GCD = Pfactors.get(i) * Pfactors.get(i + 1);
                } else {
                    GCD = Pfactors.get(i) * Pfactors.get(0);
                }
                if (GCD < k) {

                } else {
                    if (flag || GCD > k) {
                        counter++;
                    } else {
                        flag = true;
                    }
                }
            }
            ArrayList<Integer> factors = new ArrayList<>();
            boolean selfAdded = false;
            // 对p^n 是因数的情况进行测试
            // 加入第一个质因数
            int p0 = Pfactors.get(0);
            int n0 = 1;
            while (powerNL(p0, n0) <= k && (k % powerN(p0, n0) == 0)) {
                n0++;
            }
            n0=n0-1;
            //加入质因数本身和他的n次方
            for (int w = 1; w <= n0; w++) {
                factors.add(powerN(p0,w));
            }

            for (int i = 1; i < Pfactors.size(); i++) {
                ArrayList<Integer> tmp = new ArrayList<>();
                //获取和前一个质因数的GCD
                int GCD = Pfactors.get(i) * Pfactors.get(i-1);
                //判断GCD的可行性：
                // 如果GCD>k 不可行
                // 如果GCD==k 那么GCD只能用一次

                if (GCD >= k) {
                    if (!selfAdded) {
                        selfAdded = true;
                    } else {
                        GCD = -1;
                    }
                }
                //如果GCD可行 加入两个区间之间的第一个
                if (GCD != -1) {
                    tmp.add(GCD);
                }
                //因为是环 对最后一个进行特判.
                int GCDL = -1;
                if (i == Pfactors.size()-1){
                    GCDL = Pfactors.get(i)*Pfactors.get(0);
                    if (GCDL >= k) {
                        if (!selfAdded) {
                            selfAdded = true;
                        } else {
                            GCDL = -1;
                        }
                    }
                }

                // 对p^n 是因数的情况进行测试
                int p = Pfactors.get(i);
                int n = 1;
                while (powerNL(p, n) < k && (k % powerN(p, n) == 0)) {
                    n++;
                }
                n=n-1;

                //加入质因数本身和他的n次方
                for (int w = 1; w <= n; w++) {
                    tmp.add(powerN(p,w));
                }
                //加入除了GCD以外的数
                for (int j = 0; j < factors.size(); j++) {
                    for (int w = 1; w <= n; w++) {
                        int fac = powerN(p,w) * factors.get(j);
                        if (fac != GCD && fac<=k && fac != GCDL && !factors.contains(fac) && !tmp.contains(fac)) {
                            tmp.add(fac);
                        }
                    }
                }

                for (int j=0;j<tmp.size();j++){
                    factors.add(tmp.get(j));
                }


                //因为是环 对最后一个进行特判.
                if (GCDL != -1&&!factors.contains(GCDL)){
                    factors.add(GCDL);
                }


            }
            for (int i=0;i<factors.size();i++){
                output.append(factors.get(i)+" ");
            }
            output.append("\n");
            output.append(counter+"\n");
        }
        System.out.println(output);
    }
    public static ArrayList<Integer> findPfactors(int x){
        ArrayList<Integer> Pfactors = new ArrayList<>();
        int k = x;
        for (int i=2;i*i<=x;i++){
            if (k==1){
                return Pfactors;
            }else {
                if (isP(i)&&k%i==0){
                    while (k%i==0){
                    k = k/i;
                    }
                    Pfactors.add(i);
                }
            }
        }
        if (isP(k)&&k!=x&&!Pfactors.contains(k)&&k!=1){
            Pfactors.add(k);
        }
        return Pfactors;

    }
    public static boolean isP(int x){
        for (int i=2;i*i<=x;i++){
            if (x%i==0){
                return false;
            }
        }
        return true;
    }
    public static int powerN(int p,int n){
        int ans = 1;
        for (int i=0;i<n;i++){
            ans *= p;
        }
        return ans;
    }
    public static long powerNL(int p,int n){
        long ans = 1;
        for (int i=0;i<n;i++){
            ans *= p;
        }
        return ans;
    }
}

