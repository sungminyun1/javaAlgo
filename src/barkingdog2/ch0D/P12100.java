package barkingdog2.ch0D;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P12100 {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static int N, ans = 0;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        int[][] board = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        solve(board, 0);

        System.out.println(ans);
    }

    public static void solve(int[][] board, int count){
        if(count == 5){
            for(int i = 0; i < N; i++){
                for(int j = 0; j < N; j++){
                    ans = Math.max(ans, board[i][j]);
                }
            }
            return;
        }
        solve(up(board), count + 1);
        solve(down(board), count + 1);
        solve(left(board), count + 1);
        solve(right(board), count + 1);
    }

    public static int[][] up(int[][] board) {
        int[][] newBoard = new int[N][N];
        boolean[][] check = new boolean[N][N];
        for(int i =0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(board[i][j] == 0) continue;
                if(i == 0){
                    newBoard[i][j] = board[i][j];
                    continue;
                }
                int now = board[i][j];
                int ni = i;
                while(ni > 0){
                    if(newBoard[ni-1][j] == 0){
                        ni--;
                    }else if(newBoard[ni-1][j] == now && !check[ni-1][j]){
                        now += now;
                        check[ni-1][j] = true;
                        ni--;
                        break;
                    }else{
                        break;
                    }
                }
                newBoard[ni][j] = now;
            }
        }
        return newBoard;
    }

    public static int[][] down(int[][] board) {
        int[][] newBoard = new int[N][N];
        boolean[][] check = new boolean[N][N];
        for(int i = N-1; i>=0 ; i--) {
            for(int j = 0; j < N; j++) {
                if(board[i][j] == 0) continue;
                if(i == N-1){
                    newBoard[i][j] = board[i][j];
                    continue;
                }
                int now = board[i][j];
                int ni = i;
                while(ni < N -1){
                    if(newBoard[ni + 1][j] == 0){
                        ni++;
                    }else if(newBoard[ni+1][j] == now && !check[ni+1][j]){
                        now += now;
                        check[ni+1][j] = true;
                        ni++;
                        break;
                    }else{
                        break;
                    }
                }
                newBoard[ni][j] = now;
            }
        }
        return newBoard;
    }

    public static int[][] left(int[][] board) {
        int[][] newBoard = new int[N][N];
        boolean[][] check = new boolean[N][N];
        for (int j = 0; j < N; j++) {
            for (int i =0; i<N; i++) {
                if(board[i][j] == 0) continue;
                if(j == 0){
                    newBoard[i][j] = board[i][j];
                    continue;
                }
                int now = board[i][j];
                int nj = j;
                while (nj > 0) {
                    if (newBoard[i][nj -1 ] == 0) {
                        nj--;
                    } else if (newBoard[i][nj -1 ] == now && !check[i][nj -1]) {
                        now += now;
                        check[i][nj -1] = true;
                        nj--;
                        break;
                    } else {
                        break;
                    }
                }
                newBoard[i][nj] = now;
            }
        }
        return newBoard;
    }

    public static int[][] right(int[][] board) {
        int[][] newBoard = new int[N][N];
        boolean[][] check = new boolean[N][N];
        for (int j = N - 1; j >= 0; j--) {
            for (int i =0; i<N; i++) {
                if(board[i][j] == 0) continue;
                if(j == N-1){
                    newBoard[i][j] = board[i][j];
                    continue;
                }
                int now = board[i][j];
                int nj = j ;
                while (nj < N -1) {
                    if (newBoard[i][nj + 1] == 0) {
                        nj++;
                    } else if (newBoard[i][nj + 1] == now && !check[i][nj + 1]) {
                        now += now;
                        check[i][nj + 1] = true;
                        nj++;
                        break;
                    } else {
                        break;
                    }
                }
                newBoard[i][nj] = now;
            }
        }
        return newBoard;
    }
}
