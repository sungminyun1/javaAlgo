package barkingdog.ch10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P11727 {
    public static int T = 10_007;
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static int N;
    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        int[] DP = new int[1001];
        DP[0] = 1;
        DP[1] = 3;
        for (int i = 2; i < N; i++) {
            DP[i] = ((DP[i - 2] * 2) % T + DP[i - 1]) % T;
        }
        System.out.println(DP[N - 1]);
    }
}
