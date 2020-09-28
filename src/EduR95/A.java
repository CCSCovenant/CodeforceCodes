import java.util.Scanner;

public class A {
    static Scanner sc = new Scanner(System.in);
    static StringBuilder output = new StringBuilder();
    public static void main(String[] args){
        int t = sc.nextInt();
        while (t-- >0){
            long x = sc.nextInt();
            long y = sc.nextInt();
            long k = sc.nextInt();
            long ans = k;
            long sticks = k*y+k-1;
            ans += sticks/(x-1);
            if (sticks%(x-1)!=0){
                ans++;
            }
            output.append(ans+"\n");
        }
        System.out.println(output);
    }
}

// x-1
//  10        2 4 8 16


//  k  k*y+k

//