package barkingdog.ch10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P9095 {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
            run(N);
        }
    }

    public static void run(int N) {
        if(N == 1){
            System.out.println(1);
            return;
        }
        if (N == 2) {
            System.out.println(2);
            return;
        }
        if (N == 3) {
            System.out.println(4);
            return;
        }
        int[] dp = new int[N + 1];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;
        for (int i = 4; i <= N; i++) {
            dp[i] = dp[i - 3] + dp[i - 2] + dp[i - 1];
        }
        System.out.println(dp[N]);
    }
}
