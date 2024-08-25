import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Prob15666 {
    /*
    15666
     */
    private static List<Integer> numbers = new ArrayList<>();
    private static int[] sequence;
    private static int N;

    private static int M;
    private static BufferedWriter bw;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String line = br.readLine();
        String[] token = line.split(" ");
        N = Integer.parseInt(token[0]);
        M = Integer.parseInt(token[1]);

        String numbersLine = br.readLine();
        StringTokenizer st = new StringTokenizer(numbersLine);

        int i = 0;
        boolean hasNumber[] = new boolean[10001];
        while(st.hasMoreTokens()){
            int num = Integer.parseInt(st.nextToken());
            if(!hasNumber[num]){
                numbers.add(num);
                hasNumber[num] = true;
            }
        }
        Collections.sort(numbers);
        sequence = new int[M];
        printSequence(-1, 0);
    }

    public static void printSequence(int prev, int depth) throws IOException {
        if(depth == M){
            for(int i = 0; i < M; i++){
                bw.write(String.valueOf(sequence[i]) + " ");
            }
            bw.write("\n");
            bw.flush();
            return;
        }
        for(int i = 0; i < numbers.size(); i++){
            if(i >= prev){
                sequence[depth] = numbers.get(i);
                printSequence(i, depth + 1);
            }
        }
    }
}