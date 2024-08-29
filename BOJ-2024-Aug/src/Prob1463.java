import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Prob1463 {
    /*
    1463
    15:48 ~

    2 -> 1

    10 -> 5
    -> 9

    5 -> 1

    9 -> 3 -> 1
    -> 8

    3 -> 1

    8 -> 4
    -> 7

    4 -> 2 -> 1

    dp[i] : i를 1로 만드는 연산의 최소 횟수

    dp[10] = min(dp[10 / 2], dp[10 - 1]) + 1
    dp[9] = min(dp[9/3], dp[9 - 1]) + 1
    dp[3] = 1
     */
    private static int[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        dp = new int[N + 4];
        dp[2] = dp[3] = 1;
        for(int i = 4; i <= N; i++){
            dp[i] = dp[i - 1] + 1;
            if(i % 2 == 0) dp[i] = Math.min(dp[i], dp[i / 2] + 1);
            if(i % 3 == 0) dp[i] = Math.min(dp[i], dp[i / 3] + 1);
        }
        System.out.println(dp[N]);
    }
}


