import java.util.Scanner;

public class Dt {
    static Scanner sc = new Scanner(System.in);
    static StringBuilder out = new StringBuilder();
    static StringBuilder buffer = new StringBuilder();
    static long[] a;
    static int counter=0;
    public static void main(String[] args){
        int t = sc.nextInt();
        while (t-- >0){
            int n = 1000;
            a = new long[n+1];
            long sum = 0;
            for (int i=1;i<n+1;i++){
                a[i] = (int)(Math.random()*100)*1000;
                sum += a[i];
            }
            if (sum%n==0){
                long avg = sum/n;
                for (int i=2;i<n+1;i++){
                    if (a[i]>=i){
                        long x = a[i]/i;
                        operation(i,1,x);
                    }
                }
                for (int i=2;i<n+1;i++){
                    if (a[i]<i&&a[i]>avg){
                        long x = i-a[i];
                        operation(1,i,x);
                        operation(i,1,1);
                    }
                }
                for (int i=2;i<n+1;i++){
                    if (a[i]<avg){
                        long diff = avg-a[i];
                        operation(1,i,diff);
                    }
                }
                for (int i=1;i<n+1;i++){
                    if (a[i]!=avg){
                        System.out.println("WA");
                    }
                }
                out.append(counter+"\n");
                out.append(buffer);
                buffer = new StringBuilder();
                counter = 0;
            }else {
                out.append(-1+"\n");
            }
//            System.out.println("new case");
        }
       // System.out.println(out);
    }
    public static void operation(int i,int j,long x){
        a[i] = a[i] - x*i;
        a[j] = a[j] + x*i;
        if (a[i]<0||a[j]<0){
            System.out.println("NEGATIVE");
        }
        buffer.append(i+" "+j+" "+x+"\n");
        counter++;
    }
}
