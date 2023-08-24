package barkingdog.ch09;

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
            String[] _st = br.readLine().split("");
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(_st[j]);
            }
        }
        Queue<Integer[]> needVisit = new LinkedList<>();
        board[0][0] = -1;
        needVisit.add(new Integer[]{0, 0});
        int ans = 1;
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        while (!needVisit.isEmpty()) {
            int nowSize = needVisit.size();
            for (int i = 0; i < nowSize; i++) {
                Integer[] now = needVisit.poll();
                for (int j = 0; j < 4; j++) {
                    int nx = now[0] + dx[j];
                    int ny = now[1] + dy[j];

                    if (nx == N - 1 && ny == M - 1) {
                        System.out.println(ans + 1);
                        return;
                    }

                    if (nx < 0 || ny < 0 || nx >= N || ny >= M) {
                        continue;
                    }
                    if (board[nx][ny] == 1){
                        needVisit.add(new Integer[]{nx, ny});
                        board[nx][ny] = -1;
                    }
                }
            }
            ans++;
        }
    }
}
