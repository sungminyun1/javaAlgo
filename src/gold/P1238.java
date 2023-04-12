package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;

public class P1238 {
    private static int N,M,X,MAX;
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    private static List<List<Node>> graph, reverseGraph;
    private static int[] dist,reverseDist;

    static class Node implements Comparable<Node>{
        public int index, distance;
        public Node(int index, int distance){
            this.index = index;
            this.distance = distance;
        }

        @Override
        public int compareTo(Node node) {
            return distance - node.distance;
        }
    }

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>();
        reverseGraph = new ArrayList<>();
        for(int i =0; i<=N; i++){
            graph.add(new ArrayList<>());
            reverseGraph.add(new ArrayList<>());
        }
        dist = new int[N+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        reverseDist = new int[N + 1];
        Arrays.fill(reverseDist, Integer.MAX_VALUE);

        for(int i =0; i<M; i++){
            st = new StringTokenizer(br.readLine()," ");
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            graph.get(s).add(new Node(e, d));
            reverseGraph.get(e).add(new Node(s, d));
        }
        Di(graph, dist, X);
        Di(reverseGraph, reverseDist, X);
        MAX = 0;
        for(int i=1; i<dist.length; i++){
            MAX = Math.max(MAX, dist[i] + reverseDist[i]);
        }
        System.out.println(MAX);
    }

    public static void Di(List<List<Node>> list, int[] dist, int start){
        PriorityQueue<Node> pq = new PriorityQueue<>();
        boolean[] visited = new boolean[N + 1];
        Arrays.fill(visited, false);
        pq.add(new Node(start, 0));
        dist[start] = 0;

        while (!pq.isEmpty()) {
            int idx = pq.poll().index;

            if (visited[idx]) {
                continue;
            }
            visited[idx] = true;

            for (Node next : list.get(idx)) {
                if (dist[next.index] > dist[idx] + next.distance) {
                    dist[next.index] = dist[idx] + next.distance;
                    pq.add(new Node(next.index, dist[next.index]));
                }
            }
        }
    }
}
