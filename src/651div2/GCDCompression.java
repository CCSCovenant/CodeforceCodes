import java.util.Scanner;

public class GCDCompression {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int C = sc.nextInt();
        for (int i=0;i<C;i++){
            Compression(sc);
        }
    }
    private static void Compression(Scanner sc){
        int n = sc.nextInt();
        int[] b = new int[2*n];
        int[] s = new int[2*n];
        int odd = 0;
        int even =0;
        for (int i=0;i<(2*n);i++){
            int a = sc.nextInt();
            b[i] = a;
            s[i] = a%2;
            if (s[i]==0){
                even++;
            }else {
                odd++;
            }
        }
        if (even%2==0){
            if (even==0){
                int counter = 0;
                for (int i=0;i<(2*n);i++){
                    if (s[i]==1&&b[i]!=0){
                        b[i]=0;
                        counter++;
                    }
                    if (counter==2){
                        break;
                    }
                }
            }else {
                int counter = 0;
                for (int i=0;i<(2*n);i++){
                    if (s[i]==0&&b[i]!=0){
                        b[i]=0;
                        counter++;
                    }
                    if (counter==2){
                        break;
                    }
                }
            }

        }else {
            for (int i=0;i<(2*n);i++){
                if (s[i]==0&&b[i]!=0){
                    b[i]=0;
                    break;
                }
            }
            for (int i=0;i<(2*n);i++) {
                if (s[i] == 1 && b[i] != 0) {
                    b[i] = 0;
                    break;
                }
            }
        }

        for (int i=0;i<(2*n);i++){
                if (b[i]!=0){
                    for (int j=i+1;j<(2*n);j++){
                        if (s[i]==s[j]&&b[j]!=0){
                            b[i]=0;
                            b[j]=0;
                            System.out.print((i+1)+" ");
                            System.out.println(j+1);
                            break;
                        }
                    }
                }else {

                }
            }

    }
}



//2n ->
// 奇数个偶数 奇数个奇数 -> 丢掉一个奇数一个偶数 -> 偶数+偶数 奇数+奇数
// 偶数个偶数 奇数个奇数 -> //不可能
// 奇数个偶数 偶数个奇数 -> //不可能
// 偶数个偶数 偶数个奇数 -> 丢两个偶数 -
// -> gcd(b[]) = 2


