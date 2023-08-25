package barkingdog.ch09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P1012 {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            int[][] board = new int[N][M];
            for (int j = 0; j < K; j++) {
                st = new StringTokenizer(br.readLine());
                int r = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                board[r][c] = 1;
            }
            int res = solve(board,N,M);
            sb.append(res);
            sb.append("\n");
        }

        System.out.println(sb);
    }

    public static int solve(int[][] board, int N, int M) {
        Queue<Integer[]> nv = new LinkedList<>();
        int res = 0;
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (board[i][j] == 1) {
                    nv.add(new Integer[]{i, j});
                    res++;
                    board[i][j] = -1;

                    while (!nv.isEmpty()) {
                        Integer[] now = nv.poll();

                        for (int k = 0; k < 4; k++) {
                            int nx = now[0] + dx[k];
                            int ny = now[1] + dy[k];

                            if(nx < 0 || nx >= N || ny< 0 || ny >= M || board[nx][ny] != 1) continue;
                            board[nx][ny] = -1;
                            nv.add(new Integer[]{nx, ny});
                        }
                    }
                }
            }
        }

        return res;
    }
}
