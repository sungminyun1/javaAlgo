package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
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
        for(int i = 0; i<M; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken());
            int dest = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            MAP[start][dest] = cost;
        }
        for(int i = 1;i<=N; i++){
            int tMax = BFS(i,X,new int[N+1]);
            int tMax2 = BFS(X,i,new int[N+1]);
            MAX = Math.max(MAX,tMax+tMax2);
        }
        System.out.println(MAX);
    }

    private static int BFS(int start,int dest, int[] visited){
        double result = Double.POSITIVE_INFINITY;
        Stack<int[]> needVisit = new Stack<>();
        for(int i = 1; i<=N; i++){
            visited[i] = (int)Double.POSITIVE_INFINITY;
            if(MAP[start][i] != 0){
                int[] val = {i,MAP[start][i]};
                needVisit.push(val);
            }
        }
        visited[start] = -1;
        while(needVisit.size() != 0){
            int[] val = needVisit.pop();
            int now = val[0];
            int cost = val[1];
            if(now == dest){
                result = Math.min(result,cost);
                continue;
            }
            if (visited[now] < cost){
                continue;
            }
            visited[now] = cost;
            for(int i=1; i<=N; i++){
                if(MAP[now][i] != 0 ){
                    int[] next = {i,cost + MAP[now][i]};
                    needVisit.push(next);
                }
            }
        }
        return (int)result;
    }

}
