import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Prob9466 {
    /*
    24/08/23 17:24 ~
    9466

    싸이클에 포함되지 않는 정점의 개수를 구하면 될 듯 함
     */
    private static int graph[];
    private static boolean visited[];
    private static int cycleElementNumber;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        while(T-- > 0){

            int N = Integer.parseInt(br.readLine());
            visited = new boolean[N + 1];
            graph = new int[N + 1];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i = 1; i <= N; i++){
                int vertex = Integer.parseInt(st.nextToken());
                graph[i] = vertex;
            }
            int result = N;
            for(int vertex = 1; vertex <= N; vertex++){
                cycleElementNumber = 0;
                if(!visited[vertex]){
                    dfs(vertex, new ArrayList<>());
                    result -= cycleElementNumber;
                }
            }
            bw.write(String.valueOf(result) + "\n");
            bw.flush();
        }
        bw.close();
    }

    public static void dfs(int start, List<Integer> cycle){
        visited[start] = true;
        cycle.add(start);
        int next = graph[start];
        if(!visited[next]){
            dfs(next, cycle);
        }
        else{
            if(cycle.contains(next)){
                int index = cycle.indexOf(next);
                cycleElementNumber = cycle.size() - index;
            }
        }
    }
}