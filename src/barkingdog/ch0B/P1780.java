package barkingdog.ch0B;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1780 {
    public static int N;
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static int[][] board;
    public static int ansm = 0, ansz = 0, anso = 0;
    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        board = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        run(N, 0, 0);
        System.out.println(ansm);
        System.out.println(ansz);
        System.out.println(anso);
    }

    public static void run(int size, int r, int c) {
        if (size == 1 || check(size, r, c)) {
            if(board[r][c] == -1) ansm++;
            if(board[r][c] == 0) ansz++;
            if(board[r][c] == 1) anso++;
        } else{
            int ns = size / 3;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    run(ns, r + ns * i, c + ns * j);
                }
            }
        }
    }

    public static boolean check(int size, int r, int c) {
        int t = board[r][c];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if(board[r+i][c+j] != t) return false;
            }
        }

        return true;
    }
}
