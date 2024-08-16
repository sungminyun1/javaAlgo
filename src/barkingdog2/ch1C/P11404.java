package barkingdog2.ch1C;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P11404 {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static int N,M;
    public static int[][] graph;
    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        graph = new int[N + 1][N + 1];
        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());
            graph[from][to] = graph[from][to] == 0 ? value : Math.min(graph[from][to], value);
        }

        for(int i = 1; i <= N; i++) {
            for(int j = 1; j <= N; j++) {
                if(graph[i][j] == 0 && i != j) graph[i][j] = 100_000_000;
            }
        }

        for(int via = 1; via <= N; via++) {
            for(int i = 1; i <= N; i++) {
                for(int j = 1; j <= N; j++) {
                    graph[i][j] = Math.min(graph[i][j], graph[i][via] + graph[via][j]);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= N; i++) {
            for(int j = 1; j <= N; j++) {
                if(graph[i][j] == 100_000_000) {
                    sb.append(0).append(" ");
                }
                else{
                    sb.append(graph[i][j]).append(" ");
                }

            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
