package barkingdog.ch09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P2146 {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static int N;
    public static int[][] board;
    public static int[][][] dist;
    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        board = new int[N][N];
        dist = new int[N][N][2];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        int token = 2;
        Queue<Integer[]> nv = new LinkedList<>();
        Queue<Integer[]> nv2 = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(board[i][j] == 1){
                    nv.add(new Integer[]{i, j});
                    board[i][j] = token;

                    while (!nv.isEmpty()) {
                        Integer[] now = nv.poll();
                        for (int k = 0; k < 4; k++) {
                            int nx = now[0] + dx[k];
                            int ny = now[1] + dy[k];
                            if(nx <0 || nx >=N || ny<0 || ny>= N ) continue;
                            if(board[nx][ny] == 1){
                                board[nx][ny] = token;
                                nv.add(new Integer[]{nx, ny});
                            }else if(board[nx][ny] == 0 && dist[nx][ny][0] == 0){
                                dist[nx][ny][0] = 1;
                                dist[nx][ny][1] = token;
                                nv2.add(new Integer[]{nx, ny, token});
                            }
                        }
                    }
                    token++;
                }
            }
        }
        while (!nv2.isEmpty()) {
            Integer[] now = nv2.poll();
            for (int i = 0; i < 4; i++) {
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];
                if(nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
                if(dist[nx][ny][0] == 0 && board[nx][ny] > 1){
                    dist[nx][ny][0] = dist[now[0]][now[1]][0] +1;
                    dist[nx][ny][1] = now[2];
                    nv2.add(new Integer[]{nx, ny, now[2]});
                }else if(dist[nx][ny][0] > 0 && dist[nx][ny][1] != now[2]){
                    System.out.println(dist[nx][ny][0] + dist[now[0]][now[1]][0]);
                    return;
                }
            }
        }
    }
}
