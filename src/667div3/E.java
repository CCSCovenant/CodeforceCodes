import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class E {
    static Scanner sc = new Scanner(System.in);
    static StringBuilder ans = new StringBuilder();
    static int[] xArray;
    static int secondStart;
    static int secondEnd;
    static int point;


    public static void main(String[] args){
        int t = sc.nextInt();
        for (int i=0;i<t;i++){
            int n = sc.nextInt();
            int k = sc.nextInt();
            point = 0;
            secondEnd =0;
            secondStart = 0;
            xArray = new int[n];
            for (int j=0;j<n;j++){
                xArray[j] = sc.nextInt();
            }
            for (int j=0;j<n;j++){
                sc.nextInt();
            }
            Arrays.sort(xArray);
            point = FindMaxPossiblePoint(xArray,2*k,1);
            int fp1 = FindMaxPossiblePoint(xArray,k,0);
            int sp1 = FindMaxPossiblePoint(getPart(xArray,0,secondEnd),k,1);
            int sp2 = FindMaxPossiblePoint(getPart(xArray,secondStart,n),k,1);
            point = Math.max(point,fp1+Math.max(sp1,sp2));
            ans.append(point+"\n");
         //   System.out.println();
        }
        System.out.println(ans);
    }
    public static int FindMaxPossiblePoint(int[] local,int k,int r){
        int maxindex = 0;
        int maxpoint = 0;
        for (int i=0;i<local.length;i++){
            int Points = FindMin(local,local[i]+k)-i+1;
            if (Points>maxpoint){
                maxindex = i;
                maxpoint = Points;
            }
        }
        if (r == 0) {
            secondEnd = maxindex;
            secondStart = maxindex+maxpoint ;
        }
        //System.out.println("Max:"+maxpoint);
      //  System.out.println("cut:"+secondEnd+" "+secondStart);
        return maxpoint;
    }
    public static int[] getPart(int[] local,int s,int t){
        int[] slice = new int[t-s];
        for (int i=0;i<t-s;i++){
            slice[i] = local[s+i];
        }
        return slice;
    }


    public static int FindMin(int[] a,int n){
        int lb = -1;
        int ub = a.length;
        int mid;
        while (ub-lb>1){
            mid = (lb+ub)/2;
            if (a[mid]>n){
                 ub = mid;
             }else {
                 lb = mid;
             }
        }
        return lb;
    }
}


//2 8 9 10 10 15 17 19 19 20