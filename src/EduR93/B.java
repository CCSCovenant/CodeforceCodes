import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class B {
    static Scanner sc = new Scanner(System.in);
    static String a;
    static ArrayList<Integer> parts;
    static int ans = 0;
    public static void main(String[] args){
        int n = sc.nextInt();
        for (int i=0;i<n;i++){
            Solve();
        }
    }
    private static void Solve(){
            a = sc.next();
            ans =0;
            int l = a.length();
            parts = new ArrayList<>();
            int counter = 0;
            for (int i=0;i<l;i++){
                if (a.charAt(i)=='0'){
                    if (counter!=0){
                        parts.add(counter);
                        counter = 0;
                    }
                }else {
                    counter++;
                }
            }
            if (counter!=0){
                parts.add(counter);
                counter = 0;
            }
            Collections.sort(parts);
           /*
            for (int i=0;i<parts.size();i++){
                System.out.print(parts.get(i)+" ");
            }
           * */
            for (int i=parts.size()-1;i>=0;i-=2){
                ans += parts.get(i);
            }
            System.out.println(ans);

    }
}
