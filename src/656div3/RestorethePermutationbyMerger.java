import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class RestorethePermutationbyMerger {
    public  static  void  main(String args[]){
        Scanner sc = new Scanner(System.in);
        int Case = sc.nextInt();
        for (int i=0;i<Case;i++){
            Solve(sc);
        }
    }
    public static void Solve(Scanner sc){
        int n = sc.nextInt();
        ArrayList<Integer> a = new ArrayList<>();
        for (int i=0;i<2*n;i++){
            a.add(sc.nextInt());
        }
        int[] ans = new int[n];
        for (int i=0;i<n;i++){
            ans[i] = a.remove(0);
            for (int j=0;j<a.size();j++){
                if (a.get(j)==ans[i]){
                    a.remove(j);
                    break;
                }
            }
        }
        for (int i=0;i<n;i++){
            System.out.print(ans[i]+" ");
        }
        System.out.println();
    }
}


/*
* 3 1 2
* 3 3 1 2
*
*
* */