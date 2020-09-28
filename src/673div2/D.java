import java.util.Scanner;

public class D {
    static Scanner sc = new Scanner(System.in);
    static StringBuilder out = new StringBuilder();
    static StringBuilder buffer = new StringBuilder();
    static long[] a;
    static boolean[] used;
    static int counter=0;
    public static void main(String[] args){
        int t = sc.nextInt();
        while (t-- >0){
            int n = sc.nextInt();
             a = new long[n+1];
             used = new boolean[n+1];
            long sum = 0;
            for (int i=1;i<n+1;i++){
                a[i] = sc.nextLong();
                sum += a[i];
            }
            buffer = new StringBuilder();
            counter = 0;
            if (sum%n==0){
                if (Equal(sum,n)) {
                    out.append(counter + "\n");
                    out.append(buffer);
                }else {
                    out.append(-1+"\n");
                }
            }else {
                out.append(-1+"\n");
            }
//            System.out.println("new case");
        }
        System.out.println(out);
    }
    public static boolean operation(int i,int j,long x){
        a[i] = a[i] - x*i;
        a[j] = a[j] + x*i;
        if (a[i]<0||a[j]<0){
            return true;
        }
        buffer.append(i+" "+j+" "+x+"\n");
        counter++;
        return false;
    }
    public static boolean Equal(long sum,int n){
        long avg = sum/n;

        for (int i=2;i<n+1;i++){
            if (a[i]>=i){
                long x = a[i]/i;
                if (operation(i,1,x)){
                    return false;
                }
                used[i] =  true;
            }
        }
        for (int i=2;i<n+1;i++){
            if (a[i]<i&&(!used[i]||a[i]>avg)){
                long x = i-a[i];
                if (operation(1,i,x)){
                    return false;
                }
                if (operation(i,1,1)){
                    return false;
                }
            }
        }

        for (int i=2;i<n+1;i++){
            if (a[i]<avg){
                long diff = avg-a[i];
                if ( operation(1,i,diff)){
                    return false;
                }
            }
        }
        return true;
    }
}
//   3 10 10 10 10 10 10       600 1000  500 1 2 3 4
                   //  7
// 1 3