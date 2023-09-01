package barkingdog.ch0C;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P9663 {
    public static int N;
    public static int[][] board;
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static int ans = 0;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        board = new int[N][N];
        run(0, 0, 0);
        System.out.println(ans);
    }

    public static void run(int level, int r, int c) {
        if (level == N) {
            ans++;
            return;
        }
        for (int i = r; i < N; i++) {
            for (int j = c; j < N; j++) {
                if(board[i][j] == 0 && check(i,j)){
                    board[i][j] = 1;
                    run(level + 1, i +1, j + 1);
                    board[i][j] = 0;
                }
            }
        }
    }

    public static boolean check(int r, int c) {
        int[] dx = {-1, 1, 0, 0, -1, -1, 1, 1};
        int[] dy = {0, 0, -1, 1, -1, 1, -1, 1,};
        for (int i = 0; i < N; i++) {
            for (int k = 0; k < 8; k++) {
                int nx = r + dx[k] * i;
                int ny = c + dy[k] * i;
                if(nx <0 || nx >= N || ny < 0 || ny >= N || board[nx][ny] == 0) continue;
                return false;
            }
        }
        return true;
    }
}
