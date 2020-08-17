import java.util.Scanner;

public class B {
        static Scanner sc;
        static int[] a;
        static long[] prefixsum;
        static int n;
        static int k;
        static int z;
        static int r;
        static long max;
        public static void main(String[] args){
            sc = new Scanner(System.in);
            int n = sc.nextInt();
            for (int i=0;i<n;i++){
                Solve();
            }
        }
        private static void Solve(){
             n = sc.nextInt();
             k = sc.nextInt();
             z = sc.nextInt();
             prefixsum = new long[n];
             a = new int[n];
             for (int i=0;i<n;i++){
                 a[i] = sc.nextInt();
             }
               prefixsum[0] = a[0];
             for (int i=1;i<n;i++){
                 prefixsum[i]=prefixsum[i-1]+a[i];
             }
             max = 0;
             for (int i=1;i<n;i++){
                 max = Math.max(max,getScore(i));
             }
             System.out.println(max);
        }
        private static long getScore(int i){
            long Score;
            if (k-i>=(z*2)){
                Score = prefixsum[k-(z*2)]+(a[i]+a[i-1])*z;
            }else if (k-i<0){
                Score = prefixsum[k];
            }else {
                Score = prefixsum[i]+(a[i]+a[i-1])*((k-i)/2)+a[i-1]*((k-i)%2);
            }

            return Score;
        }
    }


