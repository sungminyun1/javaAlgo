package barkingdog.ch03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P3273 {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());

        StringTokenizer st2 = new StringTokenizer(br.readLine());
        int target = Integer.parseInt(st2.nextToken());
        boolean[] check = new boolean[2000000];

        int ans = 0;
        for (int i = 0; i < n; i++) {
            int now = Integer.parseInt(st.nextToken());
            if (target - now >= 0 && check[target - now]) {
                ans ++;
            }
            check[now] = true;
        }

        System.out.println(ans);
    }
}
