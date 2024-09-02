package barkingdog2.ch09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P2178 {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] board = new int[N][M];

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(s.charAt(j) + "");
            }
        }

        boolean[][] visited = new boolean[N][M];
        Queue<Integer[]> q = new LinkedList<>();
        q.add(new Integer[]{0, 0, 1});

        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, -1, 0, 1};

        while (!q.isEmpty()) {
            Integer[] cur = q.poll();
            if(visited[cur[0]][cur[1]]) continue;

            if(cur[0] == N - 1 && cur[1] == M - 1){
                System.out.println(cur[2]);
                return;
            }

            visited[cur[0]][cur[1]] = true;

            for(int i = 0; i < dx.length; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];
                if(nx < 0 || ny < 0 || nx >= N || ny >= M || board[nx][ny] == 0 || visited[nx][ny]) continue;
                q.add(new Integer[]{nx, ny, cur[2] + 1});
            }
        }
    }
}
