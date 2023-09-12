package barkingdog.ch10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P2579 {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N + 1];
        int[][] dp = new int[N + 1][3];

        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        if(N == 1){
            System.out.println(arr[1]);
            return;
        }
        if(N == 2){
            System.out.println(arr[1] + arr[2]);
            return;
        }

        dp[1][1] = arr[1];
        dp[2][1] = arr[2];
        dp[2][2] = arr[1] + arr[2];
        for (int i = 3; i < N + 1; i++) {
            dp[i][1] = Math.max(dp[i-2][2], dp[i-2][1]) + arr[i];
            dp[i][2] = dp[i-1][1] + arr[i];
        }
        System.out.println(Math.max(dp[N][1],dp[N][2]));
    }
}
