import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class A {
    static Scanner sc = new Scanner(System.in);
    static StringBuilder output = new StringBuilder();
    public static void main(String[] args) throws IOException {
        int t = sc.nextInt();
        while (t-- >0){
            int n = sc.nextInt();
            String numString = sc.next();
            boolean flag = false;
            if (n%2==0){
                flag = true;
                for (int i=1;i<numString.length();i+=2){
                    if (Character.getNumericValue(numString.charAt(i))%2==0){
                        flag = false;
                    }
                }
            }else {
                for (int i=0;i<numString.length();i+=2){
                    if (Character.getNumericValue(numString.charAt(i))%2!=0){
                        flag = true;
                    }
                }
            }
            if (flag){
                output.append(1+"\n");
            }else {
                output.append(2+"\n");
            }
        }
        System.out.println(output);
    }
}
