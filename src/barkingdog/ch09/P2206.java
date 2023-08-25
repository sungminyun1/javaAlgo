package barkingdog.ch09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P2206 {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] board = new int[N][M];
        int[][] dist = new int[N][M];
        boolean[][][] visited = new boolean[N][M][2];

        if(N == 1 && M == 1){
            System.out.println(1);
            return;
        }

        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split("");
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(input[j]);
            }
        }

        Queue<Integer[]> nv = new LinkedList<>();
        nv.add(new Integer[]{0, 0, 0});
        visited[0][0][0] = true;
        dist[0][0] = 1;
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        while (!nv.isEmpty()) {
            Integer[] now = nv.poll();
            for (int i = 0; i < 4; i++) {
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];
                if(nx == N-1 && ny == M-1){
                    System.out.println(dist[now[0]][now[1]] + 1);
                    return;
                }
                if(nx < 0 || nx >= N || ny < 0 || ny >= M ) continue;
                if(board[nx][ny] == 1){
                    if(now[2] == 0 && !visited[nx][ny][1]){
                        dist[nx][ny] = dist[now[0]][now[1]] + 1;
                        visited[nx][ny][now[2]] = true;
                        nv.add(new Integer[]{nx, ny, 1});
                    }
                }else if(!visited[nx][ny][now[2]]){
                    visited[nx][ny][now[2]] = true;
                    dist[nx][ny] = dist[now[0]][now[1]] + 1;
                    nv.add(new Integer[]{nx, ny, now[2]});
                }
            }
        }
        System.out.println(-1);
    }
}
