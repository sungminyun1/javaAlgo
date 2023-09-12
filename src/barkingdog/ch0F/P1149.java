package barkingdog.ch0F;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1149 {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        int[][] houses = new int[N][3];
        int[][] dp = new int[N][3];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                houses[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int R = 0, G = 1, B = 2;
        dp[0][R] = houses[0][R];
        dp[0][G] = houses[0][G];
        dp[0][B] = houses[0][B];

        for (int i = 1; i < N; i++) {
            dp[i][R] = Math.min(dp[i - 1][G], dp[i - 1][B]) + houses[i][R];
            dp[i][G] = Math.min(dp[i - 1][R], dp[i - 1][B]) + houses[i][G];
            dp[i][B] = Math.min(dp[i - 1][G], dp[i - 1][R]) + houses[i][B];
        }

        System.out.println(Math.min(Math.min(dp[N - 1][R], dp[N - 1][G]), dp[N - 1][B]));
    }
}
