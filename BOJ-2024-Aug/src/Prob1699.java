import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Prob1699 {
    /*
    1699

    3차 시도 : 성공!
    24/08/24 09:30 ~ 09:50
     */
    private static int[] dp = new int[100001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        dp[1] = 1;
        dp[2] = 2;
        for(int i = 3; i <= N; i++){
            int sqrt = (int)Math.sqrt(i);
            if(sqrt * sqrt == i){
                dp[i] = 1;
            }
            else{
                dp[i] = i;
                for(int j = 1; j * j < i; j++){
                    dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
                }
            }
        }
        System.out.println(dp[N]);
    }

    /*
   1699

   2차 시도 : 틀렸습니다
   24/08/23 23:40~ 00:40
    */
    public static void fail1(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        for(int i = 3; i <= N; i++){
            int sqrt = (int)Math.sqrt(i);
            if(sqrt * sqrt == i) {
                dp[i] = 1;
            }
            else{
                dp[i] = i;
                while(((sqrt + 1) * (sqrt + 1) < i)) sqrt++;
                int square = sqrt * sqrt;
                dp[i] = Math.min(dp[i], dp[i - square] + 1);
                for(int j = 1; j < square && i - square + j < square; j++)
                    dp[i] = Math.min(dp[i], dp[i - square + j] + dp[square - j]);
            }
        }
        System.out.println(dp[N]);
    }

    /*
    1차 시도 : 스택 오버 플로우 발생


     */
    public static int solve(int n){
        if(n == 1) return 1;
        int ret = dp[n];
        if(ret != -1) return ret;
        int sqrt = (int)Math.sqrt(n);
        if(sqrt * sqrt == n) {
            ret = 1;
        }
        else{
            ret = n;
            for(int i = 1; i < n / 2; i++)
                ret = Math.min(ret, solve(n - i) + solve(i));
        }
        return dp[n] = ret;
    }
}