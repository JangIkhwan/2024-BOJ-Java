import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Prob1904 {
    /*
    24/08/28 23:13 ~ 23:24

    실패 : 나누기 누락
    index out of bound : N = 1인 경우 고려해야 함!
    성공
     */

    private static int[] dp; // 길이가 i인 수열을 만드는 경우의 수
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        dp = new int[N + 2];
        dp[1] = 1;
        dp[2] = 2;
        for(int i = 3; i <= N; i++){
            dp[i] = (dp[i - 1] + dp[i - 2]) % 15746;
        }
        System.out.println(dp[N]);
    }
}


