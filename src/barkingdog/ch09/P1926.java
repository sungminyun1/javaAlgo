package barkingdog.ch09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P1926 {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static int N,M;
    public static int[][] board;
    public static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new int[N][M];
        visited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                int val = Integer.parseInt(st.nextToken());
                board[i][j] = val;
            }
        }


        int count = 0;
        int size = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(board[i][j] == 1 && !visited[i][j]){
                    count++;
                    size = Math.max(solve(i, j), size);
                }
            }
        }
        System.out.println(count);
        System.out.println(size);
    }

    public static int solve(int col, int row) {
        Queue<Integer[]> needVisit = new LinkedList<>();
        needVisit.add(new Integer[]{col, row});
        visited[col][row] = true;

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        int size = 1;

        while (!needVisit.isEmpty()) {
            Integer[] now = needVisit.poll();
            for (int i = 0; i < 4; i++) {
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];
                if(nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
                if (board[nx][ny] == 1 && !visited[nx][ny]) {
                    size++;
                    visited[nx][ny] = true;
                    needVisit.add(new Integer[]{nx, ny});
                }
            }
        }

        return size;
    }
}
