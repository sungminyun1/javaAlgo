package barkingdog2.ch10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class P1436 {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static int N;
    public static boolean[] visited;
    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        visited = new boolean[N+1];

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{1, 0});

        while(!q.isEmpty()) {
            int[] cur = q.poll();
            if(cur[0] == N) {
                System.out.println(cur[1]);
                return;
            }
            if(visited[cur[0]]) continue;
            visited[cur[0]] = true;

            int[] next = {cur[0] * 3, cur[0] * 2, cur[0] + 1};
            for (int nc : next) {
                if (nc < N + 1 && !visited[nc]) {
                    q.add(new int[]{nc, cur[1] + 1});
                }
            }

        }
    }
}
