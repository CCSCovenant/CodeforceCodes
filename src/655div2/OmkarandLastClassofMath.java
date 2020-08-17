import java.util.Scanner;

public class OmkarandLastClassofMath {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int c = sc.nextInt();
        for (int j =0;j<c;j++){
           solve(sc);
        }
    }
    private static void solve(Scanner sc){
        int n = sc.nextInt();
        if (n%2==0){
           System.out.print(n/2+" ");
           System.out.println(n/2);
        }else {
            int[] a = Find(n);
            System.out.println(a[0]+" "+a[1]);
        }
    }
    private static int isP(int n){
           int flag = 0;
        for (int i=2;i*i<=n;i++){
            if (n%i==0){
                flag = i;
            }
        }
        return flag;
    }
    private static int[] Find(int n){
        int[] ans = new int[2];
        int flag = isP(n);
       // System.out.println("n is"+n +" flag is"+flag);
        if (flag==0){
            ans[0]=1;
            ans[1]=n-1;
        }else {
            int i = findminP(n);
            ans[0] = 1*(n/i);
            ans[1] = (i-1)*(n/i);
        }
        return ans;
    }
    private static int findminP(int n){
        int i =0;
        int f = isP(n);
        if (f==0){
            i=n;
        }else {
            i = Math.min(findminP(f),findminP(n/f));
        }
        return i;
    }

   // 11
    //
    //9*9
    // 1+n
    // 28
    //
}
