package barkingdog.ch10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1932 {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static int N;
    public static int[][] Board, DP;
    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        Board = new int[N][N];
        DP = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < i + 1; j++) {
                Board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        DP[0][0] = Board[0][0];
        for (int i = 1; i < N; i++) {
            for (int j = 0; j < i + 1; j++) {
                int pdp1 = j == 0 ? 0 : DP[i - 1][j - 1];
                int pdp2 = DP[i - 1][j];
                DP[i][j] = Math.max(pdp1, pdp2) + Board[i][j];
            }
        }
        int ans = 0;
        for (int i = 0; i < N; i++) {
            if(DP[N-1][i] > ans) ans = DP[N - 1][i];
        }
        System.out.println(ans);
    }
}
