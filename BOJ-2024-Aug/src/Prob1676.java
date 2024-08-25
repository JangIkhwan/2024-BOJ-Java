import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Prob1676 {
    /*
    3차 시도 : 성공

    0의 개수는 10이 몇 번 곱해져 있는지와 같음
    팩토리얼 계산 시에 10이 몇 번 곱해지는지 구하면 됨

    사실 더 빨리 계산하려면 팩토리얼을 소인수분해할 때 5가 몇 승인지 구하면 됨
    2의 배수가 5의 배수보다 많기 때문에 5의 승을 구하면 10의 승을 알 수 있음
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int twoCount = 0;
        int fiveCount = 0;
        boolean isVisited1[] = new boolean[501]; // 중복하여서 개수를 계산하지 않기 위해서 사용
        boolean isVisited2[] = new boolean[501];
        for(int power = 9; power >= 1; power--){ // 500을 넘는 2의 9승
            int divisor = (int)Math.pow(2, power);
            for(int i = N; i >= 2; i--){
                if(divisor > i) break;
                if(!isVisited1[i] && i % divisor == 0){
                    isVisited1[i] = true;
                    twoCount += power;
                }
            }
        }
        for(int power = 4; power >= 1; power--) {
            int divisor = (int) Math.pow(5, power);
            for (int i = N; i >= 2; i--) {
                if(divisor > i) break;
                if (!isVisited2[i] && i % divisor == 0) {
                    isVisited2[i] = true;
                    fiveCount += power;
                }
            }
        }
        System.out.println(Math.min(twoCount, fiveCount));
    }
    /*
    2차 시도 : 틀렸습니다.
     */
    public static void failure2(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int twoCount = 0;
        int fiveCount = 0;
        int power = 9;
        int divisor = (int)Math.pow(2, power);
        for(int i = N; i >= 2; i--){
            while(divisor > i){
                divisor /= 2;
                power--;
            }
            if(i % divisor == 0){
                twoCount += power;
            }
        }
        power = 4;
        divisor = (int)Math.pow(5, power);
        for(int i = N; i >= 2; i--){
            while(divisor > i){
                divisor /= 5;
                power--;
            }
            if(i % divisor == 0){
                fiveCount += power;
            }
        }
        System.out.println(Math.min(twoCount, fiveCount));
    }

    /*
    1차 시도 : 시간 초과
     */
    public static void failure1(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int fact = 1;
        int zeroCount = 0;
        for(int i = 2; i <= N; i++){
            if(i % 2 == 0 || i % 5 == 0){
                fact *= i;
            }
            while(fact % 10 == 0){
                fact /= 10;
                zeroCount += 1;
            }
        }
        System.out.println(zeroCount);
    }

    public static void fact(int n){
        Long fact = 1L;
        for(int i = 2; i <= n; i++){
            fact *= i;
        }
        System.out.println(fact);
    }
}
