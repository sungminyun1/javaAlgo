package barkingdog.ch10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P1463 {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            int ti = i * 3;
            int di = i * 2;
            int ni = i + 1;
            if(ti <= N && ( dp[ti] == 0 || dp[ti] > dp[i]+1)) dp[ti] = dp[i] + 1;
            if(di <= N &&( dp[di] == 0 || dp[di] > dp[i]+1)) dp[di] = dp[i] + 1;
            if(ni <= N && ( dp[ni] == 0 || dp[ni] > dp[i]+1)) dp[ni] = dp[i] + 1;
        }
        System.out.println(dp[N]);
    }
}
