import java.util.Scanner;

public class D {
    static Scanner sc;
    static long cost;
    static long lessCostInterval;
    static long k;
    static long n;
    static long al;
    static long ar;
    static long bl;
    static long br;

    public static void main(String[] args){
        sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i=0;i<n;i++){
            Solve();
        }
    }
    private static void Solve(){
         n = sc.nextInt();
         k = sc.nextInt();
         al = sc.nextInt();
         ar = sc.nextInt();
         bl = sc.nextInt();
         br = sc.nextInt();
         lessCostInterval = Math.max(br,ar)-Math.min(al,bl);

         if (k>lessCostInterval*n){
             cost = Math.abs(al-bl)+Math.abs(ar-br);
             cost *=n;
            // System.out.println(cost);
             cost +=(k-lessCostInterval*n)*2;
            // System.out.println(cost);
        //   System.out.println("b");
         }else if (existIntersection()<=0){
             long r = k%lessCostInterval;
             long n = k/lessCostInterval;
             cost = (Math.abs(al-bl)+Math.abs(ar-br));
             cost *=n;
             if (k>lessCostInterval){
                 cost += Math.min(r+Math.abs(existIntersection()),(k-n*lessCostInterval)*2);}
             else {
                 cost+=r+Math.abs(existIntersection());
             }
          //   System.out.println("c");
         }else {
             if (existIntersection()*n>=k){
                 cost = 0;
             }else {
                 k -= existIntersection()*n;
                 long r = k%(lessCostInterval-existIntersection());
                 long n = k/(lessCostInterval-existIntersection());
                 cost = (Math.abs(al-bl)+Math.abs(ar-br));
                 cost *=n;
                 cost +=r;
            //     System.out.println("d");
             }


        }
         /*
         if (cost==6914){
             System.out.println("n:"+n+"k:"+k+"al:"+al+"ar:"+ar+"bl:"+bl+"br:"+br);
         }*/
         System.out.println(cost);



    }
    private static long existIntersection(){
         long gap = Math.min(ar,br) - Math.max(al,bl);
         return gap;
    }
}


/**
*
*  Min(al.bl) Max(ar,br)
 *  1 2
 *  3 4
 *  3-2
 *  gap + I
 *
 *  4-1
 *
 *  1 4
 *  4 8
 *
 *
 * *
*  2
*
 *
*  [ ] [ ]
 * [ [ ] ]
 * [  [ ] ]
*
* 10
* 10 134
 *54
 *
*
*
* */