import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Prob10815 {
    /*
    10815
    24/08/25 22:03 ~ 22:24
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] card = new int[N];
        for(int i = 0; i < N; i++){
            card[i] = Integer.parseInt(st.nextToken());
        }
        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int[] querys = new int[M];
        for(int i = 0; i < M; i++){
            querys[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(card);
        for(int query : querys){
            if(binarySearch(card, query)){
                bw.write("1 ");
            }
            else{
                bw.write("0 ");
            }
        }
        bw.flush();
        bw.close();
    }

    public static boolean binarySearch(int[] A, int key){
        int lo = -1;
        int hi = A.length;
        while(lo + 1 < hi){
            int mid = (lo + hi) / 2;
            if(A[mid] <= key){
                lo = mid;
            }
            else{
                hi = mid;
            }
        }
        return lo >= 0 && A[lo] == key;
    }
}


