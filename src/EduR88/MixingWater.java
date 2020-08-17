package EduR88;

import java.util.Scanner;

public class MixingWater {
    public static void main(String[] args){

    Scanner sc = new Scanner(System.in);
    int Case = sc.nextInt();
    for (int i=0;i<Case;i++){
        Solve(sc);
        }
    }
    private static void Solve(Scanner sc){
        int Th = sc.nextInt();
        int Tc = sc.nextInt();
        int Ttarget = sc.nextInt();
        int ans =0;
        int mid = (Th+Tc)/2;
        if (Th==Ttarget||Tc==Ttarget){
            ans=1;
        }else if (Ttarget<=mid){
            ans=2;
        }else {
            double k = ((double)(Ttarget-Th))/(double)((Tc+Th)-2*Ttarget);
             int Ku = (int)Math.ceil(k);
             int Kl = (int)Math.floor(k);

            double diff1 = Math.abs((double)(Ku*Tc+(Ku+1)*Th)/(double)(2*Ku+1)-Ttarget);
             double diff2 = Math.abs((double)(Kl*Tc+(Kl+1)*Th)/(double)(2*Kl+1)-Ttarget);
            if (diff1<diff2){
                ans = 2*Ku+1;
            }else {
                ans = 2*Kl+1;
            }
        }
        System.out.println(ans);
    }
}
/**
 *  2Ku
 *
 *   t = k*c+(k+1)*h /2k+1
 *  ( 2k+1) = k*c+(k+1)*h
 *   (2k+1)t = (c+h)*k + h
 *    2tk+t = (c+h)*k + h
 *    2t-(c+h) k = h-t
 *    k = h-t/2t-(c+h)
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
 * */