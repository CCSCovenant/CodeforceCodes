import java.util.Scanner;

public class OmkarandBaseball {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int c = sc.nextInt();
        for (int j =0;j<c;j++){
            solve(sc);
        }
    }
    private static void solve(Scanner sc){
        int l = sc.nextInt();
        int[] a = new int[l];
        boolean flag1 = true;
        boolean flag2 = true;
        for (int i=0;i<l;i++){
            a[i] = sc.nextInt();
            if (a[i]!=i+1){
                flag1 = false;
            }
            if (a[i]==i+1){
                flag2 = false;
            }
        }
        if (flag1){
            System.out.println(0);
        }else if (flag2){
            System.out.println(1);
        }else {
            System.out.println(2);
        }

    }
}

// [i-n]
// [  i+1 i+2 i+3 i+4
//

//   3 2 1 5 4 7 6
//   5         6 7
//    a[i] == i;
//
//   9 2 8 1 3 7