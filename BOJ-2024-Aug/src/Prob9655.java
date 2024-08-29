import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Prob9655 {
    /*
    24/08/29 00:45 ~ 01:16

    1 s1 -> s
    2 s1 c1 -> c
    3 s3 -> s
    4 s1 c3 -> c
       s3 c1 -> c

     1 -> win
     2 -> loose
     3 -> win
     4 -> loose
     5 -> loose

     */

    private static boolean dp[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        dp = new boolean[N + 1];
        dp[0] = true;
        for(int i = 1; i <= N; i++){
            dp[i] = dp[i - 1];
            if(i >= 3) dp[i] |= dp[i - 3];
        }
        boolean skTurn = false;
        int i = N;
        while(i > 0){
            skTurn = !skTurn;
            if(dp[i - 1]) {
                i -= 1;
            }
            else if(dp[i - 3]){
                i -= 3;

            }
            else{
                if(skTurn){
                    System.out.println("CY");
                }
                System.out.println("SK");
                return;
            }
        }
        if(skTurn){
            System.out.println("SK");
        }
        else{
            System.out.println("CY");
        }
    }
}


