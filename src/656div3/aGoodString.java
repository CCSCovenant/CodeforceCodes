import java.util.Scanner;

public class aGoodString {
    public  static  void  main(String args[]){
        Scanner sc = new Scanner(System.in);
        int Case = sc.nextInt();
        for (int i=0;i<Case;i++){
            Solve(sc);
        }
    }
    public static void Solve(Scanner sc){
        int n = sc.nextInt();
        String a = sc.next();
        System.out.println(minMove(a,'a'));
    }
    public static int minMove(String a,char c){
        int n = a.length();
        int changefirst = 0;
        int changesecond = 0;
        if (n>1){
            for (int i=0;i<n/2;i++){
                if (a.charAt(i)!=c){
                    changefirst++;
                }
            }
            for (int i=n/2;i<n;i++){
                if (a.charAt(i)!=c){
                    changesecond++;
                }
            }
            changefirst += minMove(a.substring(n/2,n),(char)(c+1));
            changesecond+= minMove(a.substring(0,n/2),(char)(c+1));
            return Math.min(changefirst,changesecond);



        }else {
            if (a.charAt(0)==c){
                return 0;
            }else {
                return 1;
            }
        }

    }
}

/*
*
*
*
* a. l=1; if()==a; 0 else 1
*
*
*
* b.
* c.
* */