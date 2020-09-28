import java.util.Scanner;

public class A {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args){
        int n = sc.nextInt();
        StringBuilder ans = new StringBuilder();
        for (int i=0;i<n;i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            if (b>a){
                ans.append(b-a+"\n");
            }else if (b%2!=a%2){
                ans.append(1+"\n");
            }else {
                ans.append(0+"\n");
            }
        }
        System.out.println(ans);
    }
}
/***
 *
 *
 * 0 4 5
 * 0 3 5
 *
 * */