import java.util.Scanner;

public class C {
    static Scanner sc = new Scanner(System.in);
    static int n;
    static int k;
    static String s;
    static char[] CharArray;
    static StringBuilder ans;
    public static void main(String[] args){
        int t = sc.nextInt();
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < t; i++){
             n = sc.nextInt();
             k = sc.nextInt();
             s = sc.next();
             CharArray = s.toCharArray();
            if (Solve()){
                ans.append("YES"+"\n");
            }else {
                ans.append("NO"+"\n");
            }
        }
        System.out.println(ans);
    }

    public static boolean Solve(){
        for (int i=0;i<k;i++){
            char tmp = CharArray[i];
            for (int j=i;j<n;j += k){
                if (tmp=='?'){
                    if (CharArray[j]!='?'){
                        tmp = CharArray[j];
                    }
                }else {
                    if (CharArray[j]!='?'){
                        if (tmp != CharArray[j]){
                            return false;
                        }
                    }
                }
            }
            for (int j=i;j<n;j += k){
                CharArray[j] = tmp;
            }
        }
        int counter =0;
        int Qcounter = 0;
        int QuestionCounter =0;
        for (int i=0;i<k;i++){
            if (CharArray[i]=='1'){
                counter++;
            }else if (CharArray[i]=='?'){
                QuestionCounter++;
            }
        }
        if (counter<=k/2 && k/2<=counter+QuestionCounter){
            Qcounter = k/2-counter;
        }else {
            return false;
        }

        for (int i=k;i<n;i++){
            int out = i-k;
            if (CharArray[i]=='1'){
                if (CharArray[out]=='?'){
                    if (Qcounter==0&&QuestionCounter==1){
                        return false;
                    }
                    if (Qcounter<0||QuestionCounter<0){
                        return false;
                    }
                    Qcounter--;
                    QuestionCounter--;
                }else {
                    if (CharArray[out]=='0'){
                        return false;
                    }
                }
            }
            else if (CharArray[i]=='0'){
                if (CharArray[out]=='?'){
                    if (Qcounter==1&&QuestionCounter==1){
                        return false;
                    }
                    if (Qcounter<0||QuestionCounter<0){
                        return false;
                    }
                    QuestionCounter--;

                }else {
                    if (CharArray[out]=='1'){
                        return false;
                    }
                }
            }
            else {
                if (CharArray[out]!='?') {
                    CharArray[i] = CharArray[out];
                }

            }

        }
        return true;
    }
    /*
    public static boolean Solve(){
        int counter =0;
        int Qcounter = 0;
        int QuestionCounter =0;
        for (int i=0;i<k;i++){
            if (CharArray[i]=='1'){
                counter++;
            }else if (CharArray[i]=='?'){
                QuestionCounter++;
            }
        }
        if (counter<=k/2 && k/2<=counter+QuestionCounter){
            Qcounter = k/2-counter;
        }else {
            return false;
        }

        for (int i=k;i<n;i++){
           int out = i-k;
            if (CharArray[i]=='1'){
                if (CharArray[out]=='?'){
                    if (Qcounter==0&&QuestionCounter==1){
                        return false;
                    }
                    if (Qcounter<0||QuestionCounter<0){
                        return false;
                    }
                    Qcounter--;
                    QuestionCounter--;
                }else {
                    if (CharArray[out]=='0'){
                        return false;
                    }
                }
            }
            else if (CharArray[i]=='0'){
                if (CharArray[out]=='?'){
                    if (Qcounter==1&&QuestionCounter==1){
                        return false;
                    }
                    if (Qcounter<0||QuestionCounter<0){
                        return false;
                    }
                    QuestionCounter--;

                }else {
                    if (CharArray[out]=='1'){
                        return false;
                    }
                }
            }
            else {
                if (CharArray[out]!='?') {
                    CharArray[i] = CharArray[out];
                }

            }

        }
        return true;
    }*/

}


//????????00

//0011001100

//k=4