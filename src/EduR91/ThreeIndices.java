import java.util.Scanner;

public class ThreeIndices {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int Case = sc.nextInt();
        for (int i=0;i<Case;i++){
            Solve(sc);
}

    }
    private static void Solve(Scanner sc){
        int n = sc.nextInt();
        int Nindex=-1;
        int[] a = new int[n];
        for (int i =0;i<n;i++){
            a[i] = sc.nextInt();
        }
        int min = a[0];
        int firstindex = 1;
        int midindex = 0;
        int lastindex = 0;
        boolean flag = false;
        for (int i=1;i<n-1;i++){
            if (a[i]>min){
                midindex = i+1;
                for (int j=i;j<n;j++){
                    if (a[j]<a[i]){
                        lastindex = j+1;
                        flag = true;
                    }
                }
                if (flag){
                    break;
                }else {

                }

            }else {
                min = a[i];
                firstindex = i+1;
            }
        }
        if (lastindex==0||midindex==0){
            System.out.println("NO");
        }else {
            System.out.println("YES");
            System.out.print(firstindex);
            System.out.print(" "+midindex);
            System.out.println(" "+(lastindex));
        }
    }
}

//6 5 1 2 3 4