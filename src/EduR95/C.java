import java.util.Scanner;

public class C {
    static Scanner sc = new Scanner(System.in);
    static StringBuilder output = new StringBuilder();
    public static void main(String[] args){
        int t = sc.nextInt();
        while (t-- > 0){
            int n = sc.nextInt();
            boolean[] map = new boolean[n];
            for (int i=0;i<n;i++){
                if (sc.nextInt()==1){
                    map[i] = true;
                }else {
                    map[i] = false;
                }
            }
            int ans;
            if (map[0]){
                ans = 1;
            }else {
                ans = 0;
            }
            int counter = 0;
            for (int i=1;i<n;i++){
                if (map[i]){
                    counter++;
                }
                if (!map[i]||i==n-1){
                    int tmp = counter/3;
                    ans += tmp;
                    counter = 0;
                }
            }
            output.append(ans+"\n");
        }
        System.out.println(output);
    }
}
// 1 0  0 0         0 1 1 1 1 0 1 1 1 1 1 1 0