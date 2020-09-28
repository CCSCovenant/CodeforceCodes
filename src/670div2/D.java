import java.io.IOException;
import java.util.Scanner;

public class D {
    static Scanner sc = new Scanner(System.in);
    static StringBuilder ans = new StringBuilder();
    static long[] a;
    static long[] delta;
    static long deltaValue;
    public static void main(String[] args) throws IOException {
        int n = sc.nextInt();
         a = new long[n+1];
        for (int i=1;i<n+1;i++){
            a[i] = sc.nextInt();
        }
        delta = new long[n+1];
        for (int i=2;i<n+1;i++){
           delta[i] = a[i]-a[i-1];
           if (delta[i]>0){
               deltaValue+=delta[i];
           }
        }
        deltaValue += a[1];
        if (deltaValue%2==0){
            ans.append(deltaValue/2+"\n");
        }else {
            ans.append((deltaValue+1)/2+"\n");
        }
        int q = sc.nextInt();
        for (int i=0;i<q;i++){
            int l = sc.nextInt();
            int r = sc.nextInt();
            int c = sc.nextInt();
            if (l>1){
                if (delta[l]+c > 0){
                    if (delta[l]>0){
                        deltaValue +=c;
                    }else {
                        deltaValue += delta[l]+c;
                    }
                }else {
                    if (delta[l]>0){
                        deltaValue -= delta[l];
                    }
                }
                delta[l] += c;
            }else {
                deltaValue += c;
            }
            if (r<n){
                if (delta[r+1]-c >0){
                    if (delta[r+1] >0){
                        deltaValue -=c;
                    }else {
                        deltaValue += delta[r+1]-c;
                    }
                }else {
                    if (delta[r+1]>0){
                        deltaValue -= delta[r+1];
                    }
                }
                delta[r+1] -= c;
            }
            if (deltaValue%2==0){
                ans.append(deltaValue/2+"\n");
            }else {
                ans.append((deltaValue+1)/2+"\n");
            }
        }
        System.out.println(ans);

    }


}
