package barkingdog.ch13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P2805 {
    public static int N,M;
    public static long[] arr;
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new long[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }
        Arrays.sort(arr);

        long ans = 0, l = 1, r = arr[N - 1];
        while (l <= r) {
            long m = (l + r) / 2;
            long sum = 0;
            for (long i : arr) {
                if(i - m > 0){
                    sum += i - m;
                }
            }
            if (sum >= M) {
                ans = Math.max(m, ans);
                l = m + 1;
            }else{
                r = m - 1;
            }
        }
        System.out.println(ans);
    }
}
