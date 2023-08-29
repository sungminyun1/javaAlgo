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
    public static int[] dx = {-1, 1, 0, 0};
    public static int[] dy = {0, 0, -1, 1};
    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        board = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        int token = 2;
        Queue<Integer[]> nv = new LinkedList<>();
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
                            }
                        }
                    }
                    token++;
                }
            }
        }

        int res = 100000;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(board[i][j] > 1 && needCheck(i, j)){
                    int t = run(i, j);
                    res = Math.min(res, t);
                }
            }
        }

        System.out.println(res);
    }

    public static boolean needCheck(int i, int j){
        for (int k = 0; k < 4; k++) {
            int nx = i + dx[k];
            int ny = j + dy[k];
            if(nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
            if(board[nx][ny] == 0) return true;
        }
        return false;
    }

    public static int run(int row, int col){
        int token = board[row][col];
        Queue<Integer[]> nv = new LinkedList<>();
        int[][] dist = new int[N][N];

        dist[row][col] = 1;
        nv.add(new Integer[]{row, col});

        while (!nv.isEmpty()) {
            Integer[] now = nv.poll();
            for (int i = 0; i < 4; i++) {
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];
                if(nx < 0 || nx >= N || ny < 0 || ny >= N || dist[nx][ny] > 0) continue;
                if (board[nx][ny] > 0 && board[nx][ny] != token) {
                    return dist[now[0]][now[1]] -1;
                } else if(board[nx][ny] == 0 && dist[nx][ny] == 0){
                    dist[nx][ny] = dist[now[0]][now[1]] +1;
                    nv.add(new Integer[]{nx, ny});
                }
            }
        }

        return 100000;
    }
}
