import java.util.ArrayList;
import java.util.Scanner;

public class D {
    static Scanner sc;
    static String s;
    public static void main(String[] args){
        sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i=0;i<n;i++){
            Solve();
        }
    }
    private static void Solve(){
        int n = sc.nextInt();
        s = sc.next();
        int Max;
        ArrayList<Integer> Zero = new ArrayList<>();
        ArrayList<Integer> One = new ArrayList<>();
        StringBuilder output = new StringBuilder();
        for (int i=0;i<n;i++){
            if (s.charAt(i)=='1'){
                if (Zero.size()>0){
                    output.append(Zero.get(Zero.size()-1)+" ");
                    One.add(Zero.remove(Zero.size()-1));
                }else {
                    output.append((Zero.size()+One.size()+1)+" ");
                    One.add(Zero.size()+One.size()+1);
                }
            }else {
                if (One.size()>0){
                    output.append(One.get(One.size()-1)+" ");
                    Zero.add(One.remove(One.size()-1));
                }else {
                    output.append((Zero.size()+One.size()+1)+" ");
                    Zero.add(Zero.size()+One.size()+1);
                }

            }
        }
        System.out.println(Zero.size()+One.size());
        System.out.println(output);
    }
}

/*****
 *
 *
 *
 * 0 1
 *
 *
 *
 *
 *
 *
 * */