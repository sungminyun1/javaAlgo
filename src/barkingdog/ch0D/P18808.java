package barkingdog.ch0D;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class P18808 {
    public static int N,M,K;
    public static int[][] board;
    public static int[][][] stickers;
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        board = new int[N][M];
        stickers = new int[K][][];
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            stickers[i] = new int[n][m];
            for (int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < m; k++) {
                    stickers[i][j][k] = Integer.parseInt(st.nextToken());
                }
            }
        }

        for (int i = 0; i < K; i++) {
            int[][] sticker = stickers[i];
            paste(sticker);
        }
        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(board[i][j] == 1) count++;
            }
        }

        System.out.println(count);
    }

    public static void paste(int[][] sticker) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(check(sticker, i, j)) return;
            }
        }
    }

    public static boolean check(int[][] sticker, int r, int c) {
        for (int d = 0; d < 4; d++) {
            if(d > 0) sticker = rotate(sticker);
            boolean avail = true;
            for (int i = 0; i < sticker.length; i++) {
                if(!avail) break;
                for (int j = 0; j < sticker[0].length; j++) {
                    if(sticker[i][j] == 1 && (r+i >= N || c+j >= M || board[r+i][c+j] != 0)){
                        avail = false;
                        break;
                    }
                }
            }
            if (avail) {
                for (int i = 0; i < sticker.length; i++) {
                    for (int j = 0; j < sticker[0].length; j++) {
                        if (sticker[i][j] == 1) {
                            board[r + i][c + j] = sticker[i][j];
                        }
                    }
                }
                return true;
            }
        }
        return false;
    }

    public static int[][] rotate(int[][] sticker) {
        int n = sticker.length;
        int m = sticker[0].length;
        int[][] ts = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int or = n - 1 - j;
                int oc = i;
                ts[i][j] = sticker[or][oc];
            }
        }
        return ts;
    }
}
