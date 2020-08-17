import java.util.ArrayList;
import java.util.Scanner;

public class OmkarandCircle {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int c = sc.nextInt();
        for (int j =0;j<c;j++){
            solve(sc);
        }
    }
    private static void solve(Scanner sc){
        int l = sc.nextInt();
        ArrayList<Long> list = new ArrayList<>();
        for (int i=1;i<l;i++){
            list.add((long)sc.nextInt());
        }
        long NewValue;
        long min;
        int mini;
        while (list.size()>1){
            min = list.get(0);
            mini = 0;
            for (int i=1;i<list.size();i++){
                if (list.get(i)<min){
                    mini = i;
                    min = list.get(i);
                }
            }
            int Lari = mini +1;
            if (Lari == list.size()){
                Lari = 0;
            }
            int Lowi = mini-1;
            if (Lowi == -1){
                Lowi = list.size()-1;
            }
           NewValue = list.get(Lari)+list.get(Lari);
            list.set(mini,NewValue);
            list.remove(Math.max(Lari,Lowi));
            list.remove(Math.min(Lari,Lowi));
        }
        System.out.println(list.get(0));

    }
}

//