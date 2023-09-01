package barkingdog.ch0B;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P1992 {
    public static int N;
    public static int[][] board;
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        board = new int[N][N];
        for (int i = 0; i < N; i++) {
            String st = br.readLine();
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt("" + st.charAt(j));
            }
        }
        run(N, 0, 0);
        System.out.println(sb);
    }

    public static void run(int size, int r, int c) {
        if (size == 1 || check(size, r, c)) {
            sb.append(board[r][c]);
        }else{
            int ns = size / 2;
            sb.append("(");
            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < 2; j++) {
                    run(ns, r + ns * i, c + ns * j);
                }
            }
            sb.append(")");
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
