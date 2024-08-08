package barkingdog2.ch19;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P11725 {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static int N;
    public static List<List<Integer>> adj = new ArrayList<List<Integer>>();
    public static int[] parent;
    public static boolean[] visited;
    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        parent = new int[N+1];
        visited = new boolean[N+1];
        for (int i = 0; i <= N; i++) {
            adj.add(new ArrayList<>());
        }

        for(int i =0; i<N-1; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            adj.get(from).add(to);
            adj.get(to).add(from);
        }

        Queue<List<Integer>> q = new LinkedList<>();
        q.add(Arrays.asList(0,1));
        while(!q.isEmpty()){
            List<Integer> curr = q.poll();
            int par = curr.get(0);
            int now = curr.get(1);
            if(visited[now]) continue;

            visited[now] = true;
            parent[now] = par;

            List<Integer> neighbors = adj.get(now);
            for(Integer neighbor : neighbors){
                if(!visited[neighbor]){
                    q.add(List.of(now, neighbor));
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 2; i <= N; i++){
            sb.append(parent[i]).append("\n");
        }

        System.out.println(sb);
    }
}
