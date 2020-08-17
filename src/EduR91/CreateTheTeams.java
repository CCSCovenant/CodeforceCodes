import java.util.Arrays;
import java.util.Scanner;

public class CreateTheTeams {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int Case = sc.nextInt();
        for (int i=0;i<Case;i++){
            Solve(sc);
        }

    }
    private static void Solve(Scanner sc) {
        int n = sc.nextInt();
        int x = sc.nextInt();
        int[] a = new int[n];
        for (int i=0;i<n;i++){
            a[i]=sc.nextInt();
        }
        Arrays.sort(a);
        int last = n;
        int teamcounter = 0;
        for (int i=n-1;i>=0;i--){
           // System.out.println("Last is "+last+" a[i] is "+a[i]+" i is "+ i);
           if (a[i]*((last-i))>=x){
                last = i;
                teamcounter++;
            }
        }
        System.out.println(teamcounter);
        //System.out.println("——————————————");
    }
}
//  >x <x

//  1 1 1 1 1 1 >x
//  <x  i<x

//  [i.j]/2 x/2<j

//
//
// []