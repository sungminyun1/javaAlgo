package barkingdog.ch10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P1699 {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        int ans = 0;
        while (N > 0) {
            int t = (int) Math.sqrt(N);
            ans++;
            N -= (t * t);
        }
        System.out.println(ans);
    }
}
