import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class AsterismE1 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Solve(sc);
    }
    private static void Solve(Scanner sc){
        int n = sc.nextInt();
        int p = sc.nextInt();
        short[] a = new short[n];

        a[0] = sc.nextShort();
        int aMin = a[0];
        int aMax = a[0];
        for (int i=1;i<n;i++){
            a[i] = sc.nextShort();
            aMax =  Math.max(a[i],aMax);
            aMin =  Math.min(a[i],aMin);
        }
        Arrays.sort(a);
        int counter = 0;
        String Ans = "";
      //  System.out.println("Max is "+aMax);
      //  System.out.println("Max is "+aMin);

        for(int i=0;i<(aMax-aMin);i++){
            boolean flag = true;
            for(int j=0;j<n;j++){
                int number = (ReturnNumberOfElement(a,aMin+i+j)-j);
              //  System.out.println("number in x="+(aMin+i)+" And j="+j+" is "+number);
                if (number%p==0){
                    flag = false;
                }
            }
          //  System.out.println("Flag in x="+(aMin+i)+" is "+flag);
            if (flag){
                counter++;
                int x = aMin+i;
                Ans += x+" ";
            }
        }
        System.out.println(counter);
        System.out.println(Ans);
}
/*
    private static int ReturnNumberOfElement(short[] a,int x){
        // 返回a之中小于等于x的元素的数量
        int index =a.length-1;
        for (int i=a.length-1;i>=0;i--){
            if (a[i]<=x){
                index = i+1;
                break;
            }
        }
        if (a[0]>x){
            index = 0;
        }
        return index;
    }
    O(n) search method
 */



    private static int ReturnNumberOfElement(short[] a,int x){
        // 返回a之中小于等于x的元素的数量
        int head = -1;
        int tail = a.length;
        int mid;
        while(tail-head>1){
            mid = (tail+head)/2;
            if (a[mid]>=x){
                tail=mid;
            }else {
                head=mid;
            }
        }
        return tail;
    }
    //O(logn) search method

}

// 10^5*nlogn

/***
 *
 *
 * if x>=(2n-1)
 *
 * f(x) == n!
 *
 * if x<n
 * f(x) = 0
 *
 * x==n, 1 .... n
 * x==n+1
 * 1 2 3
 * n=3
 * 3+1 = 4
 *
 *
 *
 * x= n+p
 * f(x)== p!
 *
 *
 * 3 4 5 6  x==5
 * [][][][]
 *  3     4-1     4-2
 * [ ]   [ ]     [ ]   [ ]
 * |x|<x |x|<x+1 |x|<x+2 |x|<x+3
 *
 *  3*3*2 == 18
 *
 *
 *  2 3 5 6
 *  3 2 5 6
 *
 *
 *
 *  2 1 1 1
 *
 *  3
 *  sum = 1
 *  f(x) = for(int i=0;i<n;i++){
 *      sum *= |ai|<=x+i
 *  }
 *  (N)nlogn
 * */


/**
 *
 * f(x)
 * x
 * =>
 * P|ai < x+i|
 *
 *
 * */

/**
 *  求有多少个 x
 *  使得f(x) 的值不被p整除
 *  f(x)
 *  有多少个P
 *  P|ai < x+i|
 *
 *  1 2 3 4
 *  x= 3
 *
 *  3 4 5 6
 * */

/**
 *
 *
 *
 *  2 4 5 8 9
 *  2 3 4 5 6 7 8 9
 *   2 4 5 8 9
 *
 *
 *
 * */