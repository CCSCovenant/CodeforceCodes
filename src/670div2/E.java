import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class E {
    static Scanner sc = new Scanner(System.in);
    static OutputStream Output = new BufferedOutputStream(System.out);
    static boolean[] sieve;
    static int n;
    static long length;
    static ArrayList<Integer> primes = new ArrayList<>();
    static ArrayList<Integer> factors = new ArrayList<>();

    public static void main(String[] args) throws IOException {

         n = sc.nextInt();
         length = n;
        sieve = new boolean[n+1];

        for (int i=2;i<=n;i++){
            if (!sieve[i]){
                for (int j=2;j*i<=n;j++){
                    sieve[j*i]= true;
                }
            }
        }
        for (int i=2;i<=n;i++){
            if (!sieve[i]){
                primes.add(i);
            }
        }
        for (int i=0;i<primes.size();i += (int)Math.sqrt(primes.size())){
                int end = Math.min((int)(i+Math.sqrt(primes.size())),primes.size());
                if (queryGroup(i,end)){
                queryFactor(i,end);
            }
        }

        for (int i=0;i<factors.size();i++){
            int prime =factors.get(i);
            int actualFactor = prime;
            int j = 2;
            while (Math.pow(prime,j)<=length){
                int tmp = (int)Math.pow(prime,j);
                Operation(0,tmp);
                int value =  sc.nextInt();
                if (value==1){
                    actualFactor = tmp;
                }
                j++;
            }
            factors.set(i,actualFactor);
        }

        int ans = 1;
        for (int i=0;i<factors.size();i++){
            ans *= factors.get(i);
        }
        Operation(2,ans);

    }
    public static boolean queryGroup(int start,int end) throws IOException {
        long ExpectedValue = 0;
        for (int i=start;i<end;i++){
            Operation(1,primes.get(i));
            ExpectedValue += sc.nextInt();
        }
        Operation(0,1);
        int B = sc.nextInt();
        int ActualValue = n - B;
        n = B;
        return ActualValue!=ExpectedValue;
    }
    public static void queryFactor(int start,int end) throws IOException{
        for (int i=start;i<end;i++){
            Operation(0,primes.get(i));
            if ( sc.nextInt()== 1){
                factors.add(primes.get(i));
            }
        }
    }

    public static void Operation(int type,int value) throws IOException {
        switch (type){
            case 0:
                Output.write(("A "+value+"\n").getBytes());
                break;
            case 1:
                Output.write(("B "+value+"\n").getBytes());
                break;
            case 2:
                Output.write(("C "+value+"\n").getBytes());
                break;
            default:
                break;
        }
        Output.flush();

    }

}
/***
 *
 * 1 2 3 4  5 6 7 8 9 10
 *1 3 4 5 7 9
 * 1 4 5 7
 * 2*2*2*2
 *   4
 *     8
 *       16
 *         32
 *
 * 9592
 *               1 3 4
 *
 *0-50000
 * 0-4796 4796 9592
 *
 * 100000
 *  50000
 *  100000/3 - 100000/6
 *  5           10  15
 *  2-n/2
 *              n/2         n
 *  2-n/2
 *
 *  2-n/4
 *  n/4-n/2
 *
 *            1   2-n
 *
 *
 *  2-317
 *
 *        10
 *        0 5 6 10
 *
 *      0 1 2 3 4
 *      0 1
 *      2 3 4
 *
 *      5 6 7 8 9
 *
 *
 *
 *
 *
 *   10 5 2 4 1 0 1 1 2 1 0
 *
 *
 * */