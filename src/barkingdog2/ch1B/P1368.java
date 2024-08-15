package barkingdog2.ch1B;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P1368 {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static int N, RESULT = 0;
    public static boolean[] visited;
    public static int[] nodesVal;
    public static ArrayList<Integer> nodesOrder = new ArrayList<>();
    public static List<ArrayList<Integer[]>> adj = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        visited = new boolean[N];
        nodesVal = new int[N];
        for(int i = 0; i < N; i++) {
            adj.add(new ArrayList<>());
            int t = Integer.parseInt(br.readLine());
            nodesVal[i] = t;
            nodesOrder.add(i);
        }
        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                int t = Integer.parseInt(st.nextToken());
                if(t == 0) continue;
                adj.get(i).add(new Integer[]{j, t});
            }
        }
        nodesOrder.sort((a,b) -> nodesVal[a] - nodesVal[b]);
        for (Integer now : nodesOrder) {
            if(visited[now]) continue;
            search(now);
        }

        System.out.println(RESULT);
    }

    public static void search(Integer start){
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start, nodesVal[start]));

        while(!pq.isEmpty()){
            Node now = pq.poll();
            if(visited[now.to]) continue;

            visited[now.to] = true;
            RESULT += now.val;

            ArrayList<Integer[]> neighbors = adj.get(now.to);
            for(Integer[] neighbor : neighbors) {
                int nextIdx = neighbor[0];
                int nextVal = neighbor[1];
                if(visited[nextIdx] || nextVal > nodesVal[nextIdx]) continue;
                pq.add(new Node(nextIdx, nextVal));
            }
        }
    }

    public static class Node implements Comparable<Node>{
        int to, val;

        public Node(int to, int val) {
            this.to = to;
            this.val = val;
        }

        public int compareTo(Node o){
            return this.val - o.val;
        }
    }
}
