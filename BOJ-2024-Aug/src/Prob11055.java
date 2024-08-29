import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Prob11055 {

    /*
    11055

    1차 시도 : 성공
    24/08/29 10:58 ~ 11:17
     1, 100, 2, 50, 60, 3, 5, 6, 7, 8

     1
     101
     3
     53

     dp[i] = max(dp[i], dp[j] + current) // j = current보다 작은 수의 인덱스
     */
    private static int[] dp;
    private static int[] numbers;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        numbers = new int[N + 1];
        for(int i = 1; i <= N; i++){
            numbers[i] = Integer.parseInt(st.nextToken());
        }
        dp = new int[N + 1];
        int answer = 0;
        for(int i = 1; i <= N; i++){
            dp[i] = numbers[i];
            for(int j = 1; j < i; j++){
                if(numbers[j] < numbers[i]){
                    dp[i] = Math.max(dp[i], numbers[i] + dp[j]);
                }
            }
            answer = Math.max(answer, dp[i]);
        }
        System.out.println(answer);
    }
}


