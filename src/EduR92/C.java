import java.util.Scanner;

public class C {
    static Scanner sc;
    static int l;
    static String S;
    static int[] num;
    static int maxL;
    public static void main(String[] args){
        sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i=0;i<n;i++){
            Solve();
        }
    }
    private static void Solve(){
        S = sc.next();
        l = S.length();
        maxL = 2;
        num = new int[10];
        for (int i=0;i<l;i++){
            num[Integer.parseInt(String.valueOf(S.charAt(i)))]++;
        }
        for (int i=0;i<10;i++){
            maxL = Math.max(num[i],maxL);
        }
        for (int i=48;i<58;i++){
            for (int j=48;j<58;j++){
                maxL = Math.max(maxL,getFL((char) i,(char) j));
            }
        }
        System.out.println(l-maxL);

    }
    private static int getFL(char a,char b){
        boolean flag = true;
        int length = 0;
        for (int i=0;i<l;i++){
            if (flag){
                if (S.charAt(i)==a){
                    flag=false;
                    length++;
                }
            }else {
                if (S.charAt(i)==b){
                    flag=true;
                    length++;
                }
            }
        }
        if (length%2==0){
            return length;
        }else {
            return length-1;
        }
    }
}

/****
 *
 *  |s| == 2,  n-2
 *  |s| == ,  n-max
 *  |s|
 *
 *
 *   12121212
 *
 *
 *
 *
 * */