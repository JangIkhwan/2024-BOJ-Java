import java.io.*;

public class Prob1212 {
    /*
    1차 시도 :
    24/08/22 21:40

    0진수 -> 2진수 문자열 변환 함수 : static String toBinaryString(int i)
    StringBuilder를 이용하면 digit을 이진수로 변환하는 과정을 더 편하게 작성할 수 있음
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String line = br.readLine();

        int digit = Character.digit(line.charAt(0), 10);
        if(digit == 0){
            bw.write("0");
        }
        else{
            printOctToBin(digit, bw);
        }
        for(int i = 1; i < line.length(); i++) {
            digit = Character.digit(line.charAt(i), 10);
            if(digit == 0){
                bw.write("000");
                continue;
            }
            else if (digit < 2) {
                bw.write("00");
            }
            else if (digit < 4) {
                bw.write("0");
            }
            printOctToBin(digit, bw);
        }
        bw.flush();
        bw.close();
    }

    public static void printOctToBin(int digit, BufferedWriter bw) throws IOException {
        if(digit == 0) return;
        printOctToBin(digit / 2, bw);
        bw.write(String.valueOf(digit % 2));
    }
}
