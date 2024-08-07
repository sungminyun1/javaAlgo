package barkingdog2.ch18;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P1260 {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static int N,M,START;
    public static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        START = Integer.parseInt(st.nextToken());
        for (int i = 0; i < N+1; i++) {
            graph.add(new ArrayList<>());
        }

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            graph.get(from).add(to);
            graph.get(to).add(from);
        }

        for(int i =1; i <= N; i++) {
            graph.get(i).sort(Integer::compareTo);
        }

        DFS(START);
        BFS(START);
    }

    public static void DFS(int start) {
        boolean[] visited = new boolean[N+1];
        StringBuilder sb = new StringBuilder();

        Stack<Integer> stack = new Stack<>();
        stack.push(start);

        while(!stack.isEmpty()) {
            int curr = stack.pop();

            if(visited[curr]) continue;

            visited[curr] = true;
            sb.append(curr).append(" ");

            ArrayList<Integer> neighbors = graph.get(curr);
            for(int i = neighbors.size() - 1; i >= 0; i--) {
                int neighbor = neighbors.get(i);
                if(!visited[neighbor]) stack.push(neighbor);
            }
        }

        System.out.println(sb);
    }

    public static void BFS(int start) {
        boolean[] visited = new boolean[N+1];
        StringBuilder sb = new StringBuilder();

        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);

        while(!queue.isEmpty()) {
            int curr = queue.poll();

            if(visited[curr]) continue;

            visited[curr] = true;
            sb.append(curr).append(" ");

            ArrayList<Integer> neighbors = graph.get(curr);
            for(Integer neighbor : neighbors) {
                if(!visited[neighbor]) queue.add(neighbor);
            }
        }

        System.out.println(sb);
    }
}
