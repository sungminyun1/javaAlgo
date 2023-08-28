package barkingdog.ch09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P2573 {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static int N,M;
    public static int[][] board;
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        int age = 0;
        while (true) {
            age++;
            int ices = 0;
            int[][] minuses = new int[N][M];
            for (int i = 1; i < N - 1; i++) {
                for (int j = 1; j < M - 1; j++) {
                    if (board[i][j] > 0) {
                        int minus = 0;
                        for (int k = 0; k < 4; k++) {
                            int nx = i + dx[k];
                            int ny = j + dy[k];
                            if(board[nx][ny] == 0) minus++;
                        }
                        minuses[i][j] = minus;
                    }
                }
            }

            for (int i = 1; i < N - 1; i++) {
                for (int j = 1; j < M - 1; j++) {
                    board[i][j] = Math.max(0, board[i][j] - minuses[i][j]);
                    if(board[i][j] > 0) ices++;
                }
            }

            if(ices <= 1) {
                System.out.println(0);
                return;
            }

            boolean[][] visited = new boolean[N][M];
            Queue<Integer[]> nv = new LinkedList<>();
            boolean flag = false;
            for (int i = 1; i < N - 1; i++) {
                for (int j = 1; j < M - 1; j++) {
                    if(board[i][j] > 0 && !visited[i][j]){
                        if(flag){
                            System.out.println(age);
                            return;
                        }
                        flag = true;
                        visited[i][j] = true;
                        nv.add(new Integer[]{i, j});

                        while (!nv.isEmpty()) {
                            Integer[] now = nv.poll();
                            for (int k = 0; k < 4; k++) {
                                int nx = now[0] + dx[k];
                                int ny = now[1] + dy[k];
                                if (!visited[nx][ny] && board[nx][ny] > 0) {
                                    visited[nx][ny] = true;
                                    nv.add(new Integer[]{nx, ny});
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
