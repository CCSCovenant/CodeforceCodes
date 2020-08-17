import com.sun.jdi.event.StepEvent;

import javax.swing.*;
import java.util.Scanner;

public class AcaciusandString {
    static Scanner sc;
    static char[] s;
    static int n;
    static boolean[] change;
    final static char[] patten =  {'a','b','a','c','a','b','a'};
    public static void main(String args[]){
        sc = new Scanner(System.in);
        int Case = sc.nextInt();
        for (int i=0;i<Case;i++){
            Solve();
        }
    }
    private static void Solve(){
        n = sc.nextInt();
        s = sc.next().toCharArray();
       // System.out.println("————————Case start————————");

        byte counter =0;
        change = new boolean[n];
       // System.out.println("————————DEBUG INFO char[]——————");
        for (int i=0;i<n;i++){
            if (s[i]=='?'){
                change[i]=true;
             //   System.out.print(" "+i+" is "+change[i]);
            }
        }
       // System.out.println();
       // System.out.println("—————DEBUG INFO END————");
        for (int i=0;i<n-6;i++) {
           if (check(i)){
               counter++;
           }
        }
     //   System.out.println("Counter is "+counter);

        if (counter==1){
            FinishString();
            System.out.println("YES");
            print();
            System.out.println();
        }else if (counter>=2){
            System.out.println("NO");
        }else { //匹配？
            boolean flag = false;
            for (int i=0;i<n-6;i++){
                if (changetoaba(i)){
                    flag = true;
                   // System.out.println("DEBUG FLAG :"+ flag);
                    break;
                }
            }
            if (flag){
                FinishString();
                System.out.println("YES");
                print();
                System.out.println();
            }else {
                System.out.println("NO");
            }
        }
      //  System.out.println("————————Case END————————");

    }
    private static boolean check(int i){
        boolean flag = true;
        for (int j=0;j<7;j++){
            if (s[i+j]==patten[j]){
            }else {
                flag = false;
            }
        }
        return flag;
    }
    private static boolean changetoaba(int i){
        int counter =0;
        boolean flag = true;
        for (int j=0;j<7;j++){
            if (s[i+j]==patten[j]){

            }else if (s[i+j]=='?'){
                s[i+j]=patten[j];
            }else {
                flag = false;
                break;
            }
        }
    /** System.out.print("DEBUG ");
        print();
        System.out.println();*/

        if (flag){
            for (int j=0;j<n-6;j++) {
               if (check(j)){
                   counter++;
                   if (counter>1){
                       reset();
                       return false;
                   }
               }
            }
        }
        if (counter==1){
            return true;
        }else {
            reset();
            return false;
        }
    }
    private static void reset(){
        for (int i=0;i<n;i++){
            if (change[i]){
                s[i]='?';
            }
        }
    }
    private static void FinishString(){
        for (int i=0;i<n;i++){
            if (change[i]&&s[i]=='?'){
                s[i]='x';
            }
        }
    }
    private static void print(){
        for (int i=0;i<n;i++){
            System.out.print(s[i]);
        }
    }


}

/***
 *
 *
 *
 *
 * abacaba <=
 * ? => X
 * abaca??bacaba
 *
 * xxxxx?abacabaxxxxx
 *
 * abaca???acaba
 *
 * abac?b?cababac
 *
 * XcXcXc
 *
 * */