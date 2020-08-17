import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class A {
    static Scanner sc;
    static int size = 100001;
    static int[] a = new int[size];
    static StringBuilder ans = new StringBuilder();
    static int C2;
    static int C4;
    static int C6;
    static int C8;

    public static void main(String args[]){
        sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i=0;i<n;i++){
            a[sc.nextInt()]++;
        }
        for (int i=0;i<size;i++){
            switch (inInterval(a[i])){
                case 8:
                    C8++;
                    break;
                case 6:
                    C6++;
                    break;
                case 4:
                    C4++;
                    break;
                case 2:
                    C2++;
                    break;
                default:
                    break;
            }
        }
        int m = sc.nextInt();
        for (int i=0;i<m;i++){
            String s = sc.next();
            int c = sc.nextInt();
            if (s.charAt(0)=='+'){
               int pre = inInterval(a[c]);
                a[c]++;
               int aft = inInterval(a[c]);
              // System.out.println("Pre:"+pre+" aft"+aft);
               // System.out.println("a[c]: "+a[c]+" Pre:"+pre+" aft"+aft);
                switch (pre){
                    case 8:
                        C8--;
                        break;
                    case 6:
                        C6--;
                        break;
                    case 4:
                        C4--;
                        break;
                    case 2:
                        C2--;
                        break;
                    default:
                        break;
                }
                switch (aft){
                    case 8:
                        C8++;
                        break;
                    case 6:
                        C6++;
                        break;
                    case 4:
                        C4++;
                        break;
                    case 2:
                        C2++;
                        break;
                    default:
                        break;
                }
            }else {
                int pre = inInterval(a[c]);
                a[c]--;
                int aft = inInterval(a[c]);
               // System.out.println("Pre:"+pre+" aft"+aft);
               // System.out.println("a[c]: "+a[c]+" Pre:"+pre+" aft"+aft);
                switch (pre){
                    case 8:
                        C8--;
                        break;
                    case 6:
                        C6--;
                        break;
                    case 4:
                        C4--;
                        break;
                    case 2:
                        C2--;
                        break;
                    default:
                        break;
                }
                switch (aft){
                    case 8:
                        C8++;
                        break;
                    case 6:
                        C6++;
                        break;
                    case 4:
                        C4++;
                        break;
                    case 2:
                        C2++;
                        break;
                    default:
                        break;
                }
            }
            //System.out.println("C8:"+C8+" C6:"+C6+" C4:"+C4+" C2:"+C2);
            if (Solve()){
                ans.append("YES\n");
            }else {
                ans.append("NO\n");
            }
        }
        System.out.println(ans);
    }
    private static boolean Solve() {
        if (C8>0){
            return true;
        }else if (C6>1){
            return true;
        }else if (C4>1){
            return true;
        }else if (C6>0&&(C4>0||C2>0)){
            return true;
        }else if (C4>0&&(C2>1)){
            return true;
        }else {
            return false;
        }
    }

    private static int inInterval(int a){
        if (a>=8){
            return 8;
        }else if (a>=6){
            return 6;
        }else if (a>=4){
            return 4;
        }else if (a>=2){
            return 2;
        }else {
            return 0;
        }
    }


}


/*****
 *
 *
 *
 *
 *
 *
 *
 * 2 4 6 8
 *
 *
 *
 *
 * */