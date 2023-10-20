package barkingdog.ch10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P2193 {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        int[][] DP = new int[100][2];
        DP[0][0] = 0;
        DP[0][1] = 1;
        for (int i = 1; i < N; i++) {
            DP[i][0] = DP[i - 1][0] + DP[i - 1][1];
            DP[i][1] = DP[i - 1][0];
        }
        System.out.println(DP[N-1][0] + DP[N-1][1]);
    }
}
