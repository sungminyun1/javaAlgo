package barkingdog.ch13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P1654 {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static long[] arr;
    public static int K, N;
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        K = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        arr = new long[K];
        for (int i = 0; i < K; i++) {
            arr[i] = Long.parseLong(br.readLine());
        }
        Arrays.sort(arr);

        long left = 0;
        long right = arr[K - 1];
        long ans = 0;

        while(left < right){
            long mid = (left + right) / 2;
            int count = 0;
            for (long i : arr) {
                count += (int) Math.floor(i / mid);
            }
            if (count >= N) {
                ans = Math.max(ans, mid);
                left = mid + 1;
            } else{
                right = mid;
            }
        }
        System.out.println(ans);

    }
}
