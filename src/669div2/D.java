import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class D {
    static Scanner sc = new Scanner(System.in);
    static int[] height;
    static int[] dp;

    public static void main(String[] args) {
        int n = sc.nextInt();
        height = new int[n];
        dp = new int[n];
        dp[0] = 0;
        for (int i = 0; i < n; i++) {
            height[i] = sc.nextInt();
        }
        Stack<Integer> rise = new Stack<Integer>();
        Stack<Integer> fail = new Stack<Integer>();
        rise.push(0);
        fail.push(0);
        for (int i = 1; i < n; i++) {
            dp[i] = dp[i-1]+1;

            if (rise.isEmpty()) {
                rise.push(i);
            } else if (height[rise.peek()] < height[i]) {
                rise.push(i);
            } else {
                while (!rise.isEmpty() && height[rise.peek()] > height[i]) {
                    rise.pop();
                    if (!rise.isEmpty()) {
                        dp[i] = Math.min(dp[i], dp[rise.peek()] + 1);
                    }
                }
                while (!rise.isEmpty() && height[rise.peek()] == height[i]) {
                    rise.pop();
                }
                rise.push(i);
            }


            if (fail.isEmpty()) {
                fail.push(i);
            } else if (height[fail.peek()] > height[i]) {
                fail.push(i);
            } else {
                while (!fail.isEmpty() && height[fail.peek()] < height[i]) {
                    fail.pop();
                    if (!fail.isEmpty()){
                        dp[i] = Math.min(dp[i], dp[fail.peek()] + 1);
                    }
                }
                while (!fail.isEmpty() && height[fail.peek()] == height[i]) {
                    fail.pop();
                }
                fail.push(i);
            }
        }

        System.out.println(dp[n - 1]);

    }
}
//   a[i]
//
//
//         6 7 6 2

//3 5 6 4 5 6 3