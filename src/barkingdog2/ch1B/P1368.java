package barkingdog2.ch1B;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P1368 {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static int N, RESULT = 0, selected = 0;
    public static int[] parent;
    public static ArrayList<Integer[]> edges = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        parent = new int[N + 1];

        for(int i = 1; i <= N; i++) {
            edges.add(new Integer[]{0, i, Integer.parseInt(br.readLine())});
            parent[i] = i;
        }
        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= N; j++) {
                int val = Integer.parseInt(st.nextToken());
                if(i >= j) continue;
                edges.add(new Integer[]{i, j, val});
            }
        }
        edges.sort((a, b) -> a[2] - b[2]);

        for(Integer[] edge : edges) {
            if(selected == N) break;

            int n1 = edge[0], n2 = edge[1], val = edge[2];

            if (isSameGroup(n1, n2)) continue;
            selected++;
            RESULT += val;
        }

        System.out.println(RESULT);
    }

    public static boolean isSameGroup(int a, int b) {
        int pa = findParent(a);
        int pb = findParent(b);
        if(pa == pb) return true;
        if(pa < pb) parent[pb] = pa;
        else parent[pa] = pb;
        return false;
    }

    public static int findParent(int a) {
        if(parent[a] == a) return a;
        return findParent(parent[a]);
    }

}
