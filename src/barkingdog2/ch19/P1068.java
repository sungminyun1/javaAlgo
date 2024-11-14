package barkingdog2.ch19;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class P1068 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int N, M, ANS;
    private static List<List<Integer>> graph = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < N; i++) {
            int now = Integer.parseInt(st.nextToken());
            if(now == -1) continue;

            graph.get(now).add(i);
        }
        M = Integer.parseInt(br.readLine());

        travel(0);

        System.out.println(ANS);

    }

    public static void travel(int node) {
        if(node == M) return;
        List<Integer> children = graph.get(node);
        if(children.isEmpty()) ANS++;

        for(Integer child : children) {
            travel(child);
        }
    }
}
