import java.util.Arrays;
import java.util.Scanner;

public class AsterismE2 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Solve(sc);
    }
    private static void Solve(Scanner sc){
        int n = sc.nextInt();
        int p = sc.nextInt();
        int[] a = new int[n];

        a[0] = sc.nextInt();
        int aMin = a[0];
        int aMax = a[0];
        for (int i=1;i<n;i++){
            a[i] = sc.nextInt();
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
                 // System.out.println("number in x="+(aMin+i)+" And j="+j+" is "+number);
                if (number%p==0){
                    flag = false;
                }
            }
           //   System.out.println("Flag in x="+(aMin+i)+" is "+flag);
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
 //   O(n) search method

*/


   private static int ReturnNumberOfElement(int[] a,int x){
        // 返回a之中小于等于x的元素的数量
        int head = -1;
        int tail = a.length;
        int mid;
        while(tail-head>1){
            mid = (tail+head)/2;
            if (a[mid]>x){
                tail=mid;
            }else {
                head=mid;
            }
        }
        return tail;
    }
    //O(logn) search method

}