package barkingdog.ch09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P7569 {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());

        int[][][] boards = new int[N][M][H];
        int[][][] dist = new int[N][M][H];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                for (int k = 0; k < H; k++) {
                    dist[i][j][k] = -1;
                }
            }
        }
        Queue<Integer[]> nv = new LinkedList<>();
        for (int h = 0; h < H; h++) {
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < M; j++) {
                    int val = Integer.parseInt(st.nextToken());
                    boards[i][j][h] = val;

                    if(val == 1){
                        dist[i][j][h] = 0;
                        nv.add(new Integer[]{i, j, h});
                    }
                }
            }
        }


        int[] dx = {-1, 1, 0, 0, 0, 0};
        int[] dy = {0, 0, -1, 1, 0, 0};
        int[] dh = {0, 0, 0, 0, 1, -1};

        while (!nv.isEmpty()) {
            Integer[] now = nv.poll();

            for (int i = 0; i < 6; i++) {
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];
                int nh = now[2] + dh[i];
                if(nx < 0 || nx >= N || ny < 0 || ny >= M || nh < 0 || nh >= H || dist[nx][ny][nh] >= 0 || boards[nx][ny][nh] == -1) continue;
                nv.add(new Integer[]{nx, ny, nh});
                dist[nx][ny][nh] = dist[now[0]][now[1]][now[2]] + 1;
                boards[nx][ny][nh] = 1;
            }
        }
        int res = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                for (int k = 0; k < H; k++) {
                    if(boards[i][j][k] == 0) {
                        System.out.println(-1);
                        return;
                    }
                    res = Math.max(res, dist[i][j][k]);
                }
            }
        }

        System.out.println(res);
    }
}
