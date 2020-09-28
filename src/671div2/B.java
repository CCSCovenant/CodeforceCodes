import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class B {
    static Scanner sc = new Scanner(System.in);
    static StringBuilder output = new StringBuilder();
    public static void main(String[] args) throws IOException {
        int t = sc.nextInt();
        while (t-- >0){
            long n = sc.nextLong();
            int i = 0;
            while (n-numOfCells(i)>=0){
                n -= numOfCells(i);
                i++;
            }
            output.append(i-1+"\n");
        }
        System.out.println(output);
    }
    public static long numOfCells(int i){

        long n = 1<<i;
        return n*(n-1)/2;
    }
}

