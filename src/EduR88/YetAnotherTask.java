package EduR88;

import java.util.Scanner;

public class YetAnotherTask {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int Cards = sc.nextInt();
        int[] card = new int[Cards];
        for (int i=0;i<Cards;i++){
            card[i] = sc.nextInt();
        }
        System.out.println(findMaxSubArrayWithoutMaxElement(card));
    }

    private static long findMaxSubArrayWithoutMaxElement(int[] target){
        long b = 0;
        long m = 0;
        int max = target[0];
        for (int i=1;i<target.length;i++){
            if (target[i]>max){
                if (b+max>=0){
                    b+=max;
                    max = target[i];
                }else {
                    b = 0;
                    max = target[i];
                }
            }else {
                if (b>=0){
                    b+=target[i];
                }else {
                    b = 0;
                    max = target[i];
                }
            }
            if (m<b){
                m = b;
            }
        }
        return m;
}
}
/***
 *
 *
 *  b - max <0
 *
 *  10%2%4
 *
 * */