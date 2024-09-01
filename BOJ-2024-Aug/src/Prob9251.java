import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Prob9251 {
    /*
    9251
    24/09/01 16:16 ~ 17:00


    dp[i][j]
        A   C   A   Y   K   P
    C   0   1   1   1   1   1
    A   1   1   1+1 2   2   2
    P   1   1   2   2   2   1+2
    C   1   1+1 2   2   2   2
    A   1   2   1+2 3   3   3
    K   1   2   3   3   1+3 4

        A   A   C
    A   1   1   1
    C   1   1   1+1

    A[i] == B[i]이면, dp[i][j] = 1 + dp[i - 1][j - 1]
     A[i] != B[i]이면, dp[i][j] = max(dp[i - 1][j], [1][j - 1])
     */

    private static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String A = br.readLine();
        String B = br.readLine();
        dp = new int[A.length()][B.length()];
        for(int i = 0; i < A.length(); i++){
            for(int j = 0; j < B.length(); j++){
                if(A.charAt(i) == B.charAt(j)){
                    if(i > 0 && j > 0){
                        dp[i][j] = 1 + dp[i - 1][j - 1];
                    }
                    else{
                        dp[i][j] = 1;
                    }
                }
                else{
                    if(j <= 0){
                        if(i > 0)
                            dp[i][j] = dp[i - 1][j];
                    }
                    else{
                        dp[i][j] = Math.max(dp[i][j], dp[i][j - 1]);
                        if(i > 0) dp[i][j] = Math.max(dp[i][j], dp[i - 1][j]);
                    }
                }

            }
        }
        System.out.println(dp[A.length() - 1][B.length() - 1]);
    }

    /*
   2차 시도 : 실패

   ACAYKP
   CAPCAK

    dp[i][j]
  j\i  1   2   3   4   5   6
   1   0   1   1   1   1   1
   2   1   1   1+dp[2][2] 2   2   2
   3   1   dp[2][1]  2   2   2   1 + dp[3][5]
   4   dp[1][3]  1+dp[4][1]  2  2   2   2
   5   1   dp[2][4]  1+dp[5][2]  3   3   3
   6   0   0   0   0   1 + dp[3][5]  0
  */

    public static void fail2(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String a = br.readLine();
        String b = br.readLine();
        if(a.length() < b.length()){
            String temp = a;
            a = b;
            b = temp;
        }
        int[][] dp = new int[a.length()][b.length()];
        for(int i = 0; i < a.length(); i++){
            for(int j = 0; j < b.length(); j++){
                if(a.charAt(i) == b.charAt(j)){
                    dp[i][j] = 1;
                    if(j > 0)
                        dp[i][j] += dp[i][j - 1];
                }
                else{
                    if(i > 0)
                        dp[i][j] = dp[i - 1][j];
                    if(i == 0 && j > 0)
                        dp[i][j] = dp[i][j - 1];
                }
            }
        }
        System.out.println(dp[a.length() - 1][b.length() -1 ]);
    }

    /*
    9251
    1차 시도 : 시간 초과
    24/08/25 13:45 ~ 14:17

    ACAYKP
    CAPCAK

    dp[i][j]
   j\i  1   2   3   4   5   6
    1   0   1   0   0   0   0
    2   1   0   1+dp[2][1] 0   0   0   // dp[3][2] = 1 + max(dp[2][1], ...)
    3   0   0   0   0   0   1 + dp[3][2]
    4   0   1+dp[1][2]  0   0   0   0
    5   0   0   1 + dp[2][4]  0   0   0
    6   0   0   0   0   1 + dp[3][5]  0


     dp[i][j]
   j\i  1   2   3   4   5   6
    1   0   1   1   1   1   1
    2   1   1   1+dp[2][2] 2   2   2
    3   1   dp[2][1]  2   2   2   1 + dp[3][5]
    4   1   1+dp[3][1]  4   4   4   4
    5   0   0   1 + dp[2][4]  0   0   0
    6   0   0   0   0   1 + dp[3][5]  0
   */

    public static void fail1(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String a = br.readLine();
        String b = br.readLine();
        int[][] dp = new int[a.length()][b.length()];
        int answer = 0;
        for(int i = 0; i < a.length(); i++){
            for(int j = 0; j < b.length(); j++){
                if(a.charAt(i) == b.charAt(j)){
                    dp[i][j] = 1;
                    int frontMaxLenth = 0;
                    for(int k = 0; k < i; k++){
                        for(int l = 0; l < j; l++){
                            frontMaxLenth = Math.max(frontMaxLenth, dp[k][l]);
                        }
                    }
                    dp[i][j] += frontMaxLenth;
                    answer = Math.max(answer, dp[i][j]);
                }
            }
        }
        System.out.println(answer);
    }
}


