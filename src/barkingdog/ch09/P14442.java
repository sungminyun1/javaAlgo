package barkingdog.ch09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P14442 {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static int N,M,K;
    public static int[][] Board;
    public static int[][][] Dist;
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        Board = new int[N][M];
        Dist = new int[N][M][K+1];
        for (int i = 0; i < N; i++) {
            String[] arr = br.readLine().split("");
            for (int j = 0; j < M; j++) {
                int val = Integer.parseInt(arr[j]);
                Board[i][j] = val;
            }
        }
        Queue<int[]> nv = new LinkedList<>();
        nv.add(new int[]{0, 0, 0});
        Dist[0][0][0] = 1;
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1,};

        while (!nv.isEmpty()) {
            int[] now = nv.poll();
            if(now[0] == N-1 && now[1] == M-1){
                System.out.println(Dist[now[0]][now[1]][now[2]]);
                return;
            }
            for (int i = 0; i < 4; i++) {
                int nr = now[0] + dx[i];
                int nc = now[1] + dy[i];
                if(nr < 0 || nr >= N || nc < 0 || nc >= M) continue;
                if(Board[nr][nc] == 0 && Dist[nr][nc][now[2]] == 0){
                    Dist[nr][nc][now[2]] = Dist[now[0]][now[1]][now[2]] + 1;
                    nv.add(new int[]{nr, nc, now[2]});
                }else if(Board[nr][nc] == 1 && now[2] < K && Dist[nr][nc][now[2]+1] == 0){
                    Dist[nr][nc][now[2]+1] = Dist[now[0]][now[1]][now[2]] + 1;
                    nv.add(new int[]{nr, nc, now[2]+1});
                }
            }
        }

        System.out.println(-1);
    }
}
