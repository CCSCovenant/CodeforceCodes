import java.util.Scanner;

public class A {
    static Scanner sc = new Scanner(System.in);
    static StringBuilder ans = new StringBuilder();
    public static void main(String[] args){
        int t = sc.nextInt();
        for (int i = 0 ; i < t ; i++){
            int n = sc.nextInt();
            int zeroCounter = 0;
            int oneCounter = 0;
            for (int j = 0 ; j < n ; j++){
                if (sc.nextInt()==1){
                    oneCounter++;
                }else {
                    zeroCounter++;
                }
            }
            if ((n/2)%2==1){
                if (oneCounter>zeroCounter){
                    ans.append(n/2+1+"\n");
                }else {
                    ans.append(n/2+"\n");
                }
            }else {
                    ans.append(n/2+"\n");
            }
            if (zeroCounter==oneCounter){
                for (int j = 0 ; j < n/2 ; j++){
                    ans.append(0+" ");
                }
            }else if (zeroCounter > oneCounter){
                for (int j = 0 ; j < n/2 ; j++){
                    ans.append(0+" ");
                }
            }else {
                if ((n/2)%2==1){
                    for (int j = 0 ; j < n/2+1 ; j++){
                        ans.append(1+" ");
                    }
                }else {
                    for (int j = 0 ; j < n/2 ; j++){
                        ans.append(1+" ");
                    }
                }
            }
            ans.append("\n");
        }
        System.out.println(ans);
    }
}

// 1 == 0
// 1 > 0
// 0 > 1