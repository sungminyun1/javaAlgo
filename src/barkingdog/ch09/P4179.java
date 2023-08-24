package barkingdog.ch09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P4179 {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        char[][] board = new char[N][M];
        Queue<Integer[]> pnv = new LinkedList<>();
        Queue<Integer[]> fnv = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < input.length(); j++) {
                char now = input.charAt(j);
                board[i][j] = now;
                if(now == 'J'){
                    pnv.add(new Integer[]{i, j});
                } else if (now == 'F') {
                    fnv.add(new Integer[]{i, j});
                }
            }
        }

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        int time = 0;
        while (!pnv.isEmpty()) {
            int ps = pnv.size();
            for (int i = 0; i < ps; i++) {
                Integer[] now = pnv.poll();
                if(board[now[0]][now[1]] == 'F') continue;
                if (now[0] == 0 || now[0] == N - 1 || now[1] == 0 || now[1] == M - 1) {
                    System.out.println(time +1);
                    return;
                }
                for (int j = 0; j < 4; j++) {
                    int nx = now[0] + dx[j];
                    int ny = now[1] + dy[j];

                    if (board[nx][ny] == '.') {
                        board[nx][ny] = 'J';
                        pnv.add(new Integer[]{nx, ny});
                    }
                }
            }

            int fs = fnv.size();
            for (int i = 0; i < fs; i++) {
                Integer[] now = fnv.poll();
                for (int j = 0; j < 4; j++) {
                    int nx = now[0] + dx[j];
                    int ny = now[1] + dy[j];
                    if(nx < 0 || nx >= N || ny <0 || ny >= M) continue;
                    if (board[nx][ny] == '.' ||board[nx][ny] == 'J') {
                        board[nx][ny] = 'F';
                        fnv.add(new Integer[]{nx, ny});
                    }
                }
            }

            time++;
        }
        System.out.println("IMPOSSIBLE");
    }
}
