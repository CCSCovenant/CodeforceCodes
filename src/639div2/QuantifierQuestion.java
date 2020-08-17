package Div2_639;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class QuantifierQuestion {
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        Map<Integer, ArrayList> M = new HashMap<>();
        ArrayList E = new ArrayList();
        int a;
        int b;
        for (int i=0;i<m;i++){
            a = sc.nextInt();
            b = sc.nextInt();
                if (M.containsKey(a)){
                    M.get(a).add(b);
                }else {
                    ArrayList tmp = new ArrayList();
                    tmp.add(b);
                    M.put(a,tmp);
                }
        }


    }
}







/***
 *
 * A
 * A E
 *
 * 1 3
 * A E
 * 2 3
 * A E
 *
 *
 * 1 2
 * 2 3
 * A
 * 2
 * E
 * 3
 * E
 *
 * 3 1
 *
 * 1 - 2
 * 3 - 2
 *
 * 4 - 3
 *
 *
 *
 * */