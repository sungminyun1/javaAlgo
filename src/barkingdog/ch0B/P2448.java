package barkingdog.ch0B;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P2448 {
    public static int N;
    public static int[][] board;
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        board = new int[N][2 * N - 1];
        run(N, 0, 0);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if(board[i][j] == 0){
                    sb.append(" ");
                }else{
                    sb.append("*");
                }
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    public static void run(int size, int r, int c) {
        if(size == 3){
            board[r][c+2] = 1;
            board[r+1][c+1] = 1;
            board[r+1][c+3] = 1;
            board[r+2][c] = 1;
            board[r+2][c+1] = 1;
            board[r+2][c+2] = 1;
            board[r+2][c+3] = 1;
            board[r+2][c+4] = 1;
        } else {
            int ns = size / 2;
            run(ns, r, c + ns);
            run(ns, r + ns, c);
            run(ns, r + ns, c + ns + ns);
        }
    }
}
