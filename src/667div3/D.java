import java.util.Scanner;

public class D {
    static Scanner sc = new Scanner(System.in);
    static StringBuilder ans = new StringBuilder();
    public static void main(String[] args){
        int t = sc.nextInt();
        for (int i=0;i<t;i++){
            long n = sc.nextLong();
            int s = sc.nextInt();
            String ns ="";
            ns += n;
            int sum = 0;
            //System.out.println(ns);
            for (int j = ns.length()-1;j>=0;j--){
                //System.out.println("Char at j:"+ns.charAt(j));
                sum+= Integer.parseInt(String.valueOf(ns.charAt(j)));
            }
          //  System.out.println(sum);
            if (sum>s){
                int j = ns.length()-1;
                int d = Integer.parseInt(String.valueOf(ns.charAt(j)));
               // System.out.println("D:"+d);
                long move = 10-d;
                //System.out.println("Move:"+move);
                sum -= Integer.parseInt(String.valueOf(ns.charAt(j)));
                sum += 1;
                while (sum>s){
                    j--;
                     d = Integer.parseInt(String.valueOf(ns.charAt(j)));
                    //System.out.println("D:"+d+"pow"+(ns.length()-1-j)+"fac"+(10-d-1));
                    long diff = (long) Math.pow(10L,(ns.length()-1-j))*(10L-d-1);
                    //System.out.println(diff);
                    move += diff;
                    //System.out.println("Move:"+move);

                    sum -= d;
                }
                ans.append(move+"\n");
            }else {
                ans.append(0+"\n");
            }
           // System.out.println("——————————");

        }
        System.out.println(ans);
    }
}



/***
 *
 *
 *  10000
 *
 *
 * */
