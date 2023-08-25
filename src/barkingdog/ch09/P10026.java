package barkingdog.ch09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class P10026 {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        char[][] board = new char[N][N];
        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < N; j++) {
                board[i][j] = input.charAt(j);
            }
        }
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        boolean[][] visited = new boolean[N][N];
        Queue<Integer[]> nv = new LinkedList<>();
        int res = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    visited[i][j] = true;
                    nv.add(new Integer[]{i, j});
                    res++;
                    while (!nv.isEmpty()) {
                        Integer[] now = nv.poll();
                        for (int k = 0; k < 4; k++) {
                            int nx = now[0] + dx[k];
                            int ny = now[1] + dy[k];
                            if(nx < 0 || nx >= N || ny < 0 || ny >= N || visited[nx][ny]) continue;
                            if (board[nx][ny] == board[now[0]][now[1]]) {
                                visited[nx][ny] = true;
                                nv.add(new Integer[]{nx, ny});
                            }
                        }
                    }
                }
            }
        }
        sb.append(res);
        sb.append(" ");

        visited = new boolean[N][N];
        nv = new LinkedList<>();
        res = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    visited[i][j] = true;
                    nv.add(new Integer[]{i, j});
                    res++;
                    while (!nv.isEmpty()) {
                        Integer[] now = nv.poll();
                        for (int k = 0; k < 4; k++) {
                            int nx = now[0] + dx[k];
                            int ny = now[1] + dy[k];
                            if(nx < 0 || nx >= N || ny < 0 || ny >= N || visited[nx][ny]) continue;
                            if (board[now[0]][now[1]] == 'B') {
                                if(board[nx][ny] == 'B'){
                                    visited[nx][ny] = true;
                                    nv.add(new Integer[]{nx, ny});
                                }
                            }else{
                                if(board[nx][ny] != 'B'){
                                    visited[nx][ny] = true;
                                    nv.add(new Integer[]{nx, ny});
                                }
                            }
                        }
                    }
                }
            }
        }
        sb.append(res);
        System.out.println(sb);
    }
}
