import java.io.*;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class A {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) throws IOException {
        int t = sc.nextInt();
        while (t-- > 0)
        {
            int n = sc.nextInt();
            int[] a= new int[101];
            for (int i=0;i<n;i++){
                a[sc.nextInt()]++;
            }
            int mexa = 0;
            int mexb = 0;
            boolean selected  = false;
            for (int i=0;i<101;i++){
               if (a[i]>1){

               }else {
                if (a[i]==0&&!selected){
                    mexa = i;
                    mexb = i;
                    break;
                }
                if (a[i]==1&&!selected){
                    mexa = i;
                    selected = true;
                }else if (a[i]==0){
                    mexb = i;
                    break;
                }
               }
            }
            System.out.println(mexa+mexb);
        }

    }
}
