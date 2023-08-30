package barkingdog.ch09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P1600 {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int K,N,M;
    static int[][] board, dist;
    static boolean[][][] visited;
    static int[] hdx = {-2, -2, -1, -1, 1, 1, 2, 2};
    static int[] hdy = {-1, 1, -2, 2, -2, 2, -1, 1};
    static int[] dx = {0, 1, 0 ,-1};
    static int[] dy = {1, 0, -1, 0};
    public static void main(String[] args) throws IOException {
        K = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        board = new int[N][M];
        dist = new int[N][M];
        visited = new boolean[N][M][K+1];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        if(N == 1 && M == 1){
            System.out.println(0);
            return;
        }

        Queue<Integer[]> nv = new LinkedList<>();
        nv.add(new Integer[]{0, 0, 0, 0});
        visited[0][0][0] = true;
        while (!nv.isEmpty()) {
            Integer[] now = nv.poll();
            for (int i = 0; i < 4; i++) {
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];
                if(nx < 0 || nx >= N || ny < 0 || ny >= M || visited[nx][ny][now[2]] || board[nx][ny] == 1) continue;
                if(nx == N -1 && ny == M -1 ) {
                    System.out.println(now[3] +1);
                    return;
                }
                visited[nx][ny][now[2]] = true;
                nv.add(new Integer[]{nx, ny, now[2], now[3] + 1});
            }

            if(now[2] < K){
                for (int i = 0; i < 8; i++) {
                    int nx = now[0] + hdx[i];
                    int ny = now[1] + hdy[i];
                    if(nx < 0 || nx >= N || ny < 0 || ny >= M || visited[nx][ny][now[2] + 1] || board[nx][ny] == 1) continue;
                    if(nx == N -1 && ny == M -1 ) {
                        System.out.println(now[3] +1);
                        return;
                    }
                    visited[nx][ny][now[2] +1 ] = true;
                    nv.add(new Integer[]{nx, ny, now[2] + 1, now[3] + 1});
                }
            }

        }
        System.out.println(-1);
    }
}
