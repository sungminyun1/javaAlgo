package barkingdog2.ch1B;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class P1197 {
    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static int N,M, SELECTED_EDGE = 0, RESULT = 0;
    public static int[] parent;
    public static ArrayList<Integer[]> edges;
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        edges = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());
            edges.add(new Integer[]{from, to, value});
        }
        edges.sort((o1, o2) -> o1[2] - o2[2]);

        parent = new int[N + 1];
        for(int i = 1; i <= N; i++) {
            parent[i] = i;
        }

        for(Integer[] edge : edges) {
            if(SELECTED_EDGE == N - 1) break;

            int node1 = edge[0];
            int node2 = edge[1];
            int value = edge[2];

            if(!isSameGroup(node1, node2)) {
                SELECTED_EDGE++;
                RESULT += value;
            }
        }

        System.out.println(RESULT);
    }

    public static boolean isSameGroup(int node1, int node2) {
        int p1 = findParent(node1);
        int p2 = findParent(node2);
        if(p1 == p2) return true;
        if(p1 < p2){
            parent[p2] = p1;
        }else{
            parent[p1] = p2;
        }
        return false;
    }

    public static int findParent(int node) {
        if(parent[node] == node) return node;
        return findParent(parent[node]);
    }
}
