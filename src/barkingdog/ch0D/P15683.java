package barkingdog.ch0D;

import javax.imageio.IIOException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class P15683 {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static int N,M;
    public static int[][] originBoard;
    public static ArrayList<Integer[]> camList = new ArrayList<>();
    public static int ans = 100;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        originBoard = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                int val = Integer.parseInt(st.nextToken());
                originBoard[i][j] = val;
                if(val > 0 && val < 6){
                    camList.add(new Integer[]{i, j});
                }
            }
        }

        run(0, new int[N][M]);
        System.out.println(ans);
    }

    public static void run(int level, int[][] camDir) {
        if (level >= camList.size()) {
            calc(camDir);
            return;
        }
        for (int i = 1; i <= 4; i++) {
            Integer[] camNow = camList.get(level);
            camDir[camNow[0]][camNow[1]] = i;
            run(level + 1, camDir);
        }
    }

    public static void calc(int[][] camDir) {
        int[][] board = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                board[i][j] = originBoard[i][j];
            }
        }

        for (Integer[] camNow : camList) {
            int camType = board[camNow[0]][camNow[1]];
            int dir = camDir[camNow[0]][camNow[1]];
            int r = camNow[0];
            int c = camNow[1];
            if(camType == 1){
                int[] dr = {0, 0, 1, 0, -1};
                int[] dc = {0, 1, 0, -1, 0};
                int p = 1;
                while(true){
                    int nr = r + dr[dir] * p;
                    int nc = c + dc[dir] * p;
                    if(nr < 0 || nr >= N || nc < 0 || nc >= M || board[nr][nc] == 6) break;
                    if(board[nr][nc] == 0) board[nr][nc] = -1;
                    p++;
                }
            } else if (camType == 2) {
                int[] dr = {0, 0, 1, 0, -1};
                int[] dc = {0, 1, 0, -1, 0};
                int p = 1;
                while(true){
                    int nr = r + dr[dir] * p;
                    int nc = c + dc[dir] * p;
                    if(nr < 0 || nr >= N || nc < 0 || nc >= M || board[nr][nc] == 6) break;
                    if(board[nr][nc] == 0) board[nr][nc] = -1;
                    p++;
                }
                p = 1;
                while(true){
                    int nr = r - dr[dir] * p;
                    int nc = c - dc[dir] * p;
                    if(nr < 0 || nr >= N || nc < 0 || nc >= M || board[nr][nc] == 6) break;
                    if(board[nr][nc] == 0) board[nr][nc] = -1;
                    p++;
                }
            } else if (camType == 3) {
                int[] dr = {0, 0, 1, 0, -1};
                int[] dc = {0, 1, 0, -1, 0};
                int p = 1;
                while(true){
                    int nr = r + dr[dir] * p;
                    int nc = c + dc[dir] * p;
                    if(nr < 0 || nr >= N || nc < 0 || nc >= M || board[nr][nc] == 6) break;
                    if(board[nr][nc] == 0) board[nr][nc] = -1;
                    p++;
                }
                p = 1;
                int[] dr2 = {0, -1, 0, 1, 0};
                int[] dc2 = {0, 0, 1, 0, -1};
                while(true){
                    int nr = r + dr2[dir] * p;
                    int nc = c + dc2[dir] * p;
                    if(nr < 0 || nr >= N || nc < 0 || nc >= M || board[nr][nc] == 6) break;
                    if(board[nr][nc] == 0) board[nr][nc] = -1;
                    p++;
                }
            } else if (camType == 4) {
                int[] dr = {0, 0, 1, 0, -1};
                int[] dc = {0, 1, 0, -1, 0};
                int p = 1;
                while(true){
                    int nr = r + dr[dir] * p;
                    int nc = c + dc[dir] * p;
                    if(nr < 0 || nr >= N || nc < 0 || nc >= M || board[nr][nc] == 6) break;
                    if(board[nr][nc] == 0) board[nr][nc] = -1;
                    p++;
                }
                p = 1;
                while(true){
                    int nr = r - dr[dir] * p;
                    int nc = c - dc[dir] * p;
                    if(nr < 0 || nr >= N || nc < 0 || nc >= M || board[nr][nc] == 6) break;
                    if(board[nr][nc] == 0) board[nr][nc] = -1;
                    p++;
                }
                p = 1;
                int[] dr2 = {0, -1, 0, 1, 0};
                int[] dc2 = {0, 0, 1, 0, -1};
                while(true){
                    int nr = r + dr2[dir] * p;
                    int nc = c + dc2[dir] * p;
                    if(nr < 0 || nr >= N || nc < 0 || nc >= M || board[nr][nc] == 6) break;
                    if(board[nr][nc] == 0) board[nr][nc] = -1;
                    p++;
                }
            } else if (camType == 5) {
                int[] dr = {0, 0, 1, 0, -1};
                int[] dc = {0, 1, 0, -1, 0};
                int p = 1;
                while(true){
                    int nr = r + dr[dir] * p;
                    int nc = c + dc[dir] * p;
                    if(nr < 0 || nr >= N || nc < 0 || nc >= M || board[nr][nc] == 6) break;
                    if(board[nr][nc] == 0) board[nr][nc] = -1;
                    p++;
                }
                p = 1;
                while(true){
                    int nr = r - dr[dir] * p;
                    int nc = c - dc[dir] * p;
                    if(nr < 0 || nr >= N || nc < 0 || nc >= M || board[nr][nc] == 6) break;
                    if(board[nr][nc] == 0) board[nr][nc] = -1;
                    p++;
                }
                p = 1;
                int[] dr2 = {0, -1, 0, 1, 0};
                int[] dc2 = {0, 0, 1, 0, -1};
                while(true){
                    int nr = r + dr2[dir] * p;
                    int nc = c + dc2[dir] * p;
                    if(nr < 0 || nr >= N || nc < 0 || nc >= M || board[nr][nc] == 6) break;
                    if(board[nr][nc] == 0) board[nr][nc] = -1;
                    p++;
                }
                p = 1;
                while(true){
                    int nr = r - dr2[dir] * p;
                    int nc = c - dc2[dir] * p;
                    if(nr < 0 || nr >= N || nc < 0 || nc >= M || board[nr][nc] == 6) break;
                    if(board[nr][nc] == 0) board[nr][nc] = -1;
                    p++;
                }
            }
        }

        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(board[i][j] == 0) count++;
            }
        }

        ans = Math.min(ans, count);
    }
}
