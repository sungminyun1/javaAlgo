package barkingdog2.ch1C;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class P11780 {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static int N,M;
    public static int[][] graph, next;
    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        graph = new int[N + 1][N + 1];
        next = new int[N + 1][N + 1];
        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());
            if(graph[from][to] == 0) {
                graph[from][to] = value;
                next[from][to] = to;
            }else if(graph[from][to] > value) {
                graph[from][to] = value;
                next[from][to] = to;
            }
        }

        for(int i = 1; i <= N; i++) {
            for(int j = 1; j <= N; j++) {
                if(graph[i][j] == 0 && i != j) {
                    next[i][j] = 100_000_000;
                    graph[i][j] = 100_000_000;
                }
            }
        }

        for(int via = 1; via <= N; via++) {
            for(int i = 1; i <= N; i++) {
                for(int j = 1; j <= N; j++) {
                    int viaVal = graph[i][via] + graph[via][j];
                    if(graph[i][j] > viaVal){
                        graph[i][j] = viaVal;
                        next[i][j] = via;
                    }
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

        sb = new StringBuilder();
        for(int i = 1; i <= N; i++) {
            for(int j = 1; j <= N; j++) {
                if (next[i][j] == 0) {
                    sb.append(0).append("\n");
                }else{
                    List<Integer> res = find(new ArrayList<>(), i, j);
                    sb.append(res.size()).append(" ");
                    for (int k : res) {
                        sb.append(k).append(" ");
                    }
                    sb.append("\n");
                }
            }
        }
        System.out.println(sb);
    }

    public static List<Integer> find(List<Integer> list, int now, int dest) {
        list.add(now);
        if(now == dest) return list;
        return find(list, next[now][dest], dest);
    }
}
