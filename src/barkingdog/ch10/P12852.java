package barkingdog.ch10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P12852 {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        int[][] dp = new int[N + 1][2];

        for (int i = 1; i <= N; i++) {
            int ti = i * 3;
            if(ti <= N){
                if(dp[ti][0]  == 0){
                    dp[ti][0] = dp[i][0] + 1;
                    dp[ti][1] = i;
                }else if(dp[ti][0] > dp[i][0]){
                    dp[ti][0] = dp[i][0] + 1;
                    dp[ti][1] = i;
                }
            }

            int di = i * 2;
            if(di <= N){
                if(dp[di][0]  == 0){
                    dp[di][0] = dp[i][0] + 1;
                    dp[di][1] = i;
                }else if(dp[di][0] > dp[i][0]){
                    dp[di][0] = dp[i][0] + 1;
                    dp[di][1] = i;
                }
            }

            int ni = i + 1;
            if(ni <= N){
                if(dp[ni][0]  == 0){
                    dp[ni][0] = dp[i][0] + 1;
                    dp[ni][1] = i;
                }else if(dp[ni][0] > dp[i][0]){
                    dp[ni][0] = dp[i][0] + 1;
                    dp[ni][1] = i;
                }
            }
        }

        System.out.println(dp[N][0]);
        StringBuilder sb = new StringBuilder();
        int now = N;
        while (now >= 1) {
            sb.append(now + " ");
            now = dp[now][1];
        }
        System.out.println(sb);
    }
}
