package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P1504 {
    public static int N,E,V1,V2;
    public static int[] dist,distV1,distV2;
    public static List<List<Node>> graph;

    public static int MAX_VAL = 20000000;

    static class Node implements Comparable<Node>{
        int index;
        int dist;
        public Node(int index, int dist){
            this.index = index;
            this.dist = dist;
        }
        @Override
        public int compareTo(Node o) {
            return dist - o.dist;
        }
    }

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>();
        for(int i =0; i<=N; i++){
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph.get(u).add(new Node(v, c));
            graph.get(v).add(new Node(u, c));
        }
        st = new StringTokenizer(br.readLine(), " ");
        V1 =  Integer.parseInt(st.nextToken());
        V2 =  Integer.parseInt(st.nextToken());


        dist = Di(N);
        distV1 = Di(V1);
        distV2 = Di(V2);

        System.out.println(calcResult(dist,distV1,distV2));
    }

    public static int[] Di(int start){
        int[] result = new int[N+1];
        Arrays.fill(result, MAX_VAL);

        boolean[] visited = new boolean[N + 1];
        Arrays.fill(visited, false);

        PriorityQueue<Node> pq = new PriorityQueue<>();
        result[start] = 0;
        pq.add(new Node(start, 0));

        while (!pq.isEmpty()) {
            int index = pq.poll().index;

            if(visited[index]){
                continue;
            }
            visited[index] = true;

            for (Node next : graph.get(index)) {
                if(result[next.index] > result[index] + next.dist){
                    result[next.index] = result[index] + next.dist;
                    pq.add(new Node(next.index, 0));
                }
            }
        }
        return result;
    }

    public static int calcResult(int[] d1, int[] d2, int[] d3){
        //v1 v2 N
        int case1 = d2[1] + d3[V1] + d1[V2];
        //v2 v1 N
        int case2 =  d3[1] + d2[V2] + d1[V1];
        //N v1 v2 N
        int case3 = d1[1] + d2[N] + d3[V1] + d1[V2];
        //N v2 v1 N
        int case4 = d1[1] + d3[N] + d2[V2] + d1[V1];
        //N v1 N v2 N
        int case5 = d1[1] + d2[N] + d1[V1] + d3[N] + d1[V2];
        //N v2 N v1 N
        int case6 = d1[1] + d3[N] + d1[V2] + d2[N] + d1[V1];

        if(
                case1 >= MAX_VAL && case2 >= MAX_VAL
                && case3 >= MAX_VAL && case4 >= MAX_VAL
                && case5 >= MAX_VAL && case6 >= MAX_VAL
        ){
            return -1;
        }
        return Math.min( Math.min( Math.min(case1, case2), Math.min(case3,case4) ), Math.min(case5,case6) );
    }
}
