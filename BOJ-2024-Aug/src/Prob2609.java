import java.io.*;
import java.util.StringTokenizer;

public class Prob2609 {
    /*
    24/08/22 20:54 ~
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String line = br.readLine();
        StringTokenizer st = new StringTokenizer(line);
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int mul = a * b;

        if(a < b) {
            int temp = a;
            a = b;
            b = temp;
        }

        while(true){
            int r =  a % b;
            if(r == 0) break;
            a = b;
            b = r;
        }

        bw.write(String.valueOf(b) + "\n");
        bw.write(String.valueOf(mul / b) + "\n");
        bw.flush();
        bw.close();
    }
}
