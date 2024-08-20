package barkingdog2.ch0D;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class P18808 {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static boolean[][] board;
    public static int N,M,K, ans = 0;
    public static List<Sticker> stickers = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        board = new boolean[N][M];
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int height = Integer.parseInt(st.nextToken());
            int width = Integer.parseInt(st.nextToken());
            int[][] sticker = new int[height][width];
            for(int y = 0; y < height; y++) {
                st = new StringTokenizer(br.readLine());
                for(int x = 0; x < width; x++) {
                    sticker[y][x] = Integer.parseInt(st.nextToken());
                }
            }
            stickers.add(new Sticker(width, height, sticker));
        }

        for(Sticker sticker : stickers) {
            sticker.go();
        }

        System.out.println(ans);
    }

    public static class Sticker{
        int width, height;
        int[][] sticker;
        int rotateCount = 0;

        public Sticker(int width, int height, int[][] sticker) {
            this.width = width;
            this.height = height;
            this.sticker = sticker;
        }

        public void go() {
            if(rotateCount > 3) return;

            for (int r = 0; r <= N - height; r++) {
                for(int c = 0; c <= M - width; c++) {
                    if(check(r,c)){
                        paste(r,c);
                        return;
                    }
                }
            }
            rotateCount++;
            rotate();
            go();
        }

        public boolean check(int r, int c) {
            for (int i = 0; i < height; i++) {
                for(int j = 0; j < width; j++) {
                    if(sticker[i][j] == 1 && board[r+i][c+j]) return false;
                }
            }

            return true;
        }

        public void paste(int r, int c) {
            for (int i = 0; i < height; i++) {
                for(int j = 0; j < width; j++) {
                    if(sticker[i][j] == 1){
                        board[r+i][c+j] = true;
                        ans++;
                    }
                }
            }
        }

        public void rotate() {
            int[][] rotated = new int[width][height];

            for (int i = 0; i < height; i++) {
                for(int j = 0; j < width; j++) {
                    rotated[j][height - 1 - i] =sticker[i][j];
                }
            }
            sticker = rotated;
            height = rotated.length;
            width = rotated[0].length;
        }
    }
}
