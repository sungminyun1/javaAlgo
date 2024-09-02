package barkingdog2.ch09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P7576 {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int W = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());
        int[][] board = new int[H][W];
        Queue<Integer[]> queue = new LinkedList<>();
        for(int i = 0; i < H; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < W; j++) {
                int t = Integer.parseInt(st.nextToken());
                board[i][j] = t;
                if(t == 1) {
                    queue.add(new Integer[]{i, j, 0});
                }
            }
        }
        boolean[][] visited = new boolean[H][W];
        int answer = 0;

        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, -1, 0, 1};

        while(!queue.isEmpty()) {
            Integer[] cur = queue.poll();
            if(visited[cur[0]][cur[1]]) continue;

            visited[cur[0]][cur[1]] = true;
            board[cur[0]][cur[1]] = 1;
            answer = cur[2];

            for(int k = 0; k < 4; k++) {
                int nx = cur[0] + dx[k];
                int ny = cur[1] + dy[k];
                if(nx <0 || ny <0 || nx >= H || ny >= W || board[nx][ny] != 0 || visited[nx][ny]) continue;
                queue.add(new Integer[]{nx, ny, cur[2] + 1});
            }
        }

        for(int i = 0; i < H; i++) {
            for(int j = 0; j < W; j++) {
                if(board[i][j] == 0) {
                    System.out.println(-1);
                    return;
                }
            }
        }

        System.out.println(answer);
    }
}
