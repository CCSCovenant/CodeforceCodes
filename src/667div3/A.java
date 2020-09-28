import java.util.Scanner;

public class A {
    static Scanner sc = new Scanner(System.in);
    static StringBuilder ans = new StringBuilder();
    public static void main(String[] args){
        int t = sc.nextInt();
        for (int i=0;i<t;i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            int move = Math.abs(a-b)/10;
            if (Math.abs(a-b)%10!=0){
                move++;
            }
            ans.append(move+"\n");
        }
        System.out.println(ans);
    }
}
