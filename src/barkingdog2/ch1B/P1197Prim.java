package barkingdog2.ch1B;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class P1197Prim {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static int N,M,VISITED_COUNT = 0, RESULT = 0;
    public static List<ArrayList<Node>> adj = new ArrayList<>();
    public static boolean[] visited;
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        visited = new boolean[N+1];
        for(int i = 0; i <= N; i++) {
            adj.add(new ArrayList<>());
        }

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());

            adj.get(from).add(new Node(from, to, value));
            adj.get(to).add(new Node(to,from, value));
        }

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(0,1,0));

        while(!pq.isEmpty()) {
            Node node = pq.poll();

            int now = node.getTo();
            if(visited[now]) continue;

            visited[now] = true;
            RESULT += node.getValue();
            VISITED_COUNT++;
            if (VISITED_COUNT == N) break;

            ArrayList<Node> neighbours = adj.get(now);
            for(Node neighbour : neighbours) {
                if(visited[neighbour.getTo()]) continue;
                pq.add(neighbour);
            }
        }

        System.out.println(RESULT);
    }


    public static class Node implements Comparable<Node> {
        private int from, to, value;

        public Node(int from, int to, int value) {
            this.from = from;
            this.to = to;
            this.value = value;
        }

        @Override
        public int compareTo(Node o) {
            return value - o.value;
        }

        public int getTo() {
            return to;
        }

        public int getValue() {
            return value;
        }
    }
}
