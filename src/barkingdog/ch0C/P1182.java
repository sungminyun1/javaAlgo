package barkingdog.ch0C;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1182 {
    public static int N, S;
    public static int[] arr;
    public static int ans = 0;
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        run(0, 0);
        System.out.println(ans);
    }

    public static void run(int start, int val) {
        if(start > N) return;
        if(val == S && start > 0) ans++;

        for (int i = start; i < N; i++) {
            run(i + 1, val + arr[i]);
        }
    }
}
