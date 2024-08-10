package barkingdog2.ch1A;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P2623 {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static int N,M;
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int[] deg = new int[N + 1];
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            int prev = 0;
            for(int j = 0; j < t; j++) {
                int now = Integer.parseInt(st.nextToken());
                if(prev == 0){
                    prev = now;
                }else{
                    adj.get(prev).add(now);
                    deg[now]++;
                    prev = now;
                }
            }
        }

        boolean[] visited = new boolean[N + 1];
        Queue<Integer> q = new LinkedList<>();
        for(int i = 1; i <= N; i++) {
            if(deg[i] == 0) q.add(i);
        }

        int checkCount = 0;
        StringBuilder sb = new StringBuilder();
        while(!q.isEmpty()) {
            int now = q.poll();
            if(visited[now]) continue;

            visited[now] = true;
            checkCount++;
            sb.append(now).append("\n");
            ArrayList<Integer> neighbors = adj.get(now);
            for(Integer i : neighbors) {
                if(visited[i]) continue;
                deg[i]--;
                if(deg[i] == 0) q.add(i);
            }
        }

        System.out.println(checkCount == N ? sb : 0);
    }
}
