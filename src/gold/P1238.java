package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P1238 {
    private static int[][] MAP;
    private static int N;
    private static int M;
    private static int X;
    private static int MAX = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        MAP = new int[N + 1][N + 1];
        for(int i =0; i<N+1; i++){
            Arrays.fill(MAP[i], Integer.MAX_VALUE);
        }

        for(int i = 0; i<M; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken());
            int dest = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            MAP[start][dest] = cost;
        }

        for(int i=1; i<=N; i++){
            int maxCandi = Dijkstra(i, X) + Dijkstra(X, i);
            MAX = Math.max(MAX, maxCandi);
        }

        System.out.println(MAX);
    }

    public static int Dijkstra(int start, int dest){
        int[] visited = new int[N+1];
        int[] shortWay = new int[N+1];
        for(int i =1; i<=N; i++){
            shortWay[i] = MAP[start][i];
        }
        visited[start] = 1;
        while(true){
            if(isDone(visited)){
                break;
            }
            int t_min = Integer.MAX_VALUE;
            int nextIdx = 0;
            for(int i=1; i<shortWay.length; i++){
                if(visited[i] == 0 && shortWay[i] < t_min){
                    t_min = shortWay[i];
                    nextIdx = i;
                }
            }

            visited[nextIdx] = 1;
            for(int i =1; i<=N; i++){
                if(MAP[nextIdx][i] != Integer.MAX_VALUE){
                    int candi = shortWay[nextIdx] + MAP[nextIdx][i];
                    if(candi < shortWay[i]){
                        shortWay[i] = candi;
                    }
                }
            }
        }

        return shortWay[dest];
    }

    public static boolean isDone(int[] visited){
        for(int i =1; i<visited.length; i++){
            if(visited[i] == 0){
                return false;
            }
        }
        return true;
    }
}
