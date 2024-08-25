import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Prob2146 {
    /*
    2146

    24/08/24 10:50 ~
     */
    public static int N;
    public static int [][] map;

    public static int [][] visited;

    public static int [][] footstamp;

    public static int [][] directions = { {-1, 0}, {0, 1}, {1, 0}, {0, -1} };

    public static Queue<Pair> qu = new LinkedList<>();

    public static int result = 300;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        for(int y = 0; y < N; y++){
            String line = br.readLine();
            StringTokenizer st = new StringTokenizer(line);
            for(int x = 0; x < N; x++){
                map[y][x] = Integer.parseInt(st.nextToken());
            }
        }

        visited = new int[N][N];
        footstamp = new int[N][N];
        int islandNumber = 1;
        for(int y = 0; y < N; y++){
            for(int x = 0; x < N; x++){
                if(map[y][x] == 1 && visited[y][x] == 0){
                    qu.clear();
                    for(int i = 0; i < N; i++){
                        for(int j = 0; j < N; j++){
                            footstamp[i][j] = 0;
                        }
                    }
                    visitIsland(y, x, islandNumber); // dfs
                    buildBridge(islandNumber); // bfs
                    islandNumber++;
                }
            }
        }
        System.out.println(result);
    }

    public static void visitIsland(int y, int x, int islandNumber){
        visited[y][x] = islandNumber;

        boolean isEdge = false;
        for(int i = 0; i < directions.length; i++){
            int nextX = x + directions[i][0];
            int nextY = y + directions[i][1];
            if(!inMap(nextY, nextX)) continue;
            if(map[nextY][nextX] == 1){
                if(visited[nextY][nextX] == 0){
                    visitIsland(nextY, nextX, islandNumber);
                }
            }
            else{
                isEdge = true;
            }
        }
        if(isEdge){
            qu.offer(new Pair(y, x, 0));
        }
    }

    public static void buildBridge(int currentIsland){
        while(!qu.isEmpty()){
            int y = qu.peek().y;
            int x = qu.peek().x;
            int step = qu.peek().step;
            qu.poll();
            for(int i = 0; i < directions.length; i++) {
                int nextX = x + directions[i][0];
                int nextY = y + directions[i][1];
                if(!inMap(nextY, nextX)) continue;
                if (visited[nextY][nextX] != currentIsland && footstamp[nextY][nextX] == 0) {
                    footstamp[nextY][nextX] = step + 1;
                    qu.offer(new Pair(nextY, nextX, step + 1));
                    if(map[nextY][nextX] == 1){
                        result = Math.min(result, step);
                        return;
                    }
                }
            }
        }
    }

    public static boolean inMap(int y, int x){
        return y >= 0 && y < N && x >= 0 && x < N;
    }




    /*
    2293

    1차 시도 : 모르겠음...
    24/08/23 20:52 ~23:38

    1 * 1

    1 * 2, 2 * 1

    1 * 3, 1 * 1 + 2 * 1

    1 * 4, 1 * 2 + 2 * 1, 2 * 2

    1 * 10
    1 * 8 + 2 * 1
    1 * 6 + 2 * 2

    2차 시도



     */
    public static void prob2293(String[] args){
        int N = 0, K;
        int[] coins = new int[N];
    }

    static class Pair{
        int x;
        int y;

        int step;

        public Pair(int y, int x, int step){
            this.y = y;
            this.x = x;
            this.step = step;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }
    }
}


