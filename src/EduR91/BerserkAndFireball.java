import java.util.Scanner;

public class BerserkAndFireball {
   static boolean firecheap = false;
   static boolean berserkchecp = false;
   static int cfire;
   static int rfire;
   static int cberserk;
   static int[] a;
   static int[] b;
   static int[] fixedIndex;


    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Solve(sc);

    }
    private static void Solve(Scanner sc) {
        int al = sc.nextInt();
        int bl = sc.nextInt();
          cfire = sc.nextInt();
          rfire = sc.nextInt();
          cberserk = sc.nextInt();

        int mana = 0;
        if (cfire/rfire>cberserk){
            berserkchecp =true;
        }else {
            firecheap = true;
        }
        a = new int[al+2];
        b = new int[bl];
        fixedIndex = new int[bl+2];
        fixedIndex[0] = 0;
        fixedIndex[bl+1] = al;
        a[0] = 0;
        for (int i=1;i<al+1;i++){
            a[i] = sc.nextInt();
        }
        a[al+1] = 0;
        for (int i=0;i<bl;i++){
            b[i] = sc.nextInt();
        }
        int fixed = 0;
        for (int i=1;i<al+1;i++){
            if (b[fixed]==a[i]){
                fixedIndex[fixed+1] = i;
                fixed++;
                if (fixed==bl){
                    break;
                }
            }
        }
        if (fixed!=bl){
            System.out.println(-1);
        }else {

            for (int i=1;i<fixedIndex.length;i++){
                wipe(fixedIndex[i-1]+1,fixedIndex[i]-1,fixedIndex[i-1],fixedIndex[i]);
            }


        }

    }
    private static int getMax(int i,int j){
        int max =a[i];
        for (int z =i;i<=j;z++){
            max = Math.max(a[z],max);
        }
        return max;
    }
    private static int getMinN(int i,int j,int n){
        int counter =0;
        for (int z =i;i<=j;z++){
            if (a[z]<n){
                counter++;
            }
        }
        return counter;
    }
    private static int wipe(int i,int j, int s, int end){
        int localmax = getMax(i,j);
        int number = getMinN(i,j,Math.max(a[s],a[end]));
        int range = j-i;
        if (range<rfire){
            if (localmax>Math.max(a[s],a[end])){
                return -1;
            }else {
                return range*cberserk;
            }
        }else {
            if (number<range%rfire) {
                return -1;
            }else {
                if (berserkchecp){
                    if (localmax>Math.max(a[s],a[end])){
                        return range*cberserk;
                    }else {
                        int rberserk = number-(rfire-(range-number)%rfire);
                        return  rberserk*cberserk+((range-rberserk)/rfire)*cfire;
                    }
                }else {
                    return cberserk*(range%rfire)+cfire*(range/rfire);
                }
            }
        }

    }
}

/***
 *
 *
 *
 *
 *
 *
 * 0 x x # x x x # x # x x x # x x x 0
 *
 *   L > k
 *   1. b<f
 *    {{} < first/last}
 *   2. b<f
 *     => k
 *   3. f>b
 *
 *  =========
 *
 *   L < k
 *   {} < first/last
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 */
