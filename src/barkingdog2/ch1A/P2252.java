package barkingdog2.ch1A;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P2252 {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static int N, M;
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int[] deg = new int[N + 1];
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
        for(int i = 0; i <= N; i++) {
            adj.add(new ArrayList<>());
        }

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            adj.get(from).add(to);
            deg[to]++;
        }

        Queue<Integer> q = new LinkedList<Integer>();
        for(int i = 1; i <= N; i++) {
            if(deg[i] == 0) {
                q.add(i);
            }
        }
        StringBuilder sb = new StringBuilder();
        boolean[] visited = new boolean[N + 1];
        while(!q.isEmpty()) {
            int curr = q.poll();

            if(visited[curr]) continue;

            visited[curr] = true;
            sb.append(curr).append(" ");

            ArrayList<Integer> neighbors = adj.get(curr);
            for(Integer neighbor : neighbors) {
                if(!visited[neighbor]) {
                    deg[neighbor]--;
                    if(deg[neighbor] == 0) {
                        q.add(neighbor);
                    }
                }
            }
        }

        System.out.println(sb);
    }
}
