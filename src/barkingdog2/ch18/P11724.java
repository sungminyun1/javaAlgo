package barkingdog2.ch18;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P11724 {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static int N,M;
    public static boolean[] visited;
    public static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    public static int result = 0;
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        visited = new boolean[N + 1];
        for(int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from  = Integer.parseInt(st.nextToken());
            int to  = Integer.parseInt(st.nextToken());

            graph.get(from).add(to);
            graph.get(to).add(from);
        }

        for(int i = 1; i <= N; i++) {
            if(!visited[i]) {
                result++;
                solve(i);
            }
        }

        System.out.println(result);
    }

    public static void solve(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);

        while(!queue.isEmpty()) {
            int now = queue.poll();
            if(visited[now]) continue;

            visited[now] = true;

            ArrayList<Integer> neighbors = graph.get(now);
            for(Integer neighbor : neighbors) {
                if(!visited[neighbor]) {
                    queue.add(neighbor);
                }
            }
        }
    }
}
